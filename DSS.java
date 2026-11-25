import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.util.Scanner;
import java.util.Base64;

public class DSS {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter message: ");
        String message = sc.nextLine();

        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();

        Signature sign = Signature.getInstance("SHA256withDSA");

        sign.initSign(keyPair.getPrivate());
        sign.update(message.getBytes("UTF-8"));
        byte[] signature = sign.sign();

        System.out.println("Digital Signature Generated");
        System.out.println("Signature: " +
            Base64.getEncoder().encodeToString(signature));

        sign.initVerify(keyPair.getPublic());
        sign.update(message.getBytes("UTF-8"));
        boolean result = sign.verify(signature);

        System.out.println("Signature Verified: " + result);
        sc.close();
    }
}
