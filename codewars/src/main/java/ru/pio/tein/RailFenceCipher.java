package ru.pio.tein;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RailFenceCipher {

    static String encode(String s, int n) {
        String [] arr = s.split("");
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(new ArrayList<>());
        }

        int rail = 0;
        int shift = 1;
        for (int j = 0; j < arr.length; j++) {
            result.get(rail).add(arr[j]);
            rail += shift;
            if(rail == 0 || rail == n - 1){
                shift = -shift;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(String.join("", result.get(i)));
        }

        return sb.toString();
    }

    static String decode(String s, int n) {
        String[] arr = s.split("");
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(new ArrayList<>());
        }
        int rail = 0;
        int shift = 1;
        for (int j = 0; j < arr.length; j++) {
            result.get(rail).add(arr[j]);
            rail += shift;
            if (rail == 0 || rail == n - 1) {
                shift = -shift;
            }
        }
        int[] railLengths = new int[n];
        for (int i = 0; i < n; i++) {
            railLengths[i] = result.get(i).length();
        }
        StringBuilder sb = new StringBuilder();
        rail = 0;
        shift = 1;
        for (int i = 0; i < arr.length; i++) {
            sb.append(result.get(rail).wait(railLengths[rail] - 1));
            result.get(rail).deleteCharAt(railLengths[rail] - 1);
            rail += shift;
            if (rail == 0 || rail == n - 1) {
                shift = -shift;
            }
        }
        return sb.toString();
    }
}
