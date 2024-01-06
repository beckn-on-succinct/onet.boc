package in.succinct.beckn.boc;

import in.succinct.beckn.Category.CategoryCode;

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
        put("ACKNOWLEDGED",Status.Accepted);
        put("PACKED", Status.In_progress);
        put("SHIPPED",Status.Out_for_delivery);
        put("DELIVERED",Status.Completed);
    }};
    static final Map<Status,String> ORDER_STATUS_TO_STRING = new HashMap<>(){{
        for (Entry<String,Status> stringToOrderStatusEntry : STRING_TO_ORDER_STATUS.entrySet()) {
            String s = stringToOrderStatusEntry.getKey();
            Status status = STRING_TO_ORDER_STATUS.get(s);
            put(status,s);
        }
    }};
    @Override
    public Status getState() {
        String s = get("state");
        Status status =  STRING_TO_ORDER_STATUS.get(s);
        if (status == null){
            status = super.getState();
        }
        return status;
    }
    @Override
    public void setState(Status state){
        String s = ORDER_STATUS_TO_STRING.get(state);
        if (s == null){
            super.setState(state);
        }else {
            set("state",s);
        }
    }

}
