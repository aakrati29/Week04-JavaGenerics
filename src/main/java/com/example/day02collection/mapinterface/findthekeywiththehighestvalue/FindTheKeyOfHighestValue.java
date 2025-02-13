package com.example.day02collection.mapinterface.findthekeywiththehighestvalue;

import java.util.HashMap;
import java.util.Map;

public class FindTheKeyOfHighestValue {
    static String findTheKeyOfHighestValue(Map<String, Integer> map) {
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (String key : map.keySet()) {
            if (map.get(key) > maxValue) {
                maxValue = map.get(key);
                maxKey = key;
            }
        }
        return maxKey;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        String result = findTheKeyOfHighestValue(map);
        System.out.println("Key with the highest value: " + result);
    }
}
