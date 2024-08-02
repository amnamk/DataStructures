package homework3;



import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PhonebookV2 {
    public static void main(String[] args) throws FileNotFoundException {
        RedBlackTree phonebook = FileUtils.readFile("C:/Users/pc/Desktop/raw_phonebook_data.csv");
        Scanner scanner = new Scanner(System.in);
        String enter;

        while (true) {
            System.out.println("Enter the name that you wish to search for or -1 to exit:");
            enter = scanner.nextLine();
            if (enter.equals("-1")) break;

            ArrayList<Entry> results = phonebook.get(enter);
            if (results != null) {
                System.out.println(results.size() + " entries.");

            } else {
                System.out.println("No entries exist in this phonebook.");
            }
        }
        scanner.close();
    }
}
