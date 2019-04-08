package ru.mmtr.vocabulary;

public class Console {//сделан для облегчения жизни

    public static void outConsole(String out2) {
        System.out.println("Слово: ");
    }

    public static void outConsole(String out1, String out2) {
        System.out.println("Ключ: " + out1 + " " + "Слово: " + out2);
    }

    public static void outError(Exception e) {
        System.out.println("Ошибка " + e.getMessage());
        System.exit(0);
    }
}