// JumbleUser

public class JumbleUser {

    static JumbleIt jumbleIter;

    public static int lengthLongestNDCSS1(Jumble j) {

        jumbleIter = new JumbleIt(j);
        if (!jumbleIter.hasNext()) return 0;

        int longest = 1;
        int first = jumbleIter.next();
        int nextNum = 0;
        int count = 1;

        while (jumbleIter.hasNext()) {

            nextNum = jumbleIter.next();

            // continue seeking non-decreasing elements
            if (first <= nextNum) {
                count++;
                if (count > longest) {
                    longest = count; // increment first then save longest.
                }
            } 

            // start over
            else {
                count = 1;
                first = nextNum;
            }

            first = nextNum;            

        }

        jumbleIter = null;
        return longest;

    }

}