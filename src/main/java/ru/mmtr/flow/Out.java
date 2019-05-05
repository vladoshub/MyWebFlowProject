package ru.mmtr.flow;

import ru.mmtr.dao.KeysDaoImpl;
import ru.mmtr.entity.Keys;
import ru.mmtr.entity.Words;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("flow")
public  class Out implements Serializable {
    private String outMess;
    private List<String> outList;
    private int voc;
    private String inp;
    private List<Keys> keys;
    private List<Words> words;


    public Out() {

    }


    public Out(List<String> outList) {
        if(outList!=null) {
            this.outMess = outList.get(0);
            outList.remove(0);
            this.outList = outList;
        }
    }
    public Out(String outMess) {
        this.outMess = outMess;
    }

    public List<String> getOutList() {
        return outList;
    }

    public String getOutMess() {
        return outMess;
    }

    public void setOutList(List<String> outList) {
        this.outList = outList;
    }

    public void setOutMess(String outMess) {
        this.outMess = outMess;
    }

    public void setVoc(int rus) {
        this.voc = rus;
    }

    public int getVoc() {
        return voc;
    }

    public String getInp() {
        return inp;
    }

    public void setInp(String inp) {
        this.inp = inp;
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
