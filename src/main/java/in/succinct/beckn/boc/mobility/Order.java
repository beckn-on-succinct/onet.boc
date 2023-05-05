package in.succinct.beckn.boc.mobility;

import java.util.HashMap;
import java.util.Map;

public class Order extends in.succinct.beckn.Order {
    @Override
    public boolean isExtendedAttributesDisplayed(){
        return false;
    }

    public Order() { super(); }

    static final Map<Status,String> statusLiteralMap = new HashMap<>(){{
        put(Status.Awaiting_Agent_Acceptance ,"Awaiting Driver acceptance");
        put(Status.Reaching_Pickup_Location,"Reaching Pickup location");
        put(Status.Reached_Pickup_Location,"Reached Pickup location");
        put(Status.Created,"Not Confirmed");
        put(Status.Accepted,"Confirmed");
        put(Status.In_progress,"Started");
        put(Status.Completed,"Ended");
        put(Status.Cancelled,"Cancelled");
    }};
    static final Map<String,Status> literalStatusMap = new HashMap<>(){{
        statusLiteralMap.forEach((s,l)->put(l,s));
    }};

    public Status getStatus(){
        String s = get("status");
        return s== null ? null :  literalStatusMap.get(s);
    }
    public void setStatus(Status status){
        set("status",status == null ? null : statusLiteralMap.get(status));
    }


}
