// the Constant base class

public class Constant extends Seq {
    protected int num;
    protected int value;
    Constant(int argNum, int argValue) {
        num = argNum;
        if (num == 0) {
            value = 0;
        } else {
            value = argValue;
        }
    }
    public String toString() {
        // String toPrint = "[ " + num + " : " + value + " ]";
        return "[ " + num + " : " + value + " ]";
    }
}
