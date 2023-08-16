package ru.pio.tein;

import java.util.Arrays;

public class App
{
    public static void main( String[] args )
    {
        String a = RailFenceCipher.encode("WEAREDISCOVEREDFLEEATONCE", 3);
        System.out.println(a);
        System.out.println(RailFenceCipher.decode(a, 3));
    }
}
