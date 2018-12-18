package week4;

import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder sb = new StringBuilder();
        for (int i = whichSlice; i <message.length(); i+= totalSlices) {
            sb.append(message.charAt(i));
        }
        return sb.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker cracker = new CaesarCracker(mostCommon);
        for (int i=0; i<klength;i++) {
            String encriptedSlice = sliceString(encrypted,i,klength);
            key[i] = cracker.getKey(encriptedSlice);
        }
        sliceString(encrypted,0,klength);
        return key;
    }

    public void breakVigenere (int klength) {
        FileResource resource = new FileResource();
        String content = resource.asString();
        int[] keyLength = tryKeyLength(content, klength, 'e');
        VigenereCipher chiper = new VigenereCipher(keyLength);
        System.out.println(chiper.decrypt(content));


    }
    
}
