package in.succinct.beckn.boc;

import in.succinct.beckn.Address;
import in.succinct.beckn.City;
import in.succinct.beckn.Country;
import in.succinct.beckn.State;

@SuppressWarnings("all")
public interface AddressHolder  extends in.succinct.beckn.AddressHolder {
    @Override
    default void setAddress(Object oAddress) {
        if (oAddress instanceof String) {
            set("address", (String) oAddress);
        } else {
            Address address = (Address)oAddress;
            set("address", address.flatten());
            if (address.getCity() != null) {
                setCity(new City() {{
                    setCode(address.getCity());
                }});

            }
            if (address.getCountry() != null){
                setCountry(new Country(){{
                    setCode(address.getCountry());
                }});
            }
            if (address.getState() != null){
                setState(new State(){{
                    setCode(address.getState());
                }});
            }
            if (address.getPinCode() != null){
                setPinCode(address.getPinCode());
            }
        }
    }



}
