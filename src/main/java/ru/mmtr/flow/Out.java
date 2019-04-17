package ru.mmtr.flow;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("flow")
public class Out implements Serializable {
    private String outMess ="hello";
    private List<String> outList;
    private int voc=0;


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
}
