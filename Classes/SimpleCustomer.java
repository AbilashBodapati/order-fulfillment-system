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

    /*
     * PRIVATE MEMBERS
     */
    private String lastName;
    private String firstName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private double salesTax;

    /*
     * Constructor Class
     */
    public SimpleCustomer() {

        this.lastName = "";
        this.firstName = "";
        this.address = "";
        this.city = "";
        this.state = "";
        this.zip = "";
        this.salesTax = 0.0;

    }

    /*
     * Getters and Setters
     *
     */

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

    /*
     * Overriden toString method to match the client's requirements.
     *
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        String str = String.format("%10s %s \n" + "%22s \n" + "%16s %s %s",
                this.firstName, this.lastName, this.address, this.city,
                this.state, this.zip);

        return str;

    }

}
