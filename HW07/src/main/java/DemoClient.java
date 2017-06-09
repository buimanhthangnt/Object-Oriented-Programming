public class DemoClient {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[8];
        accounts[0] = new FlatFee(120000);
        accounts[1] = new Gambler(150000);
        accounts[2] = new NickelNDime(110000);
        accounts[3] = new Gambler(80000);
        accounts[4] = new FlatFee(100000);
        accounts[5] = new NickelNDime(140000);
        accounts[6] = new Gambler(70000);
        accounts[7] = new NickelNDime(160000);

        BalanceAscending comparator = new BalanceAscending();
        InsertionSort.sort(accounts, comparator);
        for (int i = 0; i < accounts.length; i++) {
            System.out.print(accounts[i].getBalance() + " ");
        }
        System.out.println("");

        BalanceDescending comparator2 = new BalanceDescending();
        InsertionSort.sort(accounts, comparator2);
        for (int i = 0; i < accounts.length; i++) {
            System.out.print(accounts[i].getBalance() + " ");
        }
        System.out.println("");

        accounts[1].withdraw(1000);
        accounts[1].deposit(1200);
        accounts[1].deposit(2400);
        accounts[2].withdraw(10000);
        accounts[2].deposit(8000);
        accounts[3].withdraw(15000);
        accounts[4].deposit(100);
        accounts[4].deposit(100);
        accounts[4].deposit(100);
        accounts[4].deposit(100);
        accounts[5].withdraw(1200);
        accounts[5].withdraw(1200);
        accounts[5].withdraw(1200);
        accounts[5].withdraw(1200);
        accounts[5].withdraw(1200);
        TransactionCountDescending comparator3 = new TransactionCountDescending();
        InsertionSort.sort(accounts, comparator3);
        for (int i = 0; i < accounts.length; i++) {
            System.out.print(accounts[i].getTransactionCount() + " ");
        }
        System.out.println("");
    }
}
