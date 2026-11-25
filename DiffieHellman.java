import java.math.BigInteger;
import java.util.Scanner;

public class DiffieHellman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter prime number q: ");
        BigInteger q = sc.nextBigInteger();

        System.out.print("Enter primitive root alpha: ");
        BigInteger alpha = sc.nextBigInteger();

        System.out.print("Enter private key of User A: ");
        BigInteger xa = sc.nextBigInteger();

        System.out.print("Enter private key of User B: ");
        BigInteger xb = sc.nextBigInteger();

        if (!q.isProbablePrime(20) ||
            xa.signum() <= 0 || xb.signum() <= 0) {
            System.out.println("Enter a prime q and positive private keys.");
            sc.close();
            return;
        }

        BigInteger ya = alpha.modPow(xa, q);
        BigInteger yb = alpha.modPow(xb, q);

        BigInteger keyA = yb.modPow(xa, q);
        BigInteger keyB = ya.modPow(xb, q);

        System.out.println("Public key of A: " + ya);
        System.out.println("Public key of B: " + yb);
        System.out.println("Secret key calculated by A: " + keyA);
        System.out.println("Secret key calculated by B: " + keyB);

        if (keyA.equals(keyB)) {
            System.out.println("Key exchange successful.");
        } else {
            System.out.println("Key exchange failed.");
        }

        sc.close();
    }
}
