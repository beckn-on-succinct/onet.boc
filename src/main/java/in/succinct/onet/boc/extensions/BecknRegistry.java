package in.succinct.onet.boc.extensions;

import com.venky.swf.db.annotations.column.ui.mimes.MimeType;
import com.venky.swf.integration.api.Call;
import com.venky.swf.integration.api.HttpMethod;
import com.venky.swf.routing.Config;
import in.succinct.onet.core.adaptor.NetworkAdaptor;
import in.succinct.onet.core.adaptor.NetworkAdaptorFactory;
import in.succinct.onet.core.adaptor.NetworkApiAdaptor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class BecknRegistry extends BocRegistry {
    static {
        if (isEnabled("beckn_open")) {
            NetworkAdaptorFactory.getInstance().registerAdaptor(new BecknRegistry());
        }
    }

    public BecknRegistry(){
        super("beckn_open");
    }

}
