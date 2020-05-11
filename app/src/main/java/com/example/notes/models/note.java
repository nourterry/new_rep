package com.example.notes.models;

import io.realm.RealmObject;

public class note extends RealmObject {
    String name;
    String description;
    boolean ischecked;

    public note() {
    }

    public note(String name, String description, boolean ischecked) {
        this.name = name;
        this.description = description;
        this.ischecked = ischecked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIschecked() {
        return ischecked;
    }

    public void setIschecked(boolean ischecked) {
        this.ischecked = ischecked;
    }
}
