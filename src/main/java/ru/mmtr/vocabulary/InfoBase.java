package ru.mmtr.vocabulary;

public class InfoBase {

    private String fileName;
    private String regexVocFirst;
    private String regexVocSecond;
    private String regexVocFirstLib;
    private String regexVocSecondLib;

    InfoBase(String fileName, String regexVocFirst, String regexVocSecond, String regexVocFirstLib, String regexVocSecondLib) {
        this.fileName = fileName;
        this.regexVocFirst = regexVocFirst;
        this.regexVocSecond = regexVocSecond;
        this.regexVocFirstLib = regexVocFirstLib;
        this.regexVocSecondLib = regexVocSecondLib;

    }

    public String getRegexVocFirst() {
        return regexVocFirst;
    }

    public String getFileName() {
        return fileName;
    }

    public String getRegexVocSecond() {
        return regexVocSecond;
    }

    public String getRegexVocFirstLib() {
        return regexVocFirstLib;
    }

    public String getRegexVocSecondLib() {
        return regexVocSecondLib;
    }
}
