package homework1;

public class BinarySearch {

    public static int[] search(Entry[] entries, String searchableName) {
        int[] result = new int[2];
        result[0] = findFirstIndex(entries, searchableName);
        result[1] = findLastIndex(entries, searchableName);
        return result;
    }

    private static int findFirstIndex(Entry[] entries, String searchableName) {
        int low = 0;
        int high = entries.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (entries[mid].getName().compareTo(searchableName) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (low < entries.length && entries[low].getName().equals(searchableName)) {
            return low;
        }
        return -1; 
    }

    private static int findLastIndex(Entry[] entries, String searchableName) {
        int low = 0;
        int high = entries.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (entries[mid].getName().compareTo(searchableName) <= 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (high >= 0 && entries[high].getName().equals(searchableName)) {
            return high;
        }
        return -1; 
    }
}
