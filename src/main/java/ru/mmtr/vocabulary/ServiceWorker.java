package ru.mmtr.vocabulary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mmtr.entity.Keys;

import java.io.IOException;
import java.util.List;

@Component("ServiceWorker")
public class ServiceWorker {


    @Autowired
    public ServiceWorker(InfoBase infoBase) {
        this.firstVoc = infoBase.getRegexVocFirst();
        this.secondVoc = infoBase.getRegexVocSecond();
    }

    private String firstVoc;
    private String secondVoc;


    public String delByKey(Library Library, Long id) throws IOException {
        return Library.deleteByKey(id);
    }

    public String delByWord(Library Library, Long id) throws IOException {
        return Library.deleteByWord(id);
    }

    public List<String> seacrh(Library Library, Long type) throws IOException {
        System.out.println("введите ключ:");
        String key = Input.input();
        return Library.readFromTxt(key, type);
    }

    public List<Keys> seacrhByKey(Library Library, String key, Long type) throws IOException {
        return Library.searchByKey(key, type);
    }

    public List<Keys> seacrhByWord(Library Library, String word, Long type) throws IOException {
        return Library.searchByWord(word, type);
    }

    public String updateByKey(Library Library, Long id, String newKey, Long type) throws IOException {
        return Library.updateByKey(id, newKey, type);
    }

    public String updateByWord(Library Library, Long id, String newWord, Long type) throws IOException {
        if (searchFromVocabulary(newWord, type))
            return Library.updateByWord(id, newWord, type);
        else return "несоответсвие правилам словаря ";
    }


    public String add(Library Library, Long type, String key, String... word) throws IOException {
        for (String s : word) {
            if (searchFromVocabulary(s, type) == false)
                return "несоответсвие правилам словаря ";
        }
        return Library.addToTxt(key, word, type);
    }

    public String addToKey(Library Library, Long type, Long id, String word) throws IOException {
        if (searchFromVocabulary(word, type) == false)
            return "несоответсвие правилам словаря ";

        return Library.addToKey(id, word, type);
    }

    public List<String> printAll(Library Library, Long type) {
        return Library.printAll(type);
    }

    public List<Keys> printKeys(Library Library, Long type) {
        return Library.getKeys(type);
    }

    public boolean searchFromVocabulary(String word, Long num) {
        if ("Latins_Rus" == GetTypeOfVoc.getVocByInt(num.intValue() - 1)) {
            if (word.matches(firstVoc))
                return true;
            return false;
        } else {

            if (word.matches(secondVoc))
                return true;
            return false;
        }
    }


}