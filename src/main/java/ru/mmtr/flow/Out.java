package ru.mmtr.flow;

import ru.mmtr.entity.Keys;
import ru.mmtr.entity.Words;
import ru.mmtr.web.dto.KeysDto;
import ru.mmtr.web.dto.WordsDto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("flow")
public class Out implements Serializable {
    private String outMess;
    private List<Keys> keys;
    private List<Words> words;
    private KeysDto keysDto;
    private WordsDto wordsDto;

    public KeysDto getKeysDtos() {
        return keysDto;
    }

    public WordsDto getWordsDtos() {
        return wordsDto;
    }

    public void setKeysDtos(KeysDto keysDtos) {
        this.keysDto = keysDtos;
    }

    public void setWordsDtos(WordsDto wordsDtos) {
        this.wordsDto = wordsDtos;
    }

    public Out() {

    }

    public Out(String outMess) {
        this.outMess = outMess;
    }


    public String getOutMess() {

        return outMess;
    }

    public void setOutMess(String outMess) {
        if (outMess == null)
            this.outMess = "server error";
        else
            this.outMess = outMess;
    }

    public void setKeys(List<Keys> keys) {
        this.keys = keys;
    }

    public List<Keys> getKeys() {

        return keys;
    }

    public List<Words> getWords() {
        return words;
    }

    public void setWords(List<Words> words) {
        this.words = words;
    }
}
