package in.succinct.beckn.boc;

public class Scalar extends in.succinct.beckn.Scalar {
    public Scalar() {
    }

    @Override
    public void set(String key, Double value) {
        super.set(key,(Number)value);
    }

}
