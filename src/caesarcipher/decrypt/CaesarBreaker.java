package caesarcipher.decrypt;

import caesarcipher.Alphabet;

public class CaesarBreaker {

    public static int[] countLetters(String message){
        int length = message.length();
        int[] counts = new int[26];
        for (int i=0;i<length;i++){
            int idx = Alphabet.LOWER.indexOf();
            if (idx>=0)
            counts[Alphabet.LOWER.indexOf()]

    }

    public static void maxIndex(){

    }

    public static void decrypt(){

    }

    public static void testDecrypt(){

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
    }
}
