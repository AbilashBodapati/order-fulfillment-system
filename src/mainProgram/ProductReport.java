
package mainProgram;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main Reporting UI for Customers to Interact.
 *
 * @author Abilash Bodapati
 * @version 20190222
 *
 */
public class ProductReport {

    public static ArrayList<String> customerInfo(Scanner in) {
        ArrayList<String> info = new ArrayList<String>();

        int i = 0;

        while ((in.hasNext()) && (i < 6)) {
            String elements = in.nextLine();
            info.add(elements);

            i++;
        }
        return info;
    }

    public static void customerInfoToString(ArrayList<String> customer) {

        System.out.printf("%10s " + "%s", customer.get(1), customer.get(0));
        System.out.println("");
        System.out.printf("%22s ", customer.get(2));
        System.out.println("");
        System.out.printf("%16s " + "%s " + "%s", customer.get(3),
                customer.get(4), customer.get(5));
        System.out.println("");
        System.out.println(
                "------------------------------------------------------------------------------------");

    }

    public static double salesTax(Scanner file) {
        double salesTax = 0;
        int i = 0;
        while ((file.hasNext()) && (i < 1)) {
            salesTax = file.nextDouble();

            i++;
        }

        return salesTax;
    }

    public static void fulfiledOrder(Scanner file) {

    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.print("Enter database file name: ");
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();

        try {
            Scanner file = new Scanner(new File(fileName));

            System.out.println("");
            System.out.println("Shipping To: ");

            ArrayList<String> customer = customerInfo(file);
            customerInfoToString(customer);
            double salesTax = salesTax(file);

            file.close();

        } catch (IOException e) {
            System.err.println("File not found");
        }

        in.close();

    }

}
