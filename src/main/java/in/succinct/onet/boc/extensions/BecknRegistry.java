package in.succinct.onet.boc.extensions;

import com.venky.swf.db.annotations.column.ui.mimes.MimeType;
import com.venky.swf.integration.api.Call;
import com.venky.swf.integration.api.HttpMethod;
import in.succinct.bpp.core.adaptor.NetworkAdaptor;
import in.succinct.bpp.core.adaptor.NetworkAdaptorFactory;
import in.succinct.bpp.core.adaptor.api.NetworkApiAdaptor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class BecknRegistry extends NetworkAdaptor{
    static {
        NetworkAdaptorFactory.getInstance().registerAdaptor(new BecknRegistry());
    }

    public BecknRegistry(){
        super("beckn_open");
        loadDomains();
    }

    private transient final BocApiAdaptor bocApiAdaptor = new BocApiAdaptor(this);



    private void loadDomains(){
        Domains domains = getDomains();
        if (domains != null){
            return;
        }
        domains = new Domains();
        setDomains(domains);

        JSONArray array = new Call<JSONObject>().url(getBaseUrl(),"/network_domains").method(HttpMethod.GET).
        header("content-type", MimeType.APPLICATION_JSON.toString()).getResponseAsJson();
        for (int i = 0 ; array != null && i< array.size() ; i ++ ){
            JSONObject object = (JSONObject) array.get(i);
            Domain domain = new Domain();
            domain.setId((String)object.get("name"));
            domain.setName((String)object.get("description"));
            domain.setSchema((String)object.get("schema_url"));
            domain.setExtensionPackage(getExtensionPackage());
            domains.add(domain);
        }
    }


    @Override
    public NetworkApiAdaptor getApiAdaptor() {
        return bocApiAdaptor;
    }
}
