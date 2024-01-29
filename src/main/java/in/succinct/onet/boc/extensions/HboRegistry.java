package in.succinct.onet.boc.extensions;

import in.succinct.onet.core.adaptor.NetworkAdaptor;
import in.succinct.onet.core.adaptor.NetworkAdaptorFactory;

public class HboRegistry extends NetworkAdaptor {
    static {
        NetworkAdaptorFactory.getInstance().registerAdaptor(new HboRegistry());
    }

    public HboRegistry(){
        super("hbo");
    }

}
