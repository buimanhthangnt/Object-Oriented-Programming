public class Demo {
    public static void main(String[] args) {
        Gambler gambler = new Gambler(100);
        gambler.withdraw(10);
        gambler.deposit(20);
        gambler.endMonth();

        FlatFee flatFee = new FlatFee(12000);
        flatFee.withdraw(1200);
        flatFee.withdraw(220);
        flatFee.deposit(2900);
        flatFee.endMonth();

        NickelNDime nickelNDime = new NickelNDime(22000);
        nickelNDime.withdraw(2200);
        nickelNDime.withdraw(1200);
        nickelNDime.withdraw(1000);
        nickelNDime.deposit(8000);
        nickelNDime.endMonth();
    }
}
