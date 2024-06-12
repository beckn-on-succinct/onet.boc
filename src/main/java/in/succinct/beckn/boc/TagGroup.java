package in.succinct.beckn.boc;

import in.succinct.beckn.Descriptor;

public class TagGroup extends in.succinct.beckn.TagGroup {
    public TagGroup() {
    }

    public TagGroup(String code, Object value) {
        super(code, value);
    }

    public TagGroup(String code, String name, Object value) {
        super(code, name, value);
    }

    @Override
    public void setId(String id) {
        getDescriptor().setCode(id);
    }

    @Override
    public String getId() {
        return getDescriptor().getCode();
    }

    public Descriptor getDescriptor(){
        return get(Descriptor.class, "descriptor",true);
    }
    public void setDescriptor(Descriptor descriptor){
        set("descriptor",descriptor);
    }

}
