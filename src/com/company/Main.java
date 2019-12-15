package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.Key;
import java.util.*;
import java.util.stream.Stream;

public class Main{

    private static FileReader fileReader;
    private static String text;
    private static Scanner scannerFromInput;
    private static HashMap<String, Integer> graphs = new HashMap<>();
    private static String[] textArray;
    private static String threeGraph = "";
    private static int value = 0;
    private static Map<String, Object> treeMap;
    public static void main(String[] args) {

        setTheStream();

        readTheTextFromFile();

        removeMarkingSigns();

        turnTextToArray();

        addThreeGraphsToTheHashMap();//

        sortTheMapByKey();

        //Stream<HashMap.Entry<String, Integer>> finalGraphs = mapToStream(graphs);
    }

    private static void sortTheMapByKey() { //comparator
        treeMap = new TreeMap<>(graphs);
        value = 1;
        printMessages(value);
    }

    private static void printMessages(int i) {
        if(i == 1){
            System.out.println(treeMap);
        }
    }

    private static void addThreeGraphsToTheHashMap() {
        for (String s : textArray) {
            for (int j = 0; j < s.length(); j++) {
                try {
                    threeGraph = s.substring(j, j + 3);
                } catch (IndexOutOfBoundsException ioobe) {
                    continue;
                }
                if (!graphs.containsKey(threeGraph)) {
                    graphs.put(threeGraph, 1);
                } else {
                    graphs.replace(threeGraph, graphs.get(threeGraph), graphs.get(threeGraph) + 1);
                }
            }
            threeGraph = "";
        }
    }

    private static void turnTextToArray() {
        textArray = text.split(" ");
    }

    private static void removeMarkingSigns() {
        text = text.replace(".", "");
        text = text.replaceAll(",", "");
    }

    private static void readTheTextFromFile() {
        text = scannerFromInput.nextLine();
    }


    private static void setTheStream() {
        try {
            fileReader = new FileReader("D:\\Epam_Homeworks\\HW_Collections\\src\\com\\company\\input.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scannerFromInput = new Scanner(fileReader);
    }

    /*private static Stream<HashMap.Entry<String, Integer>> mapToStream(HashMap<String, Integer> hashMap) {
        return hashMap.entrySet().stream();
    }*/
}
