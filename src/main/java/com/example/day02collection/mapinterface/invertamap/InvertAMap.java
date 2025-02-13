package com.example.day02collection.mapinterface.invertamap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class InvertAMap {
        public static <K, V> Map<V, List<K>> invertMap(Map<K, V> inputMap) {
            Map<V, List<K>> invertedMap = new HashMap<>();

            for (Map.Entry<K, V> entry : inputMap.entrySet()) {
                V value = entry.getValue();
                K key = entry.getKey();

                // Get the list if value already exists, otherwise create a new list
                invertedMap.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
            }
            return invertedMap;
        }

        public static void main(String[] args) {
            Map<String, Integer> input = new HashMap<>();
            input.put("A", 1);
            input.put("B", 2);
            input.put("C", 1);

            Map<Integer, List<String>> result = invertMap(input);
            System.out.println("Inverted map : " + result);
        }
    }
