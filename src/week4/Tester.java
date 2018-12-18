package week4;

import edu.duke.FileResource;

public class Tester {

    public Tester() {
    }

    public void testCaesarCipher(String filePath) {
        CaesarCipher chiper = new CaesarCipher(5);
        FileResource resource = new FileResource(filePath);
        String encryptedStr = chiper.encrypt(resource.asString());
        System.out.println("Encrypted :");
        System.out.println(encryptedStr);
        String decryptedStr = chiper.decrypt(encryptedStr);
        System.out.println("Decrypted :");
        System.out.println(decryptedStr);
    }

    public void testCaesarCracker(String filePath) {
        CaesarCracker cracker = new CaesarCracker();
        FileResource resource = new FileResource(filePath);
        int key = cracker.getKey(resource.asString());
        System.out.println("Key :");
        System.out.println(key);
        System.out.println("Decrypted :");
        System.out.println(cracker.decrypt(resource.asString()));
    }

    public void testVigenereCipher(String filePath) {
        VigenereCipher chiper = new VigenereCipher(new int[]{17, 14, 12, 4});
        System.out.println("Encrypted :");
        FileResource resource = new FileResource(filePath);
        System.out.println(chiper.encrypt(resource.asString()));
    }

    public void testVigenereBreaker() {
        VigenereBreaker breacker = new VigenereBreaker();
//        System.out.println(breacker.sliceString("abcdefghijklm", 0, 3)); //"adgjm"
        FileResource resource = new FileResource("week4/messages/secretmessage1.txt");
        int[] keyLength = breacker.tryKeyLength(resource.asString(), 4, 'e');
        for (int i: keyLength) {
            System.out.println(i);
        }
        breacker.breakVigenere(4);

    }
}
