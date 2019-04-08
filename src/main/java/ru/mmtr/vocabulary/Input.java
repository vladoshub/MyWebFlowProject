package ru.mmtr.vocabulary;

import java.io.*;

public class Input {
    public static String input() throws IOException {//сделал чтобы не писать много кода
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return bufferedReader.readLine();
    }
}
