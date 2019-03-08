
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

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

    public static Queue<Product> orders(Scanner file) {

        Queue<Product> order = new LinkedList<Product>();

        Product prod = new SimpleProduct();
        int i = 1;
        while (file.hasNext()) {
            if (i == 1) {
                file.nextLine();
                String name = file.nextLine();
                prod.setName(name);

                i++;
            } else if (i == 2) {
                String type = file.nextLine();
                prod.setType(type);

                i++;
            } else if (i == 3) {
                double price = file.nextDouble();
                prod.setPrice(price);

                i++;
            } else if (i == 4) {
                int quantity = file.nextInt();
                prod.setQuantity(quantity);

                i++;
            } else if (i == 5) {
                boolean inStock = file.nextBoolean();
                prod.setInStock(inStock);
                order.add(prod);

                prod = new SimpleProduct();
                i = 1;
            }
        }

        return order;
    }

    public static Queue<Product> fulfilledOrders(Queue<Product> orders) {

        Queue<Product> fulfilled = new LinkedList<Product>();

        while (!orders.isEmpty()) {
            Product element = orders.poll();

            if (element.getInStock() == true) {
                fulfilled.add(element);
            }
        }

        return fulfilled;
    }

    public static Stack<Product> delayedOrders(Queue<Product> orders) {

        Stack<Product> delayed = new Stack<>();
        while (!orders.isEmpty()) {
            Product element = orders.poll();

            if (element.getInStock() == false) {
                delayed.push(element);
            }
        }

        return delayed;

    }

    public static void reportFulfilledOrders(Queue<Product> fulfilled,
            double salesTax) {

        double sum = 0;

        while (!fulfilled.isEmpty()) {
            Product element = fulfilled.poll();

            sum += element.getQuantity() * element.getPrice();

            System.out.println(String.format("\t %d X %-31s %-10s %15.2f %n",
                    element.getQuantity(), element.getName(),
                    "(" + element.getType() + ")",
                    (element.getQuantity() * element.getPrice())));
        }

        System.out.printf("\t %s%n",
                "----------------------------------------------------------------------");

        System.out.printf("\t Subtotal: %52.2f%n", sum);

        double salesTaxValue = sum * salesTax;

        System.out.printf("\t SalesTax: %s %45.2f%n", "(" + salesTax + ")",
                salesTaxValue);

        double shippingTax = 0;
        if ((sum < 10) && (sum >= 0)) {
            shippingTax = 0.15;

        } else if ((sum < 25) && (sum >= 10)) {
            shippingTax = 0.05;
        }

        double shipping = sum * shippingTax;

        System.out.printf("\t Shipping: %52.2f%n", shipping);
        System.out.printf("\t %s%n",
                "----------------------------------------------------------------------");

        System.out.printf("\t Total: %55.2f%n",
                (sum + salesTaxValue + shipping));

        System.out.println(
                "------------------------------------------------------------------------------------\n");

    }

    public static void reportDelayedOrders(Stack<Product> delayed) {

        double sum = 0;
        while (!delayed.isEmpty()) {
            Product element = delayed.pop();

            sum += (element.getPrice() * element.getQuantity());

            System.out.println(String.format("\t %d X %-31s %-10s %15.2f %n",
                    element.getQuantity(), element.getName(),
                    "(" + element.getType() + ")",
                    (element.getQuantity() * element.getPrice())));
        }

        System.out.printf("\t %s%n",
                "----------------------------------------------------------------------");

        System.out.printf("\t Outstanding Balance: %41.2f%n", sum);

        System.out.println(
                "------------------------------------------------------------------------------------\n");

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
            Scanner fileCopy = new Scanner(new File(fileName));

            ArrayList<String> customer = customerInfo(file);
            double salesTax = salesTax(file);
            customerInfo(fileCopy);
            salesTax(fileCopy);

            Queue<Product> orders = orders(file);
            Queue<Product> ordersCopy = orders(fileCopy);

            Queue<Product> fulfilled = fulfilledOrders(orders);
            Stack<Product> delayed = delayedOrders(ordersCopy);

            System.out.println("");
            System.out.println("Shipping To: ");
            customerInfoToString(customer);
            reportFulfilledOrders(fulfilled, salesTax);

            System.out.println("Orders Outstanding For:");
            customerInfoToString(customer);
            reportDelayedOrders(delayed);

            file.close();

        } catch (IOException e) {
            System.err.println("File not found");
        }

        in.close();

    }

}
