// the Delta base class

public class Delta extends Seq {
    protected int num;
    protected int initial;
    protected int delta;
    Delta(int argNum, int argInitial, int argDelta) {
        num = argNum;
        if (num == 0) {
            initial = 0;
            delta = 0;
        } else {
            initial = argInitial;
            delta = argDelta;
        }
        
    }
    public String toString() {
        // String toPrint = "[ " + num + " : " + initial + " &" + delta + " ]";
        return "< " + num + " : " + initial + " &" + delta + " >";
    }

    public int min() {
        // return initial + ((num-1)*delta);
        if (num == 0) return 0;
        else if (delta > 0) return initial;
        else return initial + (num-1)*delta;
    }
}
