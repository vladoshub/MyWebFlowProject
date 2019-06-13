package ru.mmtr.vocabulary;

public class InfoBase {

    private String regexVocFirstWords;
    private String regexVocSecondWords;
    private String regexVocSecondKeys;
    private String regexVocFirstKeys;

    InfoBase(String regexVocFirstWords, String regexVocSecondWords, String regexVocFirstKeys, String regexVocSecondKeys) {
        this.regexVocFirstWords = regexVocFirstWords;
        this.regexVocSecondWords = regexVocSecondWords;
        this.regexVocFirstKeys = regexVocFirstKeys;
        this.regexVocSecondKeys = regexVocSecondKeys;

    }

    public String getRegexVocFirstWords() {
        return regexVocFirstWords;
    }

    public String getRegexVocSecondWords() {
        return regexVocSecondWords;
    }

    public String getRegexVocSecondKeys() {
        return regexVocSecondKeys;
    }

    public String getRegexVocFirstKeys() {
        return regexVocFirstKeys;
    }
}
