package in.succinct.beckn.boc;

import in.succinct.beckn.BecknStrings;
import in.succinct.beckn.ItemQuantity;
import in.succinct.beckn.TagGroups;
import in.succinct.beckn.Tags;
import org.json.simple.JSONObject;

public class Item extends in.succinct.beckn.Item {
    @Override
    public boolean isExtendedAttributesDisplayed(){
        return false;
    }

    public Item() {
        super();
    }

    public Item(JSONObject item) {
        super(item);
    }

    @Override
    public void setCategoryIds(BecknStrings category_ids) {
        set("category_ids",category_ids);
    }

    @Override
    public BecknStrings getCategoryIds() {
        return get(BecknStrings.class, "category_ids");
    }

    @Override
    public BecknStrings getFulfillmentIds() {
        return get(BecknStrings.class,"fulfillment_ids");
    }

    @Override
    public void setFulfillmentIds(BecknStrings fulfillment_ids) {
        set( "fulfillment_ids", fulfillment_ids);
    }

    @Override
    public void setLocationIds(BecknStrings location_ids) {
        set("location_ids",location_ids);
    }

    @Override
    public BecknStrings getLocationIds() {
        return get(BecknStrings.class, "location_ids");
    }

    @Override
    public BecknStrings getPaymentIds() {
        return get(BecknStrings.class, "payment_ids");
    }

    @Override
    public void setPaymentIds(BecknStrings payment_ids) {
        set("payment_ids",payment_ids);
    }
}
