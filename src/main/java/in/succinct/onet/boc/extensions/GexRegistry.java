package in.succinct.onet.boc.extensions;

import in.succinct.onet.core.adaptor.NetworkAdaptorFactory;

public class GexRegistry extends BocRegistry {
    static {
        if (isEnabled("gex")) {
            NetworkAdaptorFactory.getInstance().registerAdaptor(new GexRegistry());
        }
    }

    public GexRegistry(){
        super("gex");
    }

}
