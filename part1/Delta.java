// the Delta base class

public class Delta extends Seq {
    protected int num;
    protected int initial;
    protected int delta;
    Delta(int argNum, int argInital, int argDelta) {
        num = argNum;
        if (num == 0) {
            initial = 0;
            delta = 0;
        } else {
            initial = argInital;
            delta = argDelta;
        }
        
    }
    public String toString() {
        // String toPrint = "[ " + num + " : " + initial + " &" + delta + " ]";
        return "< " + num + " : " + initial + " &" + delta + " >";
    }
}
