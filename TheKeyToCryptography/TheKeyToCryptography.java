package TheKeyToCryptography;
import java.util.*;

public class TheKeyToCryptography {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        
        // Loop over cases
        while(sc.hasNextLine()){
            // Get ciphertext and initial part of key
            String cipher=sc.nextLine();
            String key=sc.nextLine();
            short keyLen=(short)key.length();
            
            // Loop over ciphertext decrypting one char at a time and add 
            //   it to the end of the key in order to keep decrypting
            for(short i=0; i<cipher.length(); i++){
                // Decrypt key
                byte decryptedChar = (byte)(cipher.charAt(i)-key.charAt(i));
                
                // If past end of alphabet subtract 26 to get back in range
                if(decryptedChar >= 26){
                    decryptedChar -= 26;
                }
                // If before start of alphabet add 26 to get back in range
                if(decryptedChar < 0){
                    decryptedChar += 26;
                }
                // Add value of 'A' to get back to correct character value
                decryptedChar += 'A';
                
                // Add decrypted char to end of key to continue decrypting
                key += (char)decryptedChar;
            }
            
            // Print plaintext which is everything after initial part of key
            System.out.println(key.substring(keyLen));
        }
    }
}