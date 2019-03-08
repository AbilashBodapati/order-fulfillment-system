/**
 *
 */

/**
 * Extra credit
 *
 * @author Abilash Bodapati
 *
 */
public class SimpleCustomer {

    private String lastName;
    private String firstName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private double salesTax;

    public SimpleCustomer() {

        this.lastName = "";
        this.firstName = "";
        this.address = "";
        this.city = "";
        this.state = "";
        this.zip = "";
        this.salesTax = 0.0;

    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setAddress(String Address) {
        this.address = Address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getZip() {
        return this.zip;
    }

    public void setSalesTax(double salesTax) {
        if ((salesTax >= 0) || (salesTax < 1)) {
            this.salesTax = salesTax;
        } else {
            this.salesTax = 0;
        }

    }

    public double getSalesTax() {
        return this.salesTax;
    }

}
