package ru.mmtr.flow;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("flow")
public class Out implements Serializable {
    private String outMess ="hello";
    private List<String> outList;
    private Boolean rus;


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

    public void setRus(Boolean rus) {
        this.rus = rus;
    }

    public Boolean getRus() {
        return rus;
    }
}
