package week2;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordsInFiles {
    private Map<String, ArrayList<String>> worlds;

    public WordsInFiles() {
        this.worlds = new HashMap<>();
    }

    private void addWordsFromFile(File f) {
        FileResource resource = new FileResource(f.getAbsolutePath());
        resource.lines();
        for (String world : resource.words()) {
            String lowerWorld = world; //.toLowerCase();
            if (worlds.containsKey(lowerWorld)) {
                ArrayList<String> tempList = worlds.get(lowerWorld);
                if (!tempList.contains(f.getName())) {
                    tempList.add(f.getName());
                    worlds.put(lowerWorld, tempList);
                }
            } else {
                ArrayList<String> tempList = new ArrayList<String>();
                tempList.add(f.getName());
                worlds.put(lowerWorld, tempList);
            }
        }
    }

    public void buildWordFileMap() {
        worlds.clear();
        DirectoryResource dir = new DirectoryResource();
        for (File f : dir.selectedFiles()) {
            addWordsFromFile(f);
        }
    }

    public int maxNumber() {
        int max = 0;
        for (String world : worlds.keySet()) {
            int wc = worlds.get(world).size();
            if (wc > max) {
                max = wc;
            }
        }
        return max;
    }

    public ArrayList<String> wordsInNumFiles(int number) {
        ArrayList<String> wordsByNum = new ArrayList<>();
        for (String world : worlds.keySet()) {
            if (worlds.get(world).size() == number) {
                wordsByNum.add(world);
            }
        }
        return wordsByNum;
    }

    public void printFilesIn(String word) {
        for (String fileName : worlds.get(word)) {
            System.out.println(fileName);
        }
    }

    public void tester() {
        buildWordFileMap();
//        for (String word : worlds.keySet()) {
//            System.out.println(word);
//        }
        int max = maxNumber();

        printFilesIn("tree");

        System.out.println(max);
        System.out.println(wordsInNumFiles(4).size());
        this.printFilesIn("tree");


    }
}
