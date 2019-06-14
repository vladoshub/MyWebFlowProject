package ru.mmtr.vocabulary;

import java.util.List;

 class ServiceChecker {
     static boolean checkWord(String word, Integer num,List<String> regWords) {
            return word.matches(regWords.get(num - 1));
    }

     static boolean checkKey(String word, Integer num,List<String> regKeys) {
            return word.matches(regKeys.get(num - 1));
    }
}
