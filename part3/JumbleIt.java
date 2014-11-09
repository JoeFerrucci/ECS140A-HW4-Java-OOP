// JumbleIt from SeqIt

public class JumbleIt implements SeqIt {

    protected Jumble thisJumble;
    protected int thisMax;
    protected int thisCount;

    JumbleIt(Jumble s) {
        thisJumble = new Jumble(s.values);
        thisMax = s.numElements;
        thisCount = 0;
    }

    // any more elements?
    public boolean hasNext() {
        return thisCount < thisMax;
    }

    // return the next element and advance iterator to following item.
    public int next() {
        if (!hasNext()) {
            System.err.println("JumbleIt called past end");
            System.exit(1);
        }
        // thisCount++;  // increment after return
        return thisJumble.values[thisCount++];
    }

}