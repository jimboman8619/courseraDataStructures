package week2;

import java.security.PublicKey;
import java.util.ArrayList;
import edu.duke.FileResource;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    public WordFrequencies() {
        this.myWords = new ArrayList<>();
        this.myFreqs = new ArrayList<>();
    }

    public void findUnique(String fileName){
        myWords.clear();
        myFreqs.clear();
        FileResource resource = new FileResource(fileName);
        for (String s:resource.words()) {
            String word = s.toLowerCase();
            int idx = myWords.indexOf(word);
            setFrequency(word, idx);
        }
    }

    public void findMainCharacter(String fileName){
        myWords.clear();
        myFreqs.clear();
        FileResource resource = new FileResource(fileName);
        for (String line:resource.lines()) {
            if (!line.isEmpty()){
                String text=line;
                while(text.indexOf(" ")==0){
                    text = line.trim();
                }
                int dotIdx = text.indexOf(".");
                if (dotIdx != -1){
                    String character = text.substring(0, dotIdx);
                    int idx = myWords.indexOf(character);
                    setFrequency(character,idx);
                }

            }
        }
    }

    public void charactersWithNumParts(String fileName, int num1, int num2){
        findMainCharacter(fileName);
        for (int i=0; i<myWords.size(); i++){
            int freq = myFreqs.get(i);
            if((freq >= num1) && (freq <= num2)){
                System.out.println(myWords.get(i) + " is " + freq);
            }
        }
    }

    private void setFrequency(String word, int idx){
        if(idx == -1){
            myWords.add(word);
            myFreqs.add(1);
        }else {
            int value = myFreqs.get(idx);
            myFreqs.set(idx, value+1);
        }
    }

    public int findIndexOfMax(){
        int max = 0;
        int idx = 0;
        for (int i:myFreqs) {
            if (i>max){
                max = i;
                idx = myFreqs.indexOf(max);
            }
        }
        return idx;
    }

    public void tester(String fileName){
        findUnique(fileName);
        System.out.println("Unique words " + myWords.size());
//        for (int i=0; i< myWords.size(); i++) {
//            System.out.println(myWords.get(i) + "  " + myFreqs.get(i));
//        }
        int idx = findIndexOfMax();
        System.out.println("The word that occurs most often and its count are: " + myWords.get(idx) + " " + myFreqs.get(idx));
    }

    public void tester2(String fileName){
        findMainCharacter(fileName);
        System.out.println("Unique words " + myWords.size());
//        for (int i=0; i< myWords.size(); i++) {
//            System.out.println(myWords.get(i) + "  " + myFreqs.get(i));
//        }

        int idx = findIndexOfMax();
        System.out.println("Main character: " + myWords.get(idx) + " " + myFreqs.get(idx));





    }
}
