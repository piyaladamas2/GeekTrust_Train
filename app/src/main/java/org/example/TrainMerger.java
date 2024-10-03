package org.example;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TrainMerger {
      static Map<String, Integer> distanceA = new LinkedHashMap<>();
    static Map<String, Integer> distanceB = new LinkedHashMap<>();

    static {
        // Train A
        distanceA.put("CHN", 0);
        distanceA.put("SLM", 350);
        distanceA.put("BLR", 550);
        distanceA.put("KRN", 900);
        distanceA.put("HYB", 1200);  // Meeting point
        distanceA.put("NGP", 1600);
        distanceA.put("ITJ", 1900);
        distanceA.put("BPL", 2000);
        distanceA.put("AGA", 2500);
        distanceA.put("NDL", 2700);


        distanceB.put("TVC", 0);
        distanceB.put("SRR", 300);
        distanceB.put("MAQ", 600);
        distanceB.put("MAO", 1000);
        distanceB.put("PNE", 1400);
        distanceB.put("HYB", 2000);  // Meeting point
        distanceB.put("NGP", 2400);
        distanceB.put("ITJ", 2700);
        distanceB.put("BPL", 2800);
        distanceB.put("PTA", 3800);
        distanceB.put("NJP", 4200);
        distanceB.put("GHY", 4700);

    }


    static class Bogie {
        String destination;
        int distanceFromHYB;

        Bogie(String destination, int distanceFromHYB) {
            this.destination = destination;
            this.distanceFromHYB = distanceFromHYB;
        }
    }

    // Merge and sort bogies based on remaining distance from HYB
    public static List<Bogie> mergeAndSortBogies(List<String> trainA, List<String> trainB) {
        List<Bogie> bogies = new ArrayList<>();

        // Add bogies from Train A
        for (String destination : trainA) {
            int distance = distanceA.get(destination) - distanceA.get("HYB");
            bogies.add(new Bogie(destination, distance));
        }

        // Add bogies from Train B
        for (String destination : trainB) {
            int distance = distanceB.get(destination) - distanceB.get("HYB");
            bogies.add(new Bogie(destination, distance));
        }

        // Sort by distance from HYB in descending order
        bogies.sort((b1, b2) -> Integer.compare(b2.distanceFromHYB, b1.distanceFromHYB));

        return bogies;
    }
}
