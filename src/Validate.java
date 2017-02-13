import java.util.Scanner;

/**
 * Created by Kirstie34 on 2/13/17.
 */
public class Validate {

    public static int getValidInteger() {
        Scanner scan1 = new Scanner(System.in);
        //validation for numbers
        while (!scan1.hasNextInt()) {
            scan1.nextLine(); //clears the buffer
            System.out.println("Please enter an integer! "); //tells user to enter number
        }
        return scan1.nextInt(); //takes the correct integer
    }

    public static boolean checkRange(int input, int min, int max) {
        if (input <= min || input >= max) {
            return false;
        }
        return true;
    }

    public static int getValidInteger(int min, int max) {
        int userInput = getValidInteger();
        while (checkRange(userInput, min, max) == false) {
            System.out.println("Please provide a number within range!");
            userInput = getValidInteger();
        }
        return userInput;
    }

}
