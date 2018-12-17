package week2;

import edu.duke.FileResource;

import java.util.HashMap;
import java.util.Map;

public class CodonCount {
    private Map<String, Integer> dnaCount;

    public CodonCount() {
        this.dnaCount = new HashMap();
    }

    private void buildCodonMap(int start, String dna) {
        dnaCount.clear();
        for (int i = start; i < dna.length() - 3; i += 3) {
            String currentDna = dna.substring(i, i + 3);
            if (dnaCount.containsKey(currentDna)) {
                Integer count = dnaCount.get(currentDna) + 1;
                dnaCount.put(currentDna, count);
            } else {
                dnaCount.put(currentDna, 1);
            }
        }
    }

    private String getMostCommonCodon() {
        Integer max = 0;
        String mostCommonCodon = "";
        for (String dnaCode : dnaCount.keySet()) {
            Integer currDnaCount = dnaCount.get(dnaCode);
            if (currDnaCount > max) {
                max = currDnaCount;
                mostCommonCodon = dnaCode;
            }
        }
        return mostCommonCodon;
    }

    private void printCodonCounts(int start, int end) {
        for (String dnaCode : dnaCount.keySet()) {
            int currDnaCount = dnaCount.get(dnaCode);
            if ((currDnaCount >= start) && (currDnaCount <= end))
                System.out.println(dnaCode + " " + dnaCount.get(dnaCode));

        }
    }

    public void tester() {
        FileResource resource = new FileResource();
        String content = resource.asString().toUpperCase();
        for (int i = 0; i < 1; i++) {
            System.out.println("Results for " + i);
            buildCodonMap(i,content);
            System.out.println("Total number of dna: " + dnaCount.size());
            String mostCommonCodon = getMostCommonCodon();
            System.out.println("MostCommonCodon: " + mostCommonCodon);
            System.out.println("MostCommonCodon value: " + dnaCount.get(mostCommonCodon));
            System.out.println("Betweeen 7 and 7:");
        }
        printCodonCounts(7,7);




    }

}
