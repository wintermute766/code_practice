package test.my;

import java.util.*;
import java.util.stream.Collectors;

class Main {

    static String findNumberOfReplacements(String input) {
        String[] arr = input.split("\n");
        int birthdays = Integer.parseInt(arr[0]);

        String[] result = new String[birthdays];

        for (int i = 1; i < birthdays + 1; i++) {
            int num = numberOfReplacements(arr[i].toCharArray());
            result[i - 1] = String.format("Case #%d: %s", i, num);
        }
        return String.join("\n", result);
    }

    static int numberOfReplacements(char[] arr) {

        Set<Character> vowels = "AEIOU".chars()
                .mapToObj(chr -> (char) chr)
                .collect(Collectors.toSet());
        Set<Character> consonants = "BCDFGHJKLMNPQRSTVWXZ".chars()
                .mapToObj(chr -> (char) chr)
                .collect(Collectors.toSet());

        Map<Character, Integer> cmap = new HashMap<>();
        Map<Character, Integer> vmap = new HashMap<>();

        int cnumber = 0;
        int vnumber = 0;

        for (char key : arr) {
            if (vowels.contains(key) && vmap.containsKey(key)) {
                int freq = vmap.get(key);
                freq++;
                vmap.put(key, freq);
                vnumber++;
            } else if (vowels.contains(key)) {
                vmap.put(key, 1);
                vnumber++;
            } else if (consonants.contains(key) && cmap.containsKey(key)) {
                int freq = cmap.get(key);
                freq++;
                cmap.put(key, freq);
                cnumber++;
            } else {
                cmap.put(key, 1);
                cnumber++;
            }
        }

        int max_count_v = 0;

        for (Map.Entry<Character, Integer> val : vmap.entrySet()) {
            if (max_count_v < val.getValue()) {
                max_count_v = val.getValue();
            }
        }

        int max_count_c = 0;

        for (Map.Entry<Character, Integer> val : cmap.entrySet()) {
            if (max_count_c < val.getValue()) {
                max_count_c = val.getValue();
            }
        }

        int i1 = vnumber + 2 * (cnumber - max_count_c);
        int i2 = cnumber + 2 * (vnumber - max_count_v);

        if (i1 < 0) {
            return i2;
        }

        if (i2 < 0) {
            return i1;
        }

        return Math.min(i1, i2);
    }

    static int numberOfReplacements1(char[] arr) {



        return 0;
    }

    public static void main(String[] args) {

        String s = "7\n" +
                "ABC\n" +
                "2\n" +
                "BA\n" +
                "CA\n" +
                "ABC\n" +
                "2\n" +
                "AB\n" +
                "AC\n" +
                "F\n" +
                "0\n" +
                "BANANA\n" +
                "4\n" +
                "AB\n" +
                "AN\n" +
                "BA\n" +
                "NA\n" +
                "FBHC\n" +
                "4\n" +
                "FB\n" +
                "BF\n" +
                "HC\n" +
                "CH\n" +
                "FOXEN\n" +
                "8\n" +
                "NI\n" +
                "OE\n" +
                "NX\n" +
                "EW\n" +
                "OI\n" +
                "FE\n" +
                "FN\n" +
                "XW\n" +
                "CONSISTENCY\n" +
                "26\n" +
                "AB\n" +
                "BC\n" +
                "CD\n" +
                "DE\n" +
                "EF\n" +
                "FG\n" +
                "GH\n" +
                "HI\n" +
                "IJ\n" +
                "JK\n" +
                "KL\n" +
                "LM\n" +
                "MN\n" +
                "NO\n" +
                "OP\n" +
                "PQ\n" +
                "QR\n" +
                "RS\n" +
                "ST\n" +
                "TU\n" +
                "UV\n" +
                "VW\n" +
                "WX\n" +
                "XY\n" +
                "YZ\n" +
                "ZA";
        System.out.println(findNumberOfReplacements(s));
    }
}