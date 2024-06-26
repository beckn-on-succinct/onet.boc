package in.succinct.beckn.boc;

import com.venky.core.util.ObjectUtil;
import in.succinct.beckn.PaymentType;

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
    public PaymentType getType(){
        return getEnum(PaymentType.class, "type",new PaymentTypeConvertor());
    }
    @Override
    public void setType(PaymentType payment_type){
        setEnum("type",payment_type,new PaymentTypeConvertor());
    }

    private static class PaymentTypeConvertor extends EnumConvertor<PaymentType> {
        @Override
        public String toString(PaymentType value) {
            return value == PaymentType.ON_ORDER ? "PRE_ORDER" : super.toString(value);
        }

        @Override
        public PaymentType valueOf(String enumRepresentation) {
            return super.valueOf(ObjectUtil.equals(enumRepresentation,"PRE-ORDER") ? "ON_ORDER"  : enumRepresentation );
        }
    }
}
