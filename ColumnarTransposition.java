import java.util.Arrays;
import java.util.Scanner;

public class ColumnarTransposition {
    static String encrypt(String text, String key) {
        text = text.toUpperCase().replaceAll("[^A-Z]", "");
        final String normalizedKey = key.toUpperCase().replaceAll("[^A-Z]", "");

        if (normalizedKey.isEmpty()) {
            throw new IllegalArgumentException("Key cannot be empty.");
        }

        int columns = normalizedKey.length();
        int rows = (int) Math.ceil((double) text.length() / columns);
        char[][] matrix = new char[rows][columns];

        int index = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                matrix[r][c] = index < text.length() ? text.charAt(index++) : 'X';
            }
        }

        Integer[] order = new Integer[columns];
        for (int i = 0; i < columns; i++) {
            order[i] = i;
        }

        Arrays.sort(order, (a, b) -> {
            int compare = Character.compare(normalizedKey.charAt(a), normalizedKey.charAt(b));
            return compare != 0 ? compare : Integer.compare(a, b);
        });

        StringBuilder result = new StringBuilder();
        for (int col : order) {
            for (int r = 0; r < rows; r++) {
                result.append(matrix[r][col]);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter plaintext: ");
        String text = sc.nextLine();

        System.out.print("Enter key: ");
        String key = sc.nextLine();

        try {
            System.out.println("Encrypted text: " + encrypt(text, key));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        sc.close();
    }
}
