package ru.pio.tein;

import java.util.*;
import java.util.stream.LongStream;

public class Solutions {

    public static String solEquaStr(long n) {
        StringJoiner joiner = new StringJoiner(", ");
        int d = (int) (n / 2) + 2;
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                if((((long) i * i) - (4L * j * j)) == n)
                    joiner.add(String.valueOf(i));
            }
        }
        return joiner.toString();
    }
    public static long properFractions(long n) {
        if (n == 1) return 0;
        return LongStream.range(0L, n + 1)
                .filter(i ->  gcd(i, n)).count();
    }
    private static boolean gcd(long a, long b){
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a == 1;
    }
}
