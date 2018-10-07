package caesarcipher;

/**
 * Created by sbt-eltyshev-vs on 20.09.2018.
 */
public class LetterStatistic {
    public static final String alphabet="abcdefghijklmnopqrstuvwxyz";
    public static final String ALPHABET="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static int[] getStat(String input){
        int[] alphabetArr = new int[25];
        for (int i=0;i<alphabet.length();i++){
            int idx = alphabet.indexOf(input.charAt(i));
            if(idx!=-1){

            }
        }

    }
}
