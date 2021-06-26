package com.practice;

import java.util.*;

public class NearByDistance {

    public Integer getShortDist(Map<String, Integer> distance) {

            List<Integer> dist = new ArrayList<>(distance.values());
            dist.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
            int bestPathCounetr = 0;
            int bestPath = dist.size() / 2;
            for (Integer vl : dist ) {
                if (bestPath == bestPathCounetr) {
                    return vl;
                }
                bestPathCounetr++;

            }

            return null;
        }

    public Integer findBestPlace(List<Map<String, Boolean>> blocks, List<String> request){
        Map<String, Integer> distance = new HashMap<>();
        int counter = 0;
        int resetCounter = request.size()+1;
        for(Map<String, Boolean> block : blocks) {
            for (String req : request) {
                if (block.get(req) == true) {
                    if(distance.get(req) == null || (counter - distance.get(req)) != 1)
                        distance.put(req, counter);
                } else if (resetCounter == 0) {
                    distance.remove(req);
                }

                if (resetCounter == 0 && distance.size() == request.size()) {
                    return getShortDist(distance);
                }
            }
            if (resetCounter == 0) {
                resetCounter = request.size();
            } else {
                resetCounter--;
            }

            if (distance.size() == request.size()) {
                return getShortDist(distance);
            }
            counter++;
        }

        return null;
    }

    public static void main(String[] args) {
        List<Map<String, Boolean>> blocks = new ArrayList<>();

        Map<String, Boolean> block1 = new HashMap<>();
        block1.put("gym" , false);
        block1.put("school" , true);
        block1.put("store" , false);

        blocks.add(block1);

        Map<String, Boolean> block2 = new HashMap<>();
        block2.put("gym" , true);
        block2.put("school" , false);
        block2.put("store" , false);

        blocks.add(block2);

        Map<String, Boolean> block3 = new HashMap<>();
        block3.put("gym" , true);
        block3.put("school" , false);
        block3.put("store" , false);

        blocks.add(block1);

        Map<String, Boolean> block4 = new HashMap<>();
        block4.put("gym" , false);
        block4.put("school" , true);
        block4.put("store" , true);

        Map<String, Boolean> block5 = new HashMap<>();
        block5.put("gym" , false);
        block5.put("school" , true);
        block5.put("store" , true);

        blocks.add(block5);


        List<String> request = new ArrayList<>();

        request.add("gym");
        request.add("school");
        request.add("store");

        NearByDistance nbd = new NearByDistance();
        System.out.println(nbd.findBestPlace(blocks, request));

    }
}
