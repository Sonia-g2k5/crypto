import java.util.Scanner;

public class PlayfairCipher {
    static char[][] matrix = new char[5][5];

    static void createMatrix(String key) {
        String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
        String combined = (key.toUpperCase().replace('J', 'I') + alphabet);
        StringBuilder unique = new StringBuilder();

        for (int i = 0; i < combined.length(); i++) {
            char ch = combined.charAt(i);
            if (ch >= 'A' && ch <= 'Z' && unique.indexOf(String.valueOf(ch)) == -1) {
                unique.append(ch);
            }
        }

        int k = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = unique.charAt(k++);
            }
        }
    }

    static String prepare(String text) {
        text = text.toUpperCase().replace('J', 'I').replaceAll("[^A-Z]", "");
        StringBuilder result = new StringBuilder();

        int i = 0;
        while (i < text.length()) {
            char first = text.charAt(i);
            result.append(first);
            i++;

            if (i == text.length()) {
                result.append('X');
            } else if (first == text.charAt(i)) {
                result.append('X');
            } else {
                result.append(text.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    static int[] findPosition(char ch) {
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (matrix[r][c] == ch) {
                    return new int[]{r, c};
                }
            }
        }
        return new int[]{-1, -1};
    }

    static String process(String text, int mode) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i += 2) {
            int[] p1 = findPosition(text.charAt(i));
            int[] p2 = findPosition(text.charAt(i + 1));

            int r1 = p1[0], c1 = p1[1];
            int r2 = p2[0], c2 = p2[1];

            if (r1 == r2) {
                result.append(matrix[r1][(c1 + mode + 5) % 5]);
                result.append(matrix[r2][(c2 + mode + 5) % 5]);
            } else if (c1 == c2) {
                result.append(matrix[(r1 + mode + 5) % 5][c1]);
                result.append(matrix[(r2 + mode + 5) % 5][c2]);
            } else {
                result.append(matrix[r1][c2]);
                result.append(matrix[r2][c1]);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter key: ");
        String key = sc.nextLine();
        createMatrix(key);

        System.out.println("5x5 Matrix:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print("Enter plaintext: ");
        String text = sc.nextLine();

        String prepared = prepare(text);
        String encrypted = process(prepared, 1);
        String decrypted = process(encrypted, -1);

        System.out.println("Prepared text: " + prepared);
        System.out.println("Encrypted text: " + encrypted);
        System.out.println("Decrypted text: " + decrypted);
        System.out.println("Note: Decrypted text may contain filler X characters.");

        sc.close();
    }
}
