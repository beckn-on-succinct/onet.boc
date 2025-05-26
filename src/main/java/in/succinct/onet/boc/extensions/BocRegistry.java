package in.succinct.onet.boc.extensions;

import com.venky.core.util.ObjectUtil;
import com.venky.swf.db.annotations.column.ui.mimes.MimeType;
import com.venky.swf.db.model.status.RouterStatus;
import com.venky.swf.db.model.status.ServerStatus;
import com.venky.swf.integration.api.Call;
import com.venky.swf.integration.api.HttpMethod;
import com.venky.swf.plugins.background.core.IOTask;
import com.venky.swf.plugins.background.core.RetryTask;
import com.venky.swf.plugins.background.core.Task;
import com.venky.swf.plugins.background.core.TaskManager;
import com.venky.swf.routing.Router;
import in.succinct.onet.core.adaptor.NetworkAdaptor;
import in.succinct.onet.core.adaptor.NetworkApiAdaptor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

public class BocRegistry extends NetworkAdaptor {
    protected BocRegistry(String networkName){
        super(networkName);
        TaskManager.instance().executeAsync(
                new Task() {
                    @Override
                    public void execute() {
                        try {
                            Thread.currentThread().wait(5000);
                        }catch (InterruptedException ex){
                            //
                        }finally {
                            ServerStatus serverStatus  = new ServerStatus();
                            Router.instance().status(serverStatus);
                            if (serverStatus.getRouterStatus() == RouterStatus.initialized) {
                                loadDomains();
                            }else if (serverStatus.getRouterStatus() != RouterStatus.failed){
                                TaskManager.instance().executeAsync(this,false);
                            }
                        }
                    }
                },false);
        
    }

    private NetworkApiAdaptor apiAdaptor;
    @Override
    public NetworkApiAdaptor getApiAdaptor() {
        if (apiAdaptor != null){
            return apiAdaptor;
        }
        synchronized (this) {
            if (apiAdaptor == null) {
                apiAdaptor = super.getApiAdaptor();
            }
        }
        return apiAdaptor;
    }
    
    @Override
    public Domains getDomains() {
        if (!areDomainsLoaded()){
            loadDomains();
        }
        return super.getDomains();
    }
    boolean areDomainsLoaded(){
        return get("domains") != null;
    }
    
    @SuppressWarnings("unchecked")
    private void loadDomains(){
        if (areDomainsLoaded()){
            return;
        }
        

        JSONArray array = new Call<JSONObject>().url(getBaseUrl(),"/network_domains").method(HttpMethod.GET).
                headers(new HashMap<>(){{
                    put("content-type", MimeType.APPLICATION_JSON.toString());
                    put("ApiKeyCase","SNAKE");
                    put("ApiRootRequired","N");
                }}).getResponseAsJson();
        if (array != null){
            Domains domains = new Domains();
            setDomains(domains);
            for (Object o : array) {
                JSONObject object = (JSONObject) o;
                Domain domain = new Domain();
                domain.setId((String) object.get("name"));
                domain.setName((String) object.getOrDefault("code", object.get("description")));
                String domainCategory = (String) object.get("domain_category");
                if (!ObjectUtil.isVoid(domainCategory)) {
                    domain.setDomainCategory(DomainCategory.valueOf(domainCategory));
                }
                domain.setSchema((String) object.get("schema_url"));
                domain.setExtensionPackage(String.format("%s.%s", getExtensionPackage(), domain.getName()));
                domains.add(domain);
            }
        }
    }
}
