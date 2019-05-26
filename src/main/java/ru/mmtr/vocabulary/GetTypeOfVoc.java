package ru.mmtr.vocabulary;

import java.util.Arrays;
import java.util.List;

public class GetTypeOfVoc {
    private static List<String> vocs = Arrays.asList("Latins_Rus", "Number");

    public static void addVoc(String voc) {
        vocs.add(voc);
    }

    public static String getVocByInt(int voc) {
        return vocs.get(voc);
    }

    public static List<String> getVoc() {
        return vocs;
    }


}
