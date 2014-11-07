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
}

/*
arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
    Copies an array from the specified source array, 
    beginning at the specified position, 
    to the specified position of the destination array.
*/
