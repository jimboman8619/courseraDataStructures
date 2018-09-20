package caesarcipher;

public class Chiper {
    public static final String alphabet="abcdefghijklmnopqrstuvwxyz";
    public static final String ALPHABET="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static StringBuilder eAlphabet_1 = null;
    public static StringBuilder eALPHABET_1 = null;
    public static StringBuilder eAlphabet_2 = null;
    public static StringBuilder eALPHABET_2 = null;

    public static String encrypt(String input, int key){
        StringBuilder result = new StringBuilder(input);
        eAlphabet_1 = new StringBuilder(alphabet.substring(key)+alphabet.substring(0,key));
        eALPHABET_1 = new StringBuilder(ALPHABET.substring(key)+ALPHABET.substring(0,key));
        for(int i=0;i<result.length();i++){
            Character ch = result.charAt(i);
            if(ch!=' ' && ch!='.' && ch!='!') {
                Character chForReplace = getEncryptedChar(ch,key);
                result.setCharAt(i,chForReplace);
            }
        }
        return result.toString();
    }

    public static String encrypt2(String input, int key1, int key2){
        StringBuilder result = new StringBuilder(input);
        eAlphabet_1 = new StringBuilder(alphabet.substring(key1)+alphabet.substring(0,key1));
        eALPHABET_1 = new StringBuilder(ALPHABET.substring(key1)+ALPHABET.substring(0,key1));
        eAlphabet_2 = new StringBuilder(alphabet.substring(key2)+alphabet.substring(0,key2));
        eALPHABET_2 = new StringBuilder(ALPHABET.substring(key2)+ALPHABET.substring(0,key2));
        for(int i=0;i<result.length();i++){
            Character ch = result.charAt(i);
            if(i%2==0) {
                Character chForReplace = getEncryptedChar(ch, key1);
                result.setCharAt(i,chForReplace);
            }else {
                Character chForReplace = getEncryptedChar(ch, key2);
                result.setCharAt(i,chForReplace);
            }
            }
        return result.toString();
    }


    private static Character getEncryptedChar(Character ch, int key){
        int chIdx = alphabet.indexOf(ch.toString());
        if (chIdx != -1) {
            Character chForReplace = eAlphabet_1.charAt(chIdx);
            return chForReplace;
        } else {
            chIdx = ALPHABET.indexOf(ch.toString());
            Character chForReplace = eALPHABET_1.charAt(chIdx);
            return chForReplace;
        }
    }
}
