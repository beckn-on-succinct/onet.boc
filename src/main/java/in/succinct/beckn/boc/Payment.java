package in.succinct.beckn.boc;

import in.succinct.beckn.Fulfillment.FulfillmentStatus;

public class Payment extends in.succinct.beckn.Payment {
    @Override
    public boolean isExtendedAttributesDisplayed(){
        return false;
    }

    public Payment(){
        super();
    }
    public Payment(String payload){
        super(payload);
    }
    public String getUri(){
        return get("url");
    }
    public void setUri(String uri){
        set("url",uri);
    }

    public CollectedBy getCollectedBy(){
        String s = get("collected_by");
        return s == null ? null : CollectedBy.valueOf(s);
    }

    public void setCollectedBy(CollectedBy collected_by){
        set("collected_by",collected_by == null ? null : collected_by.toString());
    }
    
    @Override
    public FulfillmentStatus getInvoiceEvent() {
        return super.getInvoiceEvent();
    }
    
    @Override
    public void setInvoiceEvent(FulfillmentStatus event) {
        super.setInvoiceEvent(event);
    }
    
}
