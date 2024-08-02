package homework1;

import java.io.IOException;
import java.util.Scanner;

public class PhonebookV1 {

    public static void main(String[] args) {
        try {
          
            Entry[] entries = FileUtils.readFile("C:/Users/pc/Desktop/raw_phonebook_data.csv");
            MergeSort.sort(entries);
            FileUtils.writeToFile(entries, "C:/Users/pc/Desktop/sorted_output_file.csv");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a name (Surname, Name) to search or -1 to exit:");
            String searchTerm = scanner.nextLine();

            while (!searchTerm.equals("-1")) {
                int[] indices = BinarySearch.search(entries, searchTerm);

                if (indices[0] == -1) {
                    System.out.println("No entries found for " + searchTerm);
                } else {
                    System.out.println("Found " + (indices[1] - indices[0] + 1) + " entries for " + searchTerm);
                    for (int i = indices[0]; i <= indices[1]; i++) {
                        Entry entry = entries[i];
                        System.out.println("Name: " + entry.getName());
                        System.out.println("Address: " + entry.getStreetAddress() + ", " + entry.getCity()
                                + ", " + entry.getPostcode() + ", " + entry.getCountry());
                        System.out.println("Phone: " + entry.getPhoneNumber());
                        System.out.println();
                    }
                }

                System.out.println("Enter a name (Surname, Name) to search or -1 to exit:");
                searchTerm = scanner.nextLine();
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("Error occurred while processing the file: " + e.getMessage());
        }
    }
}

