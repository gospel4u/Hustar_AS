package org.joy.parcelable;

import java.io.Serializable;

public class BriefData implements Serializable {
    String name;
    int number;
    String message;

    public BriefData(String name, int number, String message) {
        this.name = name;
        this.number = number;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
