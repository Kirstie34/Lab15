import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan1 = new Scanner(System.in);

        boolean menuOptions = true;

        writeTextToFile("Countries.txt", "Russia\nThe United States\nGreece\nCanada\n");

        System.out.println("Welcome to the Countries Maintenance Application!");
        System.out.println();
        System.out.println("1 - See the list of countries");
        System.out.println("2 - Add a country");
        System.out.println("3 - exit");
        System.out.println();



        while (menuOptions) {

            System.out.print("Enter menu number: ");

            int menuPick = Validate.getValidInteger(0,4);

            System.out.println();

            if (menuPick == 1) {
                System.out.println(readTextFromFile("Countries.txt"));

            } else if (menuPick == 2) {

                System.out.print("Add a country: ");
                String countryChoice = scan1.nextLine();

                writeTextToFile("Countries.txt", countryChoice + "\n");

            } else {

                menuOptions = false;
            }

        }
        System.out.println("Buh-bye!");
    }

    public static void writeTextToFile(String fileName, String Input) {


        Path filePath = Paths.get(fileName);
        File productsFile = filePath.toFile();

        try {
            PrintWriter out = new PrintWriter(new FileOutputStream(productsFile, true));
            out.print(Input);
            out.close();

        } catch (FileNotFoundException ex) {

        }

    }

    public static StringBuilder readTextFromFile(String fileName) {


        Path filePath = Paths.get(fileName);

        File productsFile = filePath.toFile();

        StringBuilder result = new StringBuilder();

        try {
            FileReader r = new FileReader(productsFile);
            BufferedReader reader = new BufferedReader(r);

            String line = reader.readLine();

            while (line != null) {
                // System.out.println(line);
                result.append(line + "\n");
                line = reader.readLine();
            }

            reader.close();
            return result;


        } catch (FileNotFoundException ex) {
            return null;


        } catch (IOException ex) {
            return null;
        }
    }

}