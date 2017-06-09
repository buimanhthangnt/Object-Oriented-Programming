public class TransactionCountDescending implements MyComparator {
    public boolean less(BankAccount a1, BankAccount a2) {
        return a1.getTransactionCount() > a2.getTransactionCount();
    }
}
