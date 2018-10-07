package caesarcipher;

public class CharacterStat {
    private static int[] stat = new int[26];

    public static int[] getStat(String input){
        String upperInput = input.toUpperCase();
        for(int i=0;i<upperInput.length();i++){
            int idx = Alphabet.UPPER.indexOf(upperInput.charAt(i));
            if(idx != -1){
                stat[idx]++;
                }
            }
        return stat;
    }

    public static String maxChar(String input){
        int[] stat = getStat(input);
        int max = stat[0];
        int idx = 0;
        for (int i = 1; i < 26 ; i++) {
            if(stat[i]>max){
                max = stat[i];
                idx = i;
            }
        }
        String result = Alphabet.UPPER.charAt(idx) + " occurs " + max + " times";
        return result;
    }
}
