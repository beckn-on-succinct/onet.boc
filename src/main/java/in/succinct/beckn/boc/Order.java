package in.succinct.beckn.boc;

import in.succinct.beckn.Fulfillments;
import in.succinct.beckn.TagGroups;

import java.util.HashMap;
import java.util.Map;

public class Order extends in.succinct.beckn.Order {
    @Override
    public boolean isExtendedAttributesDisplayed(){
        return false;
    }

    public Order() { super(); }


    static final Map<String,Status> STRING_TO_ORDER_STATUS = new HashMap<>(){{
        put("INITIATED",Status.Created);
        put("AWAITING_ACCEPTANCE",Status.Awaiting_Acceptance);
        put("ACKNOWLEDGED",Status.Accepted);
        put("PACKED",Status.Prepared);
        put("SHIPPED",Status.In_Transit);
        put("DELIVERED",Status.Completed);
        put("CANCELLED",Status.Cancelled);
    }};
    static final Map<Status,String> ORDER_STATUS_TO_STRING = new HashMap<>(){{
        for (Entry<String,Status> stringToOrderStatusEntry : STRING_TO_ORDER_STATUS.entrySet()) {
            String s = stringToOrderStatusEntry.getKey();
            Status status = STRING_TO_ORDER_STATUS.get(s);
            put(status,s);
        }
    }};
    @Override
    public Status getStatus() {
        String s = get("status");
        return   STRING_TO_ORDER_STATUS.get(s);
    }
    @Override
    public void setStatus(Status status){
        String s = ORDER_STATUS_TO_STRING.get(status);
        if (s == null){
            rm("status");
        }else {
            set("status",s);
        }
    }





}
