package ru.mmtr.flow;

import java.io.Serializable;

public class Type implements Serializable {
    private String type;

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
