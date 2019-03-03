/**
 * Testing stage to test my methods from the product class.
 *
 * @author Abilash Bodapati
 * @version 20190222
 *
 */
public class ProductTest_SetterAndGetters {

    /**
     * Method to return the set Product.
     *
     * @param name
     * @param type
     * @param price
     * @param quantity
     * @param inStock
     * @return {@code sampleProduct}
     */
    public static Product setInfo(String name, String type, double price,
            int quantity, boolean inStock) {

        // Initializing
        Product sampleProduct = new SimpleProduct();

        // Setting
        sampleProduct.setName(name);
        sampleProduct.setType(type);
        sampleProduct.setPrice(price);
        sampleProduct.setQuantity(quantity);
        sampleProduct.setInStock(inStock);

        // Returning
        return sampleProduct;

    }

    /**
     * Void Method to Print out the Sample Information.
     *
     * @param sampleProduct
     */
    public static void getInfo(Product sampleProduct) {

        System.out.println("Sample Product Information recieved");
        System.out.println("--------------------------------------");
        System.out
                .println("Name got using class is: " + sampleProduct.getName());
        System.out
                .println("Type got using class is: " + sampleProduct.getType());
        System.out.println(
                "Price got using class is: " + sampleProduct.getPrice());
        System.out.println(
                "Quantity got using class is: " + sampleProduct.getQuantity());
        System.out.println("In-Stock got using class is: "
                + sampleProduct.getInStock() + "\n");

    }

    /**
     * Main Method
     *
     * @param args
     */
    public static void main(String[] args) {

        /*
         * We are going to Test the Accessors and Mutators of SimpleProduct
         * class.
         */
        /*
         * Sample product information.
         *
         * "The Shawshank Redemption", "DVD", "19.95", "100", "true"
         */

        // Sample Information
        String name = "The Shawshank Redemption";
        String type = "DVD";
        double price = 19.95;
        int quantity = 100;
        boolean inStock = true;

        System.out.println("Sample Product Information");
        System.out.println("--------------------------------------");
        System.out.println("Name got is: " + name);
        System.out.println("Type got is: " + type);
        System.out.println("Price got is: " + price);
        System.out.println("Quantity got is: " + quantity);
        System.out.println("In-Stock got is: " + inStock + "\n");

        // Setting information
        Product sampleProduct = setInfo(name, type, price, quantity, inStock);

        // Getting information
        getInfo(sampleProduct);

        // using the toString method in the class.
        System.out.println("");
        System.out.println("-------------String Method-------------");
        String productString = sampleProduct.toString();
        System.out.println(productString);

        // Checking if equals method can detect same products based on name and type.
        System.out.println("\n" + "-------------equals method-------------");
        Product sampleProductSame = setInfo(name, type, 30, 50, inStock);
        boolean same = sampleProductSame.equals(sampleProduct);
        if (same == true) {
            System.out.println("They are the same");
        } else {
            System.out.println("They are not the same");
        }

        // Create a second product
        String name2 = "The Dark Knight";
        String type2 = "DVD";
        double price2 = 19.95;
        int quantity2 = 100;
        boolean inStock2 = true;

        Product sampleProduct2 = setInfo(name2, type2, price2, quantity2,
                inStock2);

        boolean same2 = sampleProduct2.equals(sampleProduct);
        if (same2 == true) {
            System.out.println("They are the same");
        } else {
            System.out.println("They are not the same");
        }

    }

}
