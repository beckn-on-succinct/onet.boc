package in.succinct.beckn.boc;

import in.succinct.beckn.Address;

public class BankAccount extends in.succinct.beckn.BankAccount implements AddressHolder {
    public BankAccount() {
    }
    public Address getAddress(){
        return super.getAddress();
    }
    public void setAddress(Address address){
        AddressHolder.super.setAddress(address);
    }
}
