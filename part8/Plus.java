// Plus Class - Find the difference in successive elements to determine type of sequence:

/*
 *  Constant:   If the delta is zero (0).
 *  Delta:      If the delta is a constant delta != zero (0).
 *  Jumble:     If the delta is inconsistent throughout (It could be geometric but that is out of this scope right now).
 */

public class Plus {

    public static Seq plus(Seq s1, Seq s2) {

        int delta = 0;
        int oldSum = 0;
        int initial = 0;
        int newSize = 0;
        boolean isJumble = false;
        SeqIt iter1 = s1.createSeqIt();
        SeqIt iter2 = s2.createSeqIt();

        /* First */
        try {
            if(iter1.hasNext() && iter2.hasNext()) {
                initial = oldSum = iter1.next() + iter2.next();
                newSize++;
            }
        }
        catch (UsingIteratorPastEndException err) {
            System.err.println(err);
        }

        /* Second */
        try {
            if(iter1.hasNext() && iter2.hasNext()) {
                int secondSum = iter1.next() + iter2.next();
                delta = secondSum - oldSum;
                oldSum = secondSum;
                newSize++;
            }
        }
        catch (UsingIteratorPastEndException err) {
            System.err.println(err);
        }

        while(iter1.hasNext() && iter2.hasNext()) {
            /* Compute the sum and compare delta */
            newSize++;
            try {
                int currSum = iter1.next() + iter2.next();
                if (oldSum + delta != currSum) {
                    isJumble = true;
                }
                oldSum = currSum; // reset
            } 
            catch (UsingIteratorPastEndException err) {
                System.err.println(err);
            }
        }

        /* Time to dispatch correct implementation */
        if (isJumble) {

            int [] newArray = new int[newSize];

            for (int i = 0; i != newSize; i++) {
                newArray[i] = ((Jumble)s1).values[i] + ((Jumble)s2).values[i];
            }

            return new Jumble(newArray);

        } 

        else if (delta != 0) {

            return new Delta(newSize, initial, delta);

        } 

        else {
            return new Constant(newSize, oldSum);
        }
    }


    /* From Part 7: */
    
    // public static Seq plus(Constant left, Constant right) {
    //     int newSize = Math.min(left.num, right.num); 
    //     int newInitialValue = left.value + right.value;
    //     return new Constant(newSize, newInitialValue);
    // }

    // public static Seq plus(Delta left, Delta right) {
    //     int newSize = Math.min(left.num, right.num); 
    //     int newInitialValue = left.initial + right.initial;
    //     int newDelta = left.delta + right.delta;
    //     if (newDelta == 0 || newSize == 0) {
    //         return new Constant(newSize, newInitialValue);
    //     return new Delta(newSize, newInitialValue, newDelta);
    // }

    // public static Seq plus(Jumble left, Jumble right) {
    //     int newSize = Math.min(left.numElements, right.numElements);
    //     int [] newArray = new int[newSize];
    //     for (int i = 0; i != newSize; i++) {
    //         newArray[i] = left.values[i] + right.values[i];
    //     }
    //     return new Jumble(newArray);
    // }

    // /*
    //  * Part 7: 
    //  */
    // public static Seq plus(Constant left, Delta right) {
    //     int newSize = Math.min(left.num, right.num);
    //     int newInitialValue = left.value + right.initial;
    //     return new Delta(newSize, newInitialValue, right.delta);
    // }

    // public static Seq plus(Delta left, Constant right) {
    //     int newSize = Math.min(left.num, right.num);
    //     int newInitialValue = left.initial + right.value;
    //     return new Delta(newSize, newInitialValue, left.delta);
    // }

    // public static Seq plus(Constant left, Jumble right) {
    //     int newSize = Math.min(left.num, right.numElements);
    //     int [] newArray = new int[newSize];
    //     for (int i = 0; i != newSize; i++) {
    //         newArray[i] = left.value + right.values[i];
    //     }
    //     return new Jumble(newArray);
    // }

    // public static Seq plus(Jumble left, Constant right) {
    //     int newSize = Math.min(left.numElements, right.num);
    //     int [] newArray = new int[newSize];
    //     for (int i = 0; i != newSize; i++) {
    //         newArray[i] = left.values[i] + right.value;
    //     }
    //     return new Jumble(newArray);
    // }

    // public static Seq plus(Delta left, Jumble right) {
    //     int newSize = Math.min(left.num, right.numElements);
    //     int [] newArray = new int[newSize];
    //     int temp = left.initial; 
    //     for (int i = 0; i != newSize; i++) {
    //         newArray[i] = temp + right.values[i];
    //         temp = temp + left.delta;
    //     }
    //     return new Jumble(newArray);
    // }

    // public static Seq plus(Jumble left, Delta right) {
    //     int newSize = Math.min(left.numElements, right.num);
    //     int [] newArray = new int[newSize];
    //     int temp = right.initial; 
    //     for (int i = 0; i != newSize; i++) {
    //         newArray[i] = temp + left.values[i];
    //         temp = temp + right.delta;
    //     }
    //     return new Jumble(newArray);
    // }

}