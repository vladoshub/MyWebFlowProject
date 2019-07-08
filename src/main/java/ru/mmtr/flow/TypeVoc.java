package ru.mmtr.flow;

import ru.mmtr.entity.Type;

import java.io.Serializable;

public class TypeVoc implements Serializable {
    public static Type type;

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

}
