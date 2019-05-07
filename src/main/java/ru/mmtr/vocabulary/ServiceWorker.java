package ru.mmtr.vocabulary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mmtr.entity.Keys;
import ru.mmtr.entity.Words;

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
    //  private char[] Latinsk = {'A', 'B', 'C', 'D', 'E', 'F', 'Z', 'H', 'I', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'V', 'X'};
    // private char[] Number = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

    public void del(Library Library) throws IOException {//метод для работы с методом удаление клаасс аLibrary
        System.out.println("введите ключ:");
        String key = Input.input();
        Library.deleteByKey(key);
    }
    public String delByKey(Library Library,String key) throws IOException {//метод для работы с методом удаление клаасс аLibrary
        return Library.deleteByKey(key);
    }
    public String delByWord(Library Library,String id) throws IOException {//метод для работы с методом удаление клаасс аLibrary
        return Library.deleteByWord(id);
    }
    public List<String> seacrh(Library Library,int type) throws IOException {//метод для работы с методом поиска по ключу клаасса Library
        System.out.println("введите ключ:");
        String key = Input.input();
       return Library.readFromTxt(key,type);
    }
    public List<Keys> seacrhByKey(Library Library,String key,int type) throws IOException {//метод для работы с методом поиска по ключу клаасса Library
        return Library.searchByKey(key,type);
    }
    public List<Words> seacrhByWord(Library Library, String word, int type) throws IOException {//метод для работы с методом поиска по ключу клаасса Library
        return Library.searchByWord(word,type);
    }

    public String updateByKey(Library Library,String id,String newKey,int type) throws IOException {//метод для работы с методом поиска по ключу клаасса Library
        ListOfVocabulary list=null;
        if(type==1){
             list = ListOfVocabulary.Latins_Rus;
        }
        else
             list = ListOfVocabulary.Number;
        if (searchFromVocabulary(newKey,list))
            return Library.updateByKey(id,newKey,type);
        else return "несоответсвие правилам словаря ";
    }

    public String updateByWord(Library Library,String id,String newWord,int type) throws IOException {//метод для работы с методом поиска по ключу клаасса Library
        return Library.updateByWord(id,newWord,type);
    }

    public void add(Library Library, ListOfVocabulary type) throws IOException {//метод для работы с методом добавление клаасса Library
        System.out.println("введите ключ:");
        String key = Input.input();
        System.out.println("введите слово:");
        String word = Input.input();
        if (searchFromVocabulary(key, type))
            Library.addToTxt(key, word,1);
        else System.out.println("несоответсвие правилам словаря ");
    }

    public String add(Library Library, ListOfVocabulary type,String key,String word) throws IOException {//метод для работы с методом добавление клаасса Library
        int k;
        if(type.name().equals("Latins_Rus"))
            k=1;
        else k=2;
        if (searchFromVocabulary(key, type))
           return Library.addToTxt(key, word,k);
        else return "несоответсвие правилам словаря ";
    }

    public String add(Library Library, ListOfVocabulary type,String key,String[] word) throws IOException {//метод для работы с методом добавление клаасса Library
        int k;
        if(type.name().equals("Latins_Rus"))
            k=1;
        else k=2;
        if (searchFromVocabulary(key, type))
            return Library.addToTxt(key, word,k);
        else return "несоответсвие правилам словаря ";
    }

    public List<String> printAll(Library Library,int type) {//метод для работы с методом печать всего словаря клаасса Library
        return  Library.printAll(type);
    }//метод для работы с методом печать всего словаря клаасса Library
    public List<Keys> printKeys(Library Library, int type) {
        return  Library.getKeys(type);
    }

    public boolean searchFromVocabulary(String word, ListOfVocabulary num) {//поставить регулярку
        if (num == ListOfVocabulary.Latins_Rus) {
            if (word.matches(firstVoc))
                return true;
            return false;
        }
        if (num == ListOfVocabulary.Number) {

            if (word.matches(secondVoc))
                return true;
            return false;
        }
        return false;
    }


}