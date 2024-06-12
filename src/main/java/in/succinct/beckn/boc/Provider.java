package in.succinct.beckn.boc;

import in.succinct.beckn.TagGroups;
import in.succinct.beckn.Tags;

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
