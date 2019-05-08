package ru.mmtr.vocabulary;

import java.util.Arrays;
import java.util.List;

public  class getTypeOfVoc {
    private static List<String> Vocs=Arrays.asList("Latins_Rus", "Number");
    public static void addVoc(String voc){
        Vocs.add(voc);
    }
    public static String getVocByInt(int voc){
        return Vocs.get(voc);
    }
    public static List<String> getVoc(){
        return Vocs;
    }



}
