public class OverdrawException extends RuntimeException {
    public OverdrawException() {
        this("Withdraw exceed balance.");
    }
    public OverdrawException(String message) {
        super(message);
    }
}
