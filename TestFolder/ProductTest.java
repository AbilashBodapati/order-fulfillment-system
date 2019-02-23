/**
 * Testing stage to test my methods from the product class.
 *
 * @author Abilash Bodapati
 * @version 20190222
 *
 */
public class ProductTest {

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

        Product sampleProduct = new SimpleProduct();

        return sampleProduct;

    }

    /**
     *
     *
     * @param sampleProduct
     */
    public static void getInfo(Product sampleProduct) {

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

        // Setting information
        Product sampleProduct = setInfo(name, type, price, quantity, inStock);

        // Getting information
        getInfo(sampleProduct);

    }

}
