package in.succinct.beckn.boc;

import in.succinct.beckn.FulfillmentStop;
import in.succinct.beckn.FulfillmentStops;
import in.succinct.beckn.TagGroupHolder;
import in.succinct.beckn.TagGroups;
import in.succinct.beckn.Tags;

public class Fulfillment extends in.succinct.beckn.Fulfillment {
    public Fulfillment(){
        super();
    }
    @Override
    public boolean isExtendedAttributesDisplayed(){
        return false;
    }

    @Override
    public FulfillmentStop getStart() {
        FulfillmentStops stops = getFulfillmentStops();
        if (stops == null ){
            stops = new FulfillmentStops();
            setFulfillmentStops(stops);
        }
        if (stops.isEmpty()){
            return null;
        }

        return stops.get(0);
    }

    @Override
    public void setStart(FulfillmentStop start) {
        FulfillmentStops stops = getFulfillmentStops();
        if (stops == null ){
            stops = new FulfillmentStops();
            setFulfillmentStops(stops);
        }
        if (stops.isEmpty()){
            stops.add(start);
        }else {
            if (stops.size() > 1) {
                stops.remove(0);
            }
            stops.insert(0, start);
        }
    }

    @Override
    public void setEnd(FulfillmentStop end) {
        FulfillmentStops stops = getFulfillmentStops();
        if (stops == null ){
            stops = new FulfillmentStops();
            setFulfillmentStops(stops);
        }
        if (stops.size() > 1){
            stops.remove(stops.size()-1);
            stops.add(end);
        }
    }

    @Override
    public FulfillmentStop getEnd() {
        FulfillmentStops stops = getFulfillmentStops();
        if (stops == null ){
            stops = new FulfillmentStops();
            setFulfillmentStops(stops);
        }
        if (stops.size() <= 1 ){
            return null;
        }

        return stops.get(stops.size()-1);
    }
}
