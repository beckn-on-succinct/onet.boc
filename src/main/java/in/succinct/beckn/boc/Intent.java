package in.succinct.beckn.boc;

import in.succinct.beckn.TagGroups;
import in.succinct.beckn.Tags;

public class Intent extends in.succinct.beckn.Intent {
    @Override
    public void setTags(TagGroups tags) {
        Tags tags1 = new Tags();
        tags.forEach(tg->{
            tags1.set(tg.getName(),tg.getValue());
        });
        set("tags",tags1);
    }

    @Override
    public TagGroups getTags(){
        Tags tags = get(Tags.class,"tags");
        TagGroups groups = null;
        if (tags != null) {
            groups = new TagGroups();
            for (Object o : tags.getInner().keySet()) {
                groups.setTag("general_attributes", String.valueOf(o), String.valueOf(tags.getInner().get(o)));
            }
        }
        return groups;
    }
}
