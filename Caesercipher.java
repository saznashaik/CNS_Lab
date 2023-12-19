import java.util.*;
import java.io.*;
public class Caesercipher
{
 public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
 public static final String ALPHABET1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 public static String encrypt(String ptext, int cserkey)
 {
 String ctext = "";
 
 for (int i = 0; i < ptext.length(); i++)
 {
    if(ptext.charAt(i) >= 'a' && ptext.charAt(i) <='z'){
        int plainnumeric = ALPHABET.indexOf(ptext.charAt(i));
        int ciphernumeric = (plainnumeric+cserkey) % 26;
        char cipherchar = ALPHABET.charAt(ciphernumeric);
        ctext += cipherchar;
    }
    if(ptext.charAt(i) >= 'A' && ptext.charAt(i) <= 'Z'){
        int plainnumeric = ALPHABET1.indexOf(ptext.charAt(i));
        int ciphernumeric = (plainnumeric+cserkey) % 26;
        char cipherchar = ALPHABET1.charAt(ciphernumeric);
        ctext += cipherchar;
    }
 
 }
 return ctext;
 }

public static String decrypt(String ctext, int cserkey) {
    String ptext = "";

    for (int i = 0; i < ctext.length(); i++) {
        char currentChar = ctext.charAt(i);

        if (currentChar >= 'a' && currentChar <= 'z') {
            int ciphernumeric = ALPHABET.indexOf(currentChar);
            int plainnumeric = (ciphernumeric - cserkey) % 26;

            if (plainnumeric < 0) {
                plainnumeric = ALPHABET.length() + plainnumeric;
            }

            char plainchar = ALPHABET.charAt(plainnumeric);
            ptext += plainchar;
        }

        if (currentChar >= 'A' && currentChar <= 'Z') {
            int ciphernumeric = ALPHABET1.indexOf(currentChar);
            int plainnumeric = (ciphernumeric - cserkey) % 26;

            if (plainnumeric < 0) {
                plainnumeric = ALPHABET1.length() + plainnumeric;
            }

            char plainchar = ALPHABET1.charAt(plainnumeric);
            ptext += plainchar;
        }
    }

    return ptext;
}

 public static void main(String[] args)
 throws IOException
 {
 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 System.out.println("Enter the PLAIN TEXT for Encryption: ");
 String plaintext = new String();
 String ciphertext = new String();
 String key;
 int cserkey;
 plaintext = br.readLine();
 System.out.println("Enter the CAESERKEY between 0 and 25:");
 key = br.readLine();
 cserkey = Integer.parseInt(key);
 System.out.println("ENCRYPTION");
 ciphertext = encrypt(plaintext,cserkey);
 System.out.println("CIPHER TEXT :"+ ciphertext);
 System.out.println("DECRYPTION");
 plaintext = decrypt(ciphertext,cserkey);
 System.out.println("PLAIN TEXT :" + plaintext);
 }
}