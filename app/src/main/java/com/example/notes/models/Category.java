package com.example.notes.models;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Category extends RealmObject {
    String name;
    String description;
    RealmList<note> notes;
    public Category() {
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RealmList<note> getNotes() {
        return notes;
    }

    public void setNotes(RealmList<note> notes) {
        this.notes = notes;
    }
}
