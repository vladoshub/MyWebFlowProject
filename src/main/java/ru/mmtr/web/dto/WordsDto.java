package ru.mmtr.web.dto;

import ru.mmtr.entity.Keys;

import java.io.Serializable;

public class WordsDto implements Serializable {
    private Long id;
    private String word;
    private Keys keys;
    private boolean validate;

    public WordsDto() {

    }

    public void setWords(Keys keys) {
        this.keys = keys;
    }

    public Keys getKeys() {
        return keys;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public boolean isValidate() {
        return validate;
    }

    public long getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }
}
