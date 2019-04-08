package ru.mmtr.vocabulary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component("ChangeOps")

public class ChangeOps {


    private Library library;
    private ServiceWorker serviceWorker;
    private static String message;




    @Autowired
    public ChangeOps(Library library, ServiceWorker serviceWorker) {
        this.library = library;
        this.serviceWorker = serviceWorker;
    }

    public void enterPoint() throws IOException {
        ListOfVocabulary vocabulary = null;
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
                    serviceWorker.del(library);
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

}
