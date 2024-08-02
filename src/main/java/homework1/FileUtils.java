package homework1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static Entry[] readFile(String filePath) throws IOException {
        List<Entry> entries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 6) { 
                    entries.add(new Entry(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]));
                }
            }
        }
        return entries.toArray(new Entry[0]);
    }

    public static void writeToFile(Entry[] entries, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Entry entry : entries) {
                writer.write(String.join(";", entry.getName(), entry.streetAddress, entry.city, entry.postcode,
                        entry.country, entry.phoneNumber));
                writer.write("\n");
            }
        }
    }
}

