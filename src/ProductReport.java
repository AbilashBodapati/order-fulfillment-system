
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Main Reporting UI for Customers to Interact. Has the extra credit for output
 * file generator implemented.
 *
 * @author Abilash Bodapati
 * @version 20190222
 *
 */
public class ProductReport {

    /**
     *
     * Method returns a list of the customer's information
     *
     * @param in
     * @return ArrayList<String>
     */
    public static ArrayList<String> customerInfo(Scanner in) {
        // Create a new Object of ArrayList holding Strings
        ArrayList<String> info = new ArrayList<String>();

        // Iterator variable.
        int i = 0;
        // While loop to add only the first 6 lines of the file as it is part of
        //  the customer info.
        while ((in.hasNext()) && (i < 6)) {
            // Get the line from the file.
            String elements = in.nextLine();
            // Add the line into the list.
            info.add(elements);

            // Iterate.
            i++;
        }
        return info;
    }

    /**
     * Void method that prints out the customer's information
     *
     * @param customer
     */
    public static void customerInfoToString(ArrayList<String> customer) {

        // Printf statements to print the customer's details
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

    /**
     * Create a Product and store the product in a Queue.
     *
     * @param file
     * @return Queue<Product>
     */
    public static Queue<Product> orders(Scanner file) {

        // Create an Queue Object that should hold Products.
        Queue<Product> order = new LinkedList<Product>();

        // Create a Product to hold the customer information.
        Product prod = new SimpleProduct();

        // While loop to do through every line and place them in the product
        //  field and then into the Queue.
        int i = 1;
        // Check if the file has next line.
        while (file.hasNext()) {
            if (i == 1) {
                // Needs this line to remove the extra line
                file.nextLine();
                // Name
                String name = file.nextLine();
                // set the name in the product.
                prod.setName(name);

                i++;
            } else if (i == 2) {
                // Type
                String type = file.nextLine();
                // set the tpye in the product.
                prod.setType(type);

                i++;
            } else if (i == 3) {
                // Price
                double price = file.nextDouble();
                // set the price in the product.
                prod.setPrice(price);

                i++;
            } else if (i == 4) {
                // quantity
                int quantity = file.nextInt();
                // set the quantity in the product.
                prod.setQuantity(quantity);

                i++;
            } else if (i == 5) {
                // In stock
                boolean inStock = file.nextBoolean();
                // set if the product is in stock or not.
                prod.setInStock(inStock);
                // Add the product into the Queue
                order.add(prod);

                // Clear the Product fields
                prod = new SimpleProduct();
                // set the iterator variable to 1 to repeat.
                i = 1;
            }
        }

        return order;
    }

    /**
     * Method that returns a queue that holds only those products that are in
     * stock.
     *
     * @param orders
     * @return Queue<Product>
     */
    public static Queue<Product> fulfilledOrders(Queue<Product> orders) {

        // Create a Queue object that hold Products.
        Queue<Product> fulfilled = new LinkedList<Product>();

        // While loop to iterate over the entire Queue to check if it is in stock.
        while (!orders.isEmpty()) {
            // Product from the Queue
            Product element = orders.poll();

            // Check if in stock.
            if (element.getInStock() == true) {
                // Add if in stock.
                fulfilled.add(element);
            }
        }
        return fulfilled;
    }

    /**
     * Method that returns a Stack that holds only those products that are not
     * in stock.
     *
     * @param orders
     * @return Stack<Product>
     */
    public static Stack<Product> delayedOrders(Queue<Product> orders) {

        // Create a Stack object that hold Products.
        Stack<Product> delayed = new Stack<>();

        // While loop to iterate over the entire Queue to check if it is not in stock.
        while (!orders.isEmpty()) {
            // Product from the Queue
            Product element = orders.poll();

            // Check if not in stock.
            if (element.getInStock() == false) {
                // Add if not in stock.
                delayed.push(element);
            }
        }

        return delayed;

    }

    /**
     * Void method that prints the report of the order that have products in
     * stock.
     *
     * @param fulfilled
     * @param salesTax
     */
    public static void reportFulfilledOrders(Queue<Product> fulfilled,
            double salesTax) {

        // Sub-total of the order.
        double sum = 0;

        // While loop to go through the Queue and print in the format as
        //  suggested by the client.
        while (!fulfilled.isEmpty()) {
            // Product from the Queue
            Product element = fulfilled.poll();

            // Add the sub-total of all the products while looping
            sum += element.getQuantity() * element.getPrice();

            // Print statement of every product for the order receipt.
            System.out.println(String.format("\t %d X %-31s %-10s %15.2f %n",
                    element.getQuantity(), element.getName(),
                    "(" + element.getType() + ")",
                    (element.getQuantity() * element.getPrice())));
        }

        // End of the Product layout
        System.out.printf("\t %s%n",
                "----------------------------------------------------------------------");

        // Print the sub-total
        System.out.printf("\t Subtotal: %52.2f%n", sum);

        // Print the sales tax used and applied.
        double salesTaxValue = sum * salesTax;
        System.out.printf("\t SalesTax: %s %45.2f%n", "(" + salesTax + ")",
                salesTaxValue);

        // Find out how much shipping needs to be applied.
        double shippingTax = 0;
        if ((sum < 10) && (sum >= 0)) {
            shippingTax = 0.15;

        } else if ((sum < 25) && (sum >= 10)) {
            shippingTax = 0.05;
        }

        // Print the shipping fee applied.
        double shipping = sum * shippingTax;
        System.out.printf("\t Shipping: %52.2f%n", shipping);
        System.out.printf("\t %s%n",
                "----------------------------------------------------------------------");

        // Print out the total amount the customer need to pay.
        System.out.printf("\t Total: %55.2f%n",
                (sum + salesTaxValue + shipping));

        // End of the Fulfilled order.
        System.out.println(
                "------------------------------------------------------------------------------------\n");
    }

    /**
     * Void method that prints the report of the order that do not have products
     * in stock.
     *
     * @param delayed
     */
    public static void reportDelayedOrders(Stack<Product> delayed) {

        // Sub-total of the order.
        double sum = 0;

        // While loop to go through the Stack and print in the format as
        //  suggested by the client.
        while (!delayed.isEmpty()) {
            // Product from the Stack
            Product element = delayed.pop();

            // Add the sub-total of all the products while looping
            sum += (element.getPrice() * element.getQuantity());

            // Print statement of every product for the order receipt.
            System.out.println(String.format("\t %d X %-31s %-10s %15.2f %n",
                    element.getQuantity(), element.getName(),
                    "(" + element.getType() + ")",
                    (element.getQuantity() * element.getPrice())));
        }

        // End of the Product layout
        System.out.printf("\t %s%n",
                "----------------------------------------------------------------------");

        // Print out the outstanding balance for the remaining delayed products.
        System.out.printf("\t Outstanding Balance: %41.2f%n", sum);

        // End of the Delayed order.
        System.out.println(
                "------------------------------------------------------------------------------------\n");

    }

    /**
     * This is part of the Extra Credit.
     *
     * @param delayed
     * @throws IOException
     */
    public static void fileOutput(Stack<Product> delayed) throws IOException {
        // Ask the client if they want to create a file for delayed products.
        System.out.print("What do you want to name your output file: ");
        Scanner outName = new Scanner(System.in);
        String outfileName = outName.nextLine();

        // Convert the string into a file
        File file = new File(outfileName);
        // Check is file exists in the directory.
        if (!file.exists()) {

            // Create a new file writer object to write the product details into
            //  the file
            FileWriter writer = new FileWriter(outfileName);

            // file Header
            writer.write("This file contains the Delayed Products");
            writer.write("\n");
            writer.write("-----------------------------------------\n");

            // Iterator to go through the stack.
            Iterator<Product> iter = delayed.iterator();

            // Create a new stack to hold the elements in their original order
            //  as the input file
            Stack<Product> reversed = new Stack<>();

            // Remove the elements from a stack and add the element into a new one.
            while (iter.hasNext()) {
                Product element = iter.next();
                reversed.push(element);
            }

            // Create a new iterator for the stack with the original order.
            Iterator<Product> iterReversed = reversed.iterator();

            // Loop through the new stack using iterator
            while (iterReversed.hasNext()) {
                // Remove the element
                Product element = iterReversed.next();

                // Write statements to print out the product information line by line.
                writer.write(element.getName());
                writer.write("\n");
                writer.write(element.getType());
                writer.write("\n");
                writer.write("" + element.getPrice());
                writer.write("\n");
                writer.write("" + element.getQuantity());
                writer.write("\n");
                writer.write("" + element.getInStock());
                writer.write("\n");
                // Additional line to partition between products for better visualization
                writer.write("--------------------------\n");
            }

            // Letting the client know to refresh the folder and check for the file
            System.out.println("\nPlease refresh the folder.");
            System.out.println(
                    "\"" + outfileName + "\"" + " has been generated.");

            // End of the program.
            System.out.println("Thank you for using this program!");

            // Flush all the write statements to see the file in the folder
            writer.flush();

            // Close the i/o Streams.
            writer.close();
        } else {
            // Print an error to let the client know that there is a file with
            //  the same name.
            System.err.println("There is a file that exists under this name.");
            System.err
                    .println("Please try again with a different output name.");
        }

        // Close the i/o Streams.
        outName.close();

    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        // Ask the user for the file name and scan the file.
        System.out.print("Enter database file name: ");
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();

        // Surrounding the code block with try catch to handle error.
        try {

            // Two file copies to work with for queue and stack part for the project.
            Scanner file = new Scanner(new File(fileName));
            Scanner fileCopy = new Scanner(new File(fileName));
            Scanner fileCopy2 = new Scanner(new File(fileName));

            // An Array List to store the customer information.
            ArrayList<String> customer = customerInfo(file);
            // Double to store the sales tax from the customer section of the file.
            double salesTax = file.nextDouble();

            // Void calls to discard the customer info and sales tax from the file copy.
            customerInfo(fileCopy);
            fileCopy.nextDouble();
            customerInfo(fileCopy2);
            fileCopy2.nextDouble();

            // Two Queues to run through for fulfilled (using Queue) and delayed (using Stack).
            Queue<Product> orders = orders(file);
            Queue<Product> ordersCopy = orders(fileCopy);
            Queue<Product> ordersCopy2 = orders(fileCopy2);

            // Create a Queue to hold all the products in stock.
            Queue<Product> fulfilled = fulfilledOrders(orders);

            // Create a stack to hold all the products not in stock.
            Stack<Product> delayed = delayedOrders(ordersCopy);
            Stack<Product> delayedCopy = delayedOrders(ordersCopy2);

            // Print out the Fulfilled part of the order.
            System.out.println("");
            System.out.println("Shipping To: ");
            customerInfoToString(customer);
            reportFulfilledOrders(fulfilled, salesTax);

            // Print out the Delayed part of the order.
            System.out.println("Orders Outstanding For:");
            customerInfoToString(customer);
            reportDelayedOrders(delayed);

            /*
             * File output (Extra-credit)
             */

            //Ask the user if they want to create the output file.
            System.out.print(
                    "Do you want to create a file of delayed products [y]es/[n]o: ");
            Scanner out = new Scanner(System.in);
            String outResponse = out.nextLine();

            // Check for response and execute appropriately
            if ((outResponse.equals("y")) || (outResponse.equals("Y"))) {
                // Execute the output file generator
                fileOutput(delayedCopy);
            } else {
                // End the program.
                System.out.println("Thank you for using this program!");
            }

            // Close all the i/o streams to prevent i/o leaks.
            out.close();
            file.close();

        } catch (IOException e) {
            // Error statement if there is no such file found.
            System.err.println("File not found");
        }

        // Close all the i/o streams to prevent i/o leaks.
        in.close();

    }

}
