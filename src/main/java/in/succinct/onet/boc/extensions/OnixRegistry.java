package in.succinct.onet.boc.extensions;

import com.venky.swf.routing.Config;
import in.succinct.onet.core.adaptor.NetworkAdaptorFactory;

import java.util.HashSet;
import java.util.Set;

public class OnixRegistry extends BocRegistry {
    static final Set<String> WELL_KNOWN_NETWORKS = new HashSet<String>(){{
        add("beckn_open");
        add("hbo");
        add("gex");
        add("openamsterdam");
    }};
    static final String ONIX =  Config.instance().getProperty("in.succinct.onet.name","onix");

    static {
        if (!WELL_KNOWN_NETWORKS.contains(ONIX) && isEnabled(ONIX)) {
            NetworkAdaptorFactory.getInstance().registerAdaptor(new OnixRegistry());
        }
    }

    public OnixRegistry(){
        super(ONIX);
    }

}
