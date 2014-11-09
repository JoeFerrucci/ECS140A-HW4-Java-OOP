// Plus Class

public class Plus {

    public static Seq plus(Constant left, Constant right) {
        int newSize = Math.min(left.num, right.num); //getSmallest(left.num, right.num);
        int newInitialValue = left.value + right.value;
        return new Constant(newSize, newInitialValue);
    }

    public static Seq plus(Delta left, Delta right) {
        int newSize = Math.min(left.num, right.num); //getSmallest(left.num, right.num);
        int newInitialValue = left.initial + right.initial;
        int newDelta = left.delta + right.delta;
        return new Delta(newSize, newInitialValue, newDelta);
    }

    public static Seq plus(Jumble left, Jumble right) {
        int newSize = Math.min(left.numElements, right.numElements);
        int [] newArray = new int[newSize];
        for (int i = 0; i != newSize; i++) {
            newArray[i] = left.values[i] + right.values[i];
        }
        return new Jumble(newArray);
    }

    /*
     * Part 7: 
     */
    public static Seq plus(Constant left, Delta right) {
        int newSize = Math.min(left.num, right.num);
        int newInitialValue = left.value + right.initial;
        return new Delta(newSize, newInitialValue, right.delta);
    }

    public static Seq plus(Delta left, Constant right) {
        int newSize = Math.min(left.num, right.num);
        int newInitialValue = left.initial + right.value;
        return new Delta(newSize, newInitialValue, left.delta);
    }

    public static Seq plus(Constant left, Jumble right) {
        int newSize = Math.min(left.num, right.numElements);
        int [] newArray = new int[newSize];
        for (int i = 0; i != newSize; i++) {
            newArray[i] = left.value + right.values[i];
        }
        return new Jumble(newArray);
    }

    public static Seq plus(Jumble left, Constant right) {
        int newSize = Math.min(left.numElements, right.num);
        int [] newArray = new int[newSize];
        for (int i = 0; i != newSize; i++) {
            newArray[i] = left.values[i] + right.value;
        }
        return new Jumble(newArray);
    }

    public static Seq plus(Delta left, Jumble right) {
        int newSize = Math.min(left.num, right.numElements);
        int [] newArray = new int[newSize];
        int temp = left.initial; 
        for (int i = 0; i != newSize; i++) {
            newArray[i] = temp + right.values[i];
            temp = temp + left.delta;
        }
        return new Jumble(newArray);
    }

    public static Seq plus(Jumble left, Delta right) {
        int newSize = Math.min(left.numElements, right.num);
        int [] newArray = new int[newSize];
        int temp = right.initial; 
        for (int i = 0; i != newSize; i++) {
            newArray[i] = temp + left.values[i];
            temp = temp + right.delta;
        }
        return new Jumble(newArray);
    }

}