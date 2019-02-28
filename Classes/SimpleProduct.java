
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

    private String name;
    private String type;
    private double price;
    private int quantity;
    private boolean inStock;

    // Constructor method
    public SimpleProduct() {
        // New Simple product

        this.name = "";
        this.type = "";
        this.price = 0.0;
        this.quantity = 0;
        this.inStock = false;

    }

    // Method to set the Name of the Product
    @Override
    public void setName(String name) {
        // TODO Auto-generated method stub
        this.name = name;
    }

    // Method to get the Name of the Product
    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return this.name;
    }

    // Method to set the type of product
    @Override
    public void setType(String type) {
        // TODO Auto-generated method stub
        this.type = type;
    }

    // Method to get the type of the product
    @Override
    public String getType() {
        // TODO Auto-generated method stub
        return this.type;
    }

    // Method to set the Price of the product
    @Override
    public void setPrice(double price) {
        // TODO Auto-generated method stub
        this.price = price;
    }

    // Method to get the price of the product
    @Override
    public double getPrice() {
        // TODO Auto-generated method stub
        return this.price;
    }

    // Method to set the quantity of the product
    @Override
    public void setQuantity(int quantity) {
        // TODO Auto-generated method stub
        this.quantity = quantity;
    }

    // Method to get the quantity of the product
    @Override
    public int getQuantity() {
        // TODO Auto-generated method stub
        return this.quantity;
    }

    // Method to set the In-Stock of the product
    @Override
    public void setInStock(boolean inStock) {
        // TODO Auto-generated method stub
        this.inStock = inStock;
    }

    // Boolean method to check if Product is In-Stock
    @Override
    public boolean getInStock() {
        // TODO Auto-generated method stub
        return this.inStock;
    }

    // Boolean method to check if there is next product
    @Override
    public boolean readNextProduct(Scanner inFile) {

        boolean productPresent = true;

        int lineNumber = 1;
        while (inFile.hasNext() && lineNumber <= 5) {
            String content = inFile.nextLine();
            if ((lineNumber == 1) || (lineNumber == 2) || (lineNumber == 3)
                    || (lineNumber == 4)) {
                if (!inFile.hasNext()) {
                    productPresent = false;
                }
            }
        }

        return productPresent;
    }

    // Override equals method
    @Override
    public boolean equals(Object obj) {

        return false;
    }

    // Override toString method
    @Override
    public String toString() {

        return "";
    }

}