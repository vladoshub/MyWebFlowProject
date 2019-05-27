package ru.mmtr.web.dto;

import ru.mmtr.entity.Keys;
import ru.mmtr.entity.Words;

import java.util.List;

public class KeysDto {
    private Long id;
    private String key;
    private List<Words> words;
    private boolean validate;

    public KeysDto(){

    }

    public void setWords(List<Words> words) {
        this.words = words;
    }

    public List<Words> getWords() {
        return words;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isValidate() {
        return validate;
    }

    public long getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }

}
