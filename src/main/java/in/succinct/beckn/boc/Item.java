package in.succinct.beckn.boc;

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

}
