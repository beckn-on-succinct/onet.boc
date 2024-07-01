package in.succinct.onet.boc.extensions;

import com.venky.swf.db.annotations.column.ui.mimes.MimeType;
import com.venky.swf.integration.api.Call;
import com.venky.swf.integration.api.HttpMethod;
import com.venky.swf.plugins.background.core.IOTask;
import com.venky.swf.plugins.background.core.TaskManager;
import in.succinct.onet.core.adaptor.NetworkAdaptor;
import in.succinct.onet.core.adaptor.NetworkApiAdaptor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;

public class BocRegistry extends NetworkAdaptor {
    protected BocRegistry(String networkName){
        super(networkName);
        TaskManager.instance().executeAsync((IOTask)()->{
            loadDomains();
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


    @SuppressWarnings("unchecked")
    private void loadDomains(){
        Domains domains = getDomains();
        if (domains != null){
            return;
        }
        domains = new Domains();
        setDomains(domains);

        JSONArray array = new Call<JSONObject>().url(getBaseUrl(),"/network_domains").method(HttpMethod.GET).
                headers(new HashMap<>(){{
                    put("content-type", MimeType.APPLICATION_JSON.toString());
                    put("ApiKeyCase","SNAKE");
                    put("ApiRootRequired","N");
                }}).getResponseAsJson();
        for (int i = 0 ; array != null && i< array.size() ; i ++ ){
            JSONObject object = (JSONObject) array.get(i);
            Domain domain = new Domain();
            domain.setId((String)object.get("name"));
            domain.setName((String)object.getOrDefault("code",object.get("description")));
            domain.setSchema((String)object.get("schema_url"));
            domain.setExtensionPackage(String.format("%s.%s",getExtensionPackage(),domain.getName()));
            domains.add(domain);
        }
    }
}
