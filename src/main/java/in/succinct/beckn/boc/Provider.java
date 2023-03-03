package in.succinct.beckn.boc;

public class Provider extends in.succinct.beckn.Provider {
    @Override
    public boolean isExtendedAttributesDisplayed(){
        return false;
    }

    public Provider(){
        super();
    }
    public Provider(String payload){
        super(payload);
    }



}
