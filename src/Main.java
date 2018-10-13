import caesarcipher.CharacterStat;
import caesarcipher.Chiper;
import caesarcipher.decrypt.CaesarBreaker;

import static caesarcipher.WordLengths.testCountWordLengths;

public class Main {

    public static void main(String[] args) {
//        String input = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
//        String input2 = "First Legion";
//        int key1 = 8;
//        int key2 = 21;
//        System.out.println(Chiper.encrypt(input,key1));
//        System.out.println(Chiper.encrypt2(input,key1,key2));
//        System.out.println(CharacterStat.maxChar("Hi, do you want a lollipop today? I own many good flavors, but banana is outstanding."));
//       testCountWordLengths("smallHamlet.txt");

        CaesarBreaker.testDecrypt2();

    }
}
