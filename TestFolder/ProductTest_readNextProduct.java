import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Abilash Bodapati
 *
 */
public class ProductTest_readNextProduct {
    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.print("Enter a file name: ");
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();

        try {
            Scanner file = new Scanner(new File(fileName));
            Product prod = new SimpleProduct();
            boolean correctInfo = prod.readNextProduct(file);

            if (correctInfo == true) {
                System.out.println("We got the details on the next product.");
            } else {
                System.out.println(
                        "There is an error in the details for the next Product.");
            }

        } catch (IOException e) {
            System.err.println("File not found");
        }

        in.close();
    }

}
