package caesarcipher.decrypt;

import caesarcipher.Alphabet;
import caesarcipher.Chiper;
import caesarcipher.WordLengths;

public class CaesarBreaker {

    public static int[] countLetters(String message){
        int length = message.length();
        int[] counts = new int[26];
        for (int i=0;i<length;i++) {
            Character c = message.charAt(i);
            int idx = Alphabet.LOWER.indexOf(c);
            if (idx >= 0) {
                counts[idx]++;
            } else {
                idx = Alphabet.UPPER.indexOf(c);
                if (idx >= 0) {
                    counts[idx]++;
                }
            }
        }
        return counts;
        }

    public static int maxIndex(int[] counts){
        return WordLengths.indexOfMax(counts);
    }

    public static String halfOfString(String message, int start){
        int length = message.length();
        StringBuilder sb = new StringBuilder();
        String result = "";
        for (int i=0;i<length;i++) {
            if (i % 2 == start) {
                sb.append(message.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String decrypt(String message){
        int[] letterStat = countLetters(message);
        int max = maxIndex(letterStat);
        int dkey = max - 4;
        if (max < 4){
            dkey = 26 - (4 - max);
        }
        System.out.println(dkey);
        return Chiper.encrypt(message,26 - dkey);
    }

    public static String decrypt2(String message){
        String first = halfOfString(message,0);
        String second = halfOfString(message,1);
        System.out.println("First key:");
        String decrypted1 = decrypt(first);
        System.out.println("Second key:");
        String decrypted2 = decrypt(second);
        StringBuilder sb = new StringBuilder();
        int max = 0;
        if (decrypted1.length()>=decrypted2.length()){
            max = decrypted1.length();
        } else {
            max = decrypted2.length();
        }
        for (int i=0; i< max; i++){
            try{
                sb.append(decrypted1.charAt(i));
                sb.append(decrypted2.charAt(i));
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static String decrypt2(String message, int key1, int key2){
        String first = halfOfString(message,0);
        String second = halfOfString(message,1);
        StringBuilder sb = new StringBuilder();
        String decrypted1 = Chiper.encrypt(first,26 - key1);
        String decrypted2 = Chiper.encrypt(second,26 - key2);
        int max = 0;
        if (decrypted1.length()>=decrypted2.length()){
            max = decrypted1.length();
        } else {
            max = decrypted2.length();
        }
        for (int i=0; i< max; i++){
            try{
                sb.append(decrypted1.charAt(i));
                sb.append(decrypted2.charAt(i));
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static void testDecrypt(){
        String input = "Just a test string with lots of eeeeeeeeeeeeeeeees";
        System.out.println(input);
        String encrypted = Chiper.encrypt(input,1);
        System.out.println(encrypted);
        String decrypted = decrypt(encrypted);
        System.out.println(decrypted);
    }

    public static void testDecrypt2(){
        String input = "Top ncmy qkff vi vguv vbg ycpx";
        System.out.println(input);
        String encrypted = Chiper.encrypt2(input,23, 2);
        System.out.println(encrypted);
        String decrypted = decrypt2(encrypted);
        System.out.println(decrypted);
    }

    public static void testDecrypt3(){
        String input = "Top ncmy qkff vi vguv vbg ycpx";
        System.out.println(input);
        System.out.println(decrypt2(input,2,20));
    }

    }
