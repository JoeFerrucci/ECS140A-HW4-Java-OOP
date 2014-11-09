// JumbleUser

public class JumbleUser {

    static JumbleIt jumbleIter;

    public static int lengthLongestNDCSS1(Jumble j) {

        jumbleIter = new JumbleIt(j);
        if (!jumbleIter.hasNext()) return 0;

        int longest = 1;
        // Add try-catch block for Part 4:
        int first = 0;
        try { 
            first = jumbleIter.next(); 
        }
        catch (UsingIteratorPastEndException err) { 
            jumbleIter = null;
            return longest;
        }
        int nextNum = 0;
        int count = 1;

        while (jumbleIter.hasNext()) {

            // Add try-catch block for Part 4:
            try { 
                nextNum = jumbleIter.next(); 
            }
            catch (UsingIteratorPastEndException err) { 
                jumbleIter = null;
                return longest;
            }

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

        return longest;

    }

    public static int lengthLongestNDCSS2(Jumble j) {

        jumbleIter = new JumbleIt(j);
        if (!jumbleIter.hasNext()) return 0;

        int longest = 1;
        // Add try-catch block for Part 4:
        int first = 0;
        try { 
            first = jumbleIter.next(); 
        }
        catch (UsingIteratorPastEndException err) { 
            jumbleIter = null;
            return longest;
        }
        int nextNum = 0;
        int count = 1;

        boolean isSearching = true;
        while (isSearching) {

            // Add try-catch block for Part 4:
            try { nextNum = jumbleIter.next(); }
            catch (UsingIteratorPastEndException err) { 
                isSearching = false;
                jumbleIter = null;
                return longest;
            }

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

        return longest;

    }

}