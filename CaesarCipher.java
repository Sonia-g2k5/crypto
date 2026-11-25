import java.util.Scanner;

public class CaesarCipher {
    static String encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();
        key = ((key % 26) + 26) % 26;

        for (char ch : text.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                result.append((char) ('A' + (ch - 'A' + key) % 26));
            } else if (ch >= 'a' && ch <= 'z') {
                result.append((char) ('a' + (ch - 'a' + key) % 26));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    static String decrypt(String text, int key) {
        return encrypt(text, -key);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter plaintext: ");
        String text = sc.nextLine();

        System.out.print("Enter key: ");
        int key = sc.nextInt();

        String encrypted = encrypt(text, key);
        String decrypted = decrypt(encrypted, key);

        System.out.println("Encrypted text: " + encrypted);
        System.out.println("Decrypted text: " + decrypted);
        sc.close();
    }
}
