package caesarcipher;

public class Chiper {

    public static String encrypt(String input, int key){
        StringBuilder result = new StringBuilder(input);
        for(int i=0;i<result.length();i++){
            Character ch = result.charAt(i);
            if(Character.isLetter(ch)) {
                Character chForReplace = getEncryptedChar(ch, Alphabet.LOWER, Alphabet.UPPER, key);
                result.setCharAt(i,chForReplace);
            }
        }
        return result.toString();
    }
    public static String encrypt2(String input, int key1, int key2){
        StringBuilder result = new StringBuilder(input);
        for(int i=0;i<result.length();i++){
            Character ch = result.charAt(i);
            if(Character.isLetter(ch)) {
                int key = 0;
                if(i%2==0) {
                    key = key1;
                }else {
                    key = key2;
                }
                Character chForReplace = getEncryptedChar(ch, Alphabet.LOWER, Alphabet.UPPER, key);
                result.setCharAt(i,chForReplace);
            }
        }
        return result.toString();

    }

    private static Character getEncryptedChar(Character ch, String alphabet, String ALPHABET ,int key ){
        StringBuilder eAlphabet = new StringBuilder(alphabet.substring(key)+alphabet.substring(0,key));
        StringBuilder eALPHABET = new StringBuilder(ALPHABET.substring(key)+ALPHABET.substring(0,key));
        int chIdx = alphabet.indexOf(ch.toString());
        if (chIdx != -1) {
            return eAlphabet.charAt(chIdx);
        } else {
            chIdx = ALPHABET.indexOf(ch.toString());
            return eALPHABET.charAt(chIdx);
        }
    }


}
