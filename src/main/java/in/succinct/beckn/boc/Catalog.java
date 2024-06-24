package in.succinct.beckn.boc;

import in.succinct.beckn.Categories;
import in.succinct.beckn.Descriptor;
import in.succinct.beckn.Fulfillments;
import in.succinct.beckn.Payments;
import in.succinct.beckn.Providers;

public class Catalog extends in.succinct.beckn.Catalog {
    public Descriptor getDescriptor(){
        return get(Descriptor.class, "descriptor");
    }
    public void setDescriptor(Descriptor descriptor){
        set("descriptor",descriptor);
    }

    public Providers getProviders(){
        return get(Providers.class, "providers");
    }
    public void setProviders(Providers providers){
        set("providers",providers);
    }

    public Fulfillments getFulfillments(){
        return get(Fulfillments.class, "fulfillments");
    }
    public void setFulfillments(Fulfillments fulfillments){
        set("fulfillments",fulfillments);
    }

    public Categories getCategories(){
        return get(Categories.class, "categories");
    }
    public void setCategories(Categories categories){
        set("categories",categories);
    }


    public Payments getPayments(){
        return get(Payments.class, "payments");
    }
    public void setPayments(Payments payments){
        set("payments",payments);
    }

}
