import java.math.BigInteger;
import java.util.Scanner;

public class RSAExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter prime number p: ");
        BigInteger p = sc.nextBigInteger();

        System.out.print("Enter prime number q: ");
        BigInteger q = sc.nextBigInteger();

        if (!p.isProbablePrime(20) || !q.isProbablePrime(20) || p.equals(q)) {
            System.out.println("Enter two different prime numbers.");
            sc.close();
            return;
        }

        BigInteger n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE)
                          .multiply(q.subtract(BigInteger.ONE));

        System.out.print("Enter public exponent e: ");
        BigInteger e = sc.nextBigInteger();

        if (e.compareTo(BigInteger.ONE) <= 0 ||
            e.compareTo(phi) >= 0 ||
            !e.gcd(phi).equals(BigInteger.ONE)) {
            System.out.println("Invalid e. It must be between 1 and phi and coprime to phi.");
            sc.close();
            return;
        }

        BigInteger d = e.modInverse(phi);

        System.out.println("Public key: (" + e + ", " + n + ")");
        System.out.println("Private key: (" + d + ", " + n + ")");

        System.out.print("Enter a numeric message less than n: ");
        BigInteger message = sc.nextBigInteger();

        if (message.signum() < 0 || message.compareTo(n) >= 0) {
            System.out.println("Message must be between 0 and n-1.");
            sc.close();
            return;
        }

        BigInteger encrypted = message.modPow(e, n);
        BigInteger decrypted = encrypted.modPow(d, n);

        System.out.println("Encrypted message: " + encrypted);
        System.out.println("Decrypted message: " + decrypted);
        sc.close();
    }
}
