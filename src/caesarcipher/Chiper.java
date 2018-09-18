package caesarcipher;

public class Chiper {
    public static final String alphabet="abcdefghijklmnopqrstuvwxyz";
    public static final String ALPHABET="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String encrypt(String input, int key){
        StringBuilder result = new StringBuilder(input);
        StringBuilder eAlphabet = new StringBuilder(alphabet.substring(key)+alphabet.substring(0,key));
        StringBuilder eALPHABET = new StringBuilder(ALPHABET.substring(key)+ALPHABET.substring(0,key));
        for(int i=0;i<result.length();i++){
            Character ch = result.charAt(i);
            if(ch!=' ' && ch!='.' && ch!='!') {
                int chIdx = alphabet.indexOf(ch.toString());
                if (chIdx != -1) {
                    Character chForReplace = eAlphabet.charAt(chIdx);
                    result.setCharAt(i, chForReplace);
                } else {
                    chIdx = ALPHABET.indexOf(ch.toString());
                    Character chForReplace = eALPHABET.charAt(chIdx);
                    result.setCharAt(i, chForReplace);
                }
            }
        }
        return result.toString();
    }
}
