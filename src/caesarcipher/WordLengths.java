package caesarcipher;

import edu.duke.FileResource;

public class WordLengths {

    public static void countWordLengths(FileResource resource, int[] counts){
        int arrayLength = counts.length;
        for (String word: resource.words()) {
            int tempLength = word.length();
            int wordLength = tempLength;
            if (!Character.isLetter(word.charAt(0))){wordLength--;}
            if (!Character.isLetter(word.charAt(tempLength-1))){wordLength--;}
            if (wordLength>=arrayLength){
                counts[arrayLength]++;
            } else {
                counts[wordLength]++;
            }
        }
        for (int i=0;i<arrayLength;i++){
            System.out.println(i + " : " + counts[i]);
        }
        System.out.println(indexOfMax(counts));
    }

    public static void testCountWordLengths(String fileName){
        FileResource fileRes = new FileResource(fileName);
        int[] counts = new int[31];
        countWordLengths(fileRes,counts);
    }

    public static int indexOfMax(int[] values){
        int max = 0;
        for(int i=0;i<values.length;i++){
            if (values[i]>max){
                max = i;
            }
        }
        return max;
    }
}
