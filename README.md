# Java Cryptography Programs

This repository contains simple Java implementations of common cryptography and network security algorithms for learning and practical examination purposes.

## Programs

| No. | Program | File name |
|---|---|---|
| 1 | Caesar Cipher (Encryption and Decryption) | `CaesarCipher.java` |
| 2 | DES Encryption and Decryption | `DESExample.java` |
| 3 | AES Encryption and Decryption | `AESExample.java` |
| 4 | Playfair Cipher | `PlayfairCipher.java` |
| 5 | RSA Encryption and Decryption | `RSAExample.java` |
| 6 | Diffie–Hellman Key Exchange | `DiffieHellman.java` |
| 7 | Columnar Transposition Cipher | `ColumnarTransposition.java` |
| 8 | DSS Digital Signature Generation and Verification | `DSS.java` |

## Requirements

- Java JDK 8 or later
- VS Code, IntelliJ IDEA, Eclipse, or any Java IDE

## How to Compile and Run

Open a terminal in the folder containing the Java file.

Example:

```bash
javac CaesarCipher.java
java CaesarCipher
```

Use the same commands with the required file name for each program. The class name and file name must match.

## Notes

- DES and textbook RSA are included for educational demonstrations only; they are not recommended for protecting real-world data.
- AES in this example uses ECB mode for a simple classroom demonstration. ECB does not provide secure message confidentiality for real applications.
- RSA accepts a numeric message smaller than `n` and uses small user-entered prime numbers for demonstration.
- Playfair combines I and J and may add filler `X` characters.
- The Columnar Transposition program pads the final row with `X` when required.
- DSS generates a fresh DSA key pair each time the program runs.

These programs are intended for academic practice and should not be used as production cryptographic implementations.
