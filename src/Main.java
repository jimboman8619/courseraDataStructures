import caesarcipher.Chiper;

public class Main {

    public static void main(String[] args) {
        String input = "First Legion";
        int key1 = 23;
        System.out.println(Chiper.encrypt(input,key1));
    }
}
