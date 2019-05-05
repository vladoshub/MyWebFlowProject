package ru.mmtr.vocabulary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mmtr.entity.Keys;
import ru.mmtr.entity.Words;
import ru.mmtr.flow.Out;

import java.io.IOException;
import java.util.List;


@Component("ChangeOps")

public class ChangeOps {


    private Library library;
    private ServiceWorker serviceWorker;
    private static String message;
    ListOfVocabulary vocabulary = null;
    Out out;



    @Autowired
    public ChangeOps(Library library, ServiceWorker serviceWorker) {
        this.library = library;
        this.serviceWorker = serviceWorker;
        out=new Out();
    }

    private Out createOut(List<String> input){
        Out out = new Out(input);
        return out;
    }

    private Out createOut(String input){
         Out out = new Out(input);
        return out;
    }

    private Out createOutKeys(List <Keys> keys){
        Out out = new Out();
        if(keys!=null) {
           out.setKeys(keys);
        }
        else
            out.setOutMess("no match");
        return out;
    }

    private Out createOutWords(List <Words> words){
        Out out = new Out();
        if(words!=null) {
            out.setWords(words);
        }
        else
            out.setOutMess("no match");
        return out;
    }

    public Out createOut(){
        Out out = new Out();
        return out;
    }
    public Out delFromWebByKey(String key, int typeOfVoc) throws IOException
    {
    serviceWorker.delByKey(library,key);
    return this.printKeys(typeOfVoc);
    }

    public Out delFromWebByWord(String id,int typeOfVoc) throws IOException
    {
        serviceWorker.delByWord(library,id);
        return this.printKeys(typeOfVoc);
    }

    public Out updateByKeyFromWeb(String id, String newKey,int typeOfVoc) throws IOException
    {
        serviceWorker.updateByKey(library,id,newKey,typeOfVoc);
        return this.printKeys(typeOfVoc);
    }

    public Out updateByWordFromWeb(String id, String newWord,int typeOfVoc) throws IOException
    {
        serviceWorker.updateByKey(library,id,newWord,typeOfVoc);
        return this.printKeys(typeOfVoc);
    }
    public  Out searchFromWebByKey(String key, int typeOfVoc) throws IOException
    {
        return createOutKeys(serviceWorker.seacrhByKey(library,key,typeOfVoc));
    }
    public  Out searchFromWebByWords(String word, int typeOfVoc) throws IOException
    {
        return createOutWords(serviceWorker.seacrhByWord(library,word,typeOfVoc));
    }
    public Out addFromWeb(String key,String word,String voc) throws IOException
    {
        int num = Integer.parseInt(voc);
        if (num == 1) {
            vocabulary = ListOfVocabulary.Latins_Rus;

        } else if (num == 2) {
            vocabulary = ListOfVocabulary.Number;
        }
        String[] words = word.split("%_%");

        return createOut(serviceWorker.add(library,vocabulary,key,words));
    }
    public Out print(int typeOfVoc) throws IOException
    {

        return createOut(serviceWorker.printAll(library,typeOfVoc));
    }

    public Out printKeys(int typeOfVoc) throws IOException
    {
       out.setKeys(serviceWorker.printKeys(library,typeOfVoc));
       return out;
    }

    /*public void enterPoint() throws IOException { //для ком.строки

        System.out.println("1-латино-русский");
        System.out.println("2-десятично-доичный");
        int num = Integer.parseInt(Input.input());
        if (num == 1) {
            vocabulary = ListOfVocabulary.Latins_Rus;
            System.out.println("Вы выбрали латинско-русский,введите местоположение файла на диске...");

        } else if (num == 2) {
            vocabulary = ListOfVocabulary.Number;
            System.out.println("Вы выбрали десятично-доичный,введите местоположение файла на диске...");
        }
        while (true) {
            String Change;
            System.out.println("Выберите операцию:");
            System.out.println("удаление-1");
            System.out.println("поиск по ключу-2");
            System.out.println("добавление записи-3");
            System.out.println("вывод словаря-4");
            Change = Input.input();
            switch (Change) {
                case "1":
                    serviceWorker.delFromWebByKey(library);
                    break;
                case "2":
                    serviceWorker.seacrh(library);
                    break;
                case "3":
                    serviceWorker.add(library, vocabulary);
                    break;
                case "4":
                    serviceWorker.printAll(library);
                    break;
                default:
                    System.out.println("неправильный ввод");
                    break;
            }
            System.out.println("Хотите продолжить?Введите:y");
            Change = Input.input();
            if (!Change.equals("y"))
                break;
        }

    }
    */

}
