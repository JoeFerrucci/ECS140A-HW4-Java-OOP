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

}