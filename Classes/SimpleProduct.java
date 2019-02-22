
/**
 * Product
 *
 *   A simple Class for a possible family of Product
 *   classes.
 *
 *   @author Abilash Bodapati
 *   @version 20190222
 */
import java.util.Scanner;

public class SimpleProduct implements Product {

    // TODO Insert Local Variables here

    // Method to set the Name of the Product
    @Override
    public void setName(String name) {
        // TODO Auto-generated method stub

    }

    // Method to get the Name of the Product
    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    // Method to set the type of product
    @Override
    public void setType(String type) {
        // TODO Auto-generated method stub

    }

    // Method to get the type of the product
    @Override
    public String getType() {
        // TODO Auto-generated method stub
        return null;
    }

    // Method to set the Price of the product
    @Override
    public void setPrice(double price) {
        // TODO Auto-generated method stub

    }

    // Method to get the price of the product
    @Override
    public double getPrice() {
        // TODO Auto-generated method stub
        return 0;
    }

    // Method to set the quantity of the product
    @Override
    public void setQuantity(int quantity) {
        // TODO Auto-generated method stub

    }

    // Method to get the quantity of the product
    @Override
    public int getQuantity() {
        // TODO Auto-generated method stub
        return 0;
    }

    // Method to set the In-Stock of the product
    @Override
    public void setInStock(boolean inStock) {
        // TODO Auto-generated method stub

    }

    // Boolean method to check if Product is In-Stock
    @Override
    public boolean getInStock() {
        // TODO Auto-generated method stub
        return false;
    }

    // Boolean method to check if there is next product
    @Override
    public boolean readNextProduct(Scanner inFile) {
        // TODO Auto-generated method stub
        return false;
    }

}