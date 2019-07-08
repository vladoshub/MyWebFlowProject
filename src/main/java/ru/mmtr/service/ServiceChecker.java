package ru.mmtr.service;

import ru.mmtr.flow.TypeVoc;

import java.util.HashMap;
import java.util.List;

class ServiceChecker {


    static boolean checkWord(String word) {
        return word.matches(TypeVoc.type.getRegWords());
    }

    static boolean checkKey(String word) {
        return word.matches(TypeVoc.type.getRegKeys());
    }
}
