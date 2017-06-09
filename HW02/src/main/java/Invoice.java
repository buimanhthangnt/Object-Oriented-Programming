public class Invoice {
    private String number;
    private String description;
    private int quantity;
    private double price;

    public Invoice(String n, String d, int q, double p) {
        number = n;
        description = d;
        quantity = q;
        price = p;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String n) {
        number = n;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String d) {
        description = d;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int q) {
        if (q<0) quantity = 0;
        else quantity = q;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double p) {
        if (p<0) price = 0;
        else price = p;
    }
    public double getInvoiceAmount() {
        return price*quantity;
    }
    public void getInformation() {
        System.out.println(number+", "+description);
        System.out.println("Quantity: "+quantity+"\t"+"Price: "+price);
        System.out.println("");
    }
}