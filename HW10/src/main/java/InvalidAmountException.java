public class InvalidAmountException extends RuntimeException {
    public InvalidAmountException() {
        this("Deposit or withdraw money is negative.");
    }
    public InvalidAmountException(String message) {
        super(message);
    }
}
