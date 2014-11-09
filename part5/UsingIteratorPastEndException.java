// UsingIteratorPastEndException extends Exception

public class UsingIteratorPastEndException extends Exception {

    static final long serialVersionUID = 98L;

    protected String message;

    UsingIteratorPastEndException(String err) {
        message = err;
    }


    public UsingIteratorPastEndException() {
        // just because.
    }
}