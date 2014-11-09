// DeltaIt from SeqIt

public class DeltaIt implements SeqIt {

    protected Delta thisDelta;
    protected int thisMax;
    protected int thisCount;
    

    // associate an iterator with a Constant object.
    DeltaIt(Delta s) {
        thisDelta = new Delta(s.num, s.initial, s.delta);
        thisMax = s.num;
        thisCount = 0;
    }

    // any more elements?
    public boolean hasNext() {
        return thisCount < thisMax;
    }

    // return the next element and advance iterator to following item.
    public int next() {
        if (!hasNext()) {
            System.err.println("DeltaIt called past end");
            System.exit(1);
        }
        int nextValue = 0;
        nextValue = (thisDelta.initial + thisCount * thisDelta.delta);
        thisCount++; // increment AFTER calculating next value.
        return nextValue;
    }

}


/*  
Examples:
    Delta(4, 1, 1);     // num=4, initial=1, delta=1  -> (1,2,3,4) 
    Delta(4, 1, -1);    // num=4, initial=2, delta=-1 -> (1,0,-1,-2)
    Delta(3, 21, 1);    // num=3, initial=21, delta=1 -> (21,22,23)
*/