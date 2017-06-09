import java.util.Scanner;

public class InvoiceTest {
    public static void main(String[] args) {
        Invoice item = new Invoice("Laptop","A product from DELL in USA",12,12000000);
        item.getInformation();
        System.out.print("Enter a new name of item: ");
        Scanner input = new Scanner(System.in);
        item.setNumber(input.nextLine());
        System.out.print("Enter the description of item: ");
        item.setDescription(input.nextLine());
        System.out.print("Enter the quantity of item: ");
        item.setQuantity(input.nextInt());
        System.out.print("Enter the price per item: ");
        item.setPrice(input.nextDouble());
        System.out.println("");
        System.out.print(item.getNumber()+", "+item.getDescription()+"\nQuantity: "+item.getQuantity()+"\tPrice: "+item.getPrice());
        System.out.println("\nInvoice Amount is "+item.getInvoiceAmount());
    }
}