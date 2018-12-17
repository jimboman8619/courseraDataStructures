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
        System.out.println(breacker.sliceString("abcdefghijklm", 0, 3)); //"adgjm"
        System.out.println(breacker.sliceString("abcdefghijklm", 1, 3)); //"behk"
        System.out.println(breacker.sliceString("abcdefghijklm", 2, 3)); //"cfil"
        System.out.println(breacker.sliceString("abcdefghijklm", 0, 4)); //"aeim"
        System.out.println(breacker.sliceString("abcdefghijklm", 1, 4)); //"bfj"
        System.out.println(breacker.sliceString("abcdefghijklm", 2, 4)); //"cgk"
        System.out.println(breacker.sliceString("abcdefghijklm", 3, 4)); //"dhl"
        System.out.println(breacker.sliceString("abcdefghijklm", 0, 5)); //"afk"
        System.out.println(breacker.sliceString("abcdefghijklm", 1, 5)); //"bgl"
        System.out.println(breacker.sliceString("abcdefghijklm", 2, 5)); //"chm"
        System.out.println(breacker.sliceString("abcdefghijklm", 3, 5)); //"di"
        System.out.println(breacker.sliceString("abcdefghijklm", 4, 5)); //"ej"
    }
}
