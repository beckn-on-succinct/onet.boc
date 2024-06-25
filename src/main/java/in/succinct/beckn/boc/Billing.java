package in.succinct.beckn.boc;

import in.succinct.beckn.Address;

public class Billing extends in.succinct.beckn.Billing implements AddressHolder {
    public Billing() {
    }

    public Address getAddress(){
        return super.getAddress();
    }
    public void setAddress(Address address){
        AddressHolder.super.setAddress(address);
    }
}
