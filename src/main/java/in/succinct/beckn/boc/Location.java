package in.succinct.beckn.boc;

import in.succinct.beckn.Address;

public class Location extends in.succinct.beckn.Location implements AddressHolder{
    public Location() {
    }

    public Location(String payload) {
        super(payload);
    }

    public Address getAddress(){
        return super.getAddress();
    }
    public void setAddress(Address address){
        AddressHolder.super.setAddress(address);
    }
}
