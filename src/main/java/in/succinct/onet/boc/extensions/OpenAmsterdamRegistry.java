package in.succinct.onet.boc.extensions;

import in.succinct.onet.core.adaptor.NetworkAdaptorFactory;

public class OpenAmsterdamRegistry extends BocRegistry {
    static {
        NetworkAdaptorFactory.getInstance().registerAdaptor(new OpenAmsterdamRegistry());
    }

    public OpenAmsterdamRegistry(){
        super("openamsterdam");
    }

}
