package in.succinct.beckn.boc;

import in.succinct.beckn.Address;

public class Organization extends in.succinct.beckn.Organization implements AddressHolder {
    public Organization() {
    }

    public String getName(){
        return getDescriptor(true).getName();
    }

    public void setName(String name) {
        getDescriptor(true).setName(name);
    }
    public String getEmail(){
        return getContact(true).getEmail();
    }
    public void setEmail(String email){
        getContact(true).set("email",email);
    }


    public Address getAddress(){
        return super.getAddress();
    }
    public void setAddress(Address address){
        AddressHolder.super.setAddress(address);
    }
}
