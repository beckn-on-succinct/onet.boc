package in.succinct.beckn.boc;

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

}
