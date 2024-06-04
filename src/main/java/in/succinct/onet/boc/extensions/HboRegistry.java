package in.succinct.onet.boc.extensions;

import com.venky.swf.routing.Config;
import in.succinct.onet.core.adaptor.NetworkAdaptorFactory;

public class HboRegistry extends BocRegistry {
    static {
        if (isEnabled("hbo")) {
            NetworkAdaptorFactory.getInstance().registerAdaptor(new HboRegistry());
        }
    }

    public HboRegistry(){
        super("hbo");
    }

}
