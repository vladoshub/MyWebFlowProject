package ru.mmtr.vocabulary;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mmtr.dao.KeysDao;
import ru.mmtr.dao.KeysDaoImpl;
import ru.mmtr.entity.Keys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component("ServiceWorker")
public class ServiceWorker {


    @Autowired
    public ServiceWorker(InfoBase infoBase,SessionFactory ses) {
        keysDao = new KeysDaoImpl(ses);
        this.firstVocWords = infoBase.getRegexVocFirstWords();
        this.secondVocWords = infoBase.getRegexVocSecondWords();
        this.firstVocKeys = infoBase.getRegexVocFirstKeys();
        this.secondVocKeys = infoBase.getRegexVocSecondKeys();

    }


    private KeysDao keysDao;
    private String firstVocWords;
    private String secondVocWords;
    private String firstVocKeys;
    private String secondVocKeys;


    public String delByKey(Library Library, Long id) throws IOException {
        return Library.deleteByKey(id);
    }

    public String delByWord(Library Library, Long id) throws IOException {
        return Library.deleteByWord(id);
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
        if (checkWord(newWord, type))
            return Library.updateByWord(id, newWord, type);
        else return "несоответсвие правилам словаря ";
    }


    public String add(Library Library, Long type, String key, List<String> words) throws IOException {
        if(!checkKey(key,type))
            return "ключ не относится к данному словарю";
        List<String> newWords = new ArrayList<String>();
        for (String s : words) {
            if (checkWord(s, type))
                newWords.add(s);
        }
        if(newWords.size()==0) {
            return "ни 1 слово не подходит по правилам словаря";
        }
        else
        return Library.addToTxt(key, newWords, type);
    }

    public String add(Library Library, Long type, String key, String word) throws IOException {
        if(!checkKey(key,type))
            return "ключ не относится к данному словарю";
            if (!checkWord(word, type))
                return "несоответсвие правилам словаря ";
        return Library.addToTxt(key, word, type);
    }

    public String addToKey(Library Library, Long type, Long id, List<String> words) throws IOException {
        List<String> newWords = new ArrayList<String>();
        for (String s:words) {
            if (checkWord(s, type))
                newWords.add(s);
        }
        if (newWords.size()==0)
        return "ни 1 слово не подходит по правилам словаря";

        return Library.addToKey(id,newWords,type);
    }

    public String addToKey(Library Library, Long type, Long id, String words) throws IOException {

            if (!checkWord(words, type))
            return "слово не подходит по правилам словаря";

        return Library.addToKey(id,words,type);
    }

    public List<String> printAll(Library Library, Long type) {
        return Library.printAll(type);
    }

    public List<Keys> printKeys(Library Library, Long type) {
        return Library.getKeys(type);
    }

    public boolean checkWord(String word, Long num) {
        if ("Latins_Rus".equals(GetTypeOfVoc.getVocByInt(num.intValue() - 1))) {
            if (word.matches(firstVocWords))
                return true;
            return false;
        } else {

            if (word.matches(secondVocWords))
                return true;
            return false;
        }
    }

    public boolean checkKey(String word, Long num) {
        if ("Latins_Rus".equals(GetTypeOfVoc.getVocByInt(num.intValue() - 1))) {
            if (word.matches(firstVocKeys))
                return true;
            return false;
        } else {

            if (word.matches(secondVocKeys))
                return true;
            return false;
        }
    }


  /*  public boolean checkWord(String word, Long num,Library library) {
        if ("Latins_Rus".equals(GetTypeOfVoc.getVocByInt(num.intValue() - 1))) {
            if (word.matches(library.getRegWord(num)))
                return true;
            return false;
        } else {

            if (word.matches(library.getRegKey(num)))
                return true;
            return false;
        }
    }

    public boolean checkKey(String word, Long num,Library library) {
        if ("Latins_Rus".equals(GetTypeOfVoc.getVocByInt(num.intValue() - 1))) {
            if (word.matches(library.getRegKey(num)))
                return true;
            return false;
        } else {

            if (word.matches(library.getRegKey(num)))
                return true;
            return false;
        }
    }
*/

}