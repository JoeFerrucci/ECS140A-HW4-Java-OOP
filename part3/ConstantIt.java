// ConstantIt from SeqIt

public class ConstantIt implements SeqIt {

    protected Constant thisConstant;
    protected int thisMax;
    protected int thisCount;

    // associate an iterator with a Constant object.
    ConstantIt(Constant s) {
        thisConstant = new Constant(s.num, s.value);
        thisCount = 0;
        thisMax = s.num;
    }

    // any more elements?
    public boolean hasNext() {
        return thisCount < thisMax;
    }

    // return the next element and advance iterator to following item.
    public int next() {
        if (!hasNext()) { /* ERROR */
            System.err.println("ConstantIt called past end");
            System.exit(1);
        }
        thisCount++;
        return thisConstant.value;
    }

}
