package ru.mmtr.vocabulary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mmtr.entity.Keys;
import ru.mmtr.entity.Words;
import ru.mmtr.flow.Out;

import java.io.IOException;
import java.util.List;


@Component("ChangeOps")

public class Choice {


    private Library library;
    private ServiceWorker serviceWorker;
    public Out out;


    @Autowired
    public Choice(Library library, ServiceWorker serviceWorker) {
        this.library = library;
        this.serviceWorker = serviceWorker;
        out = new Out();
    }


    private Out createOutKeys(List<Keys> keys) {
        Out out = new Out();
        if (keys != null && keys.size() != 0) {
            out.setKeys(keys);
        } else
            out.setOutMess("no match");
        return out;
    }

    private Out createOutWords(List<Words> words) {
        Out out = new Out();
        if (words != null && words.size() != 0) {
            out.setWords(words);
        } else
            out.setOutMess("no match");
        return out;
    }

    public Out createOut() {
        return new Out();
    }

    public Out delFromWebByKey(String key, int typeOfVoc) throws IOException {
        return printKeys(typeOfVoc, serviceWorker.delByKey(library, key));
    }

    public Out delFromWebByWord(String id, int typeOfVoc) throws IOException {
        return printKeys(typeOfVoc, serviceWorker.delByWord(library, id));
    }

    public Out updateByKeyFromWeb(String id, String newKey, int typeOfVoc) throws IOException {
        return printKeys(typeOfVoc, serviceWorker.updateByKey(library, id, newKey, typeOfVoc));
    }

    public Out updateByWordFromWeb(String id, String newWord, int typeOfVoc) throws IOException {
        return printKeys(typeOfVoc, serviceWorker.updateByWord(library, id, newWord, typeOfVoc));
    }

    public Out searchFromWebByKey(String key, int typeOfVoc) throws IOException {
        return createOutKeys(serviceWorker.seacrhByKey(library, key, typeOfVoc));
    }

    public Out searchFromWebByWords(String word, int typeOfVoc) throws IOException {
        return createOutKeys(serviceWorker.seacrhByWord(library, word, typeOfVoc));
    }

    public Out addFromWeb(String key, String word, int voc) throws IOException {


        return printKeys(voc, serviceWorker.add(library, voc, key, word));

    }

    public Out addFromWebtoKey(String id, String word, int voc) throws IOException {
        return printKeys(voc, serviceWorker.addToKey(library, voc, id, word));

    }

    public Out printKeys(int typeOfVoc) throws IOException {
        out.setOutMess("");
        out.setKeys(serviceWorker.printKeys(library, typeOfVoc));
        return out;
    }

    public Out printKeys(int typeOfVoc, String inPut) throws IOException {
        out.setKeys(serviceWorker.printKeys(library, typeOfVoc));
        out.setOutMess(inPut);
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