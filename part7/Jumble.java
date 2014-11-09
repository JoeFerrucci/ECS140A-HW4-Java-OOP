// the Jumble base class

public class Jumble extends Seq {

    protected int [] values;
    protected int numElements;

    Jumble(int [] argValues) {
        numElements = argValues.length;
        values = new int [argValues.length];
        System.arraycopy(argValues, 0, values, 0, argValues.length);
    }
    
    public String toString() {
        String toPrint = "{ " + numElements + " : ";
        for (int i : values) {
            toPrint += i + " ";
        }
        toPrint += "}";
        return toPrint;
    }

    public int min() {
        int minimum;
        if (values.length == 0) {
            return 0;
        } else {
            minimum = values[0];
            for (int i : values) {
                if (i < minimum) {
                    minimum = i;
                }
            }
        }
        return minimum;
    }

    public SeqIt createSeqIt() {
        return new JumbleIt(this);
    }

}
