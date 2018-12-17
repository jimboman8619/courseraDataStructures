import caesarcipher.CharacterStat;
import edu.duke.FileResource;
//import logentry.Tester;
import week2.*;
import week4.CaesarCipher;
import week4.Tester;

public class Main {

    public static void main(String[] args) {
//        Tester test = new Tester();
//        test.testLogAnalyzer();
//        test.testUniqueIP();
//        test.testHigherThanNum(400);
//        test.testUniqueIPVisitsOnDay("Sep 24");
//        test.testUniqueIPVisitsOnDay("Sep 30");
//        test.testCountUniqueIPsInRange(400,499);
//        test.testCountUniqueIPsInRange(300,399);
//        test.testCountVisitsPerIP();
//        test.testMostNumberVisitsByIP();
//        test.testIPsMostVisits();
//        test.testIPsForDays();
//        test.testDayWithMostIPVisits();
//        test.iPsWithMostVisitsOnDay();

        Tester test = new Tester();
//        test.testCaesarCipher("week4/testdata/titus-small.txt");
//        System.out.println("******************************************");
//        test.testCaesarCracker("week4/testdata/titus-small_key5.txt");
////        test.testCaesarCracker("week4/testdata/oslusiadas_key17.txt");
//        System.out.println("******************************************");
//        test.testVigenereCipher("week4/testdata/titus-small.txt");
        test.testVigenereBreaker();

    }
}
