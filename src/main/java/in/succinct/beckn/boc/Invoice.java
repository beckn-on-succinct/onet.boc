package in.succinct.beckn.boc;

import org.json.simple.JSONObject;

public class Invoice extends in.succinct.beckn.Invoice {
    public Invoice() {
    }
    
    public Invoice(String payload) {
        super(payload);
    }
    
    public Invoice(JSONObject object) {
        super(object);
    }
}
