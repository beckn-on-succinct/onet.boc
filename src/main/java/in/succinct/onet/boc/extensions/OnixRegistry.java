package in.succinct.onet.boc.extensions;

import com.venky.swf.routing.Config;
import in.succinct.onet.core.adaptor.NetworkAdaptorFactory;

public class OnixRegistry extends BocRegistry {
    static {
        if (isEnabled(Config.instance().getProperty("in.succinct.onet.name","beckn_open"))) {
            NetworkAdaptorFactory.getInstance().registerAdaptor(new OnixRegistry());
        }
    }

    public OnixRegistry(){
        super(Config.instance().getProperty("in.succinct.onet.name","beckn_open"));
    }

}
