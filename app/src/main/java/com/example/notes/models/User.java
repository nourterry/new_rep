package com.example.notes.models;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

public class User extends RealmObject {
    private String Firstname;
    private  String Lastname;
    private  String Email;
    private  String phone;
    private  String Passward;
    private RealmList<Category> categories=new RealmList<>();

    public User() {
    }

    public User(String firstname, String lastname, String email, String phone, String passward) {
        Firstname = firstname;
        Lastname = lastname;
        Email = email;
        this.phone = phone;
        Passward = passward;
    }

    public User(String firstname, String lastname, String email, String phone, String passward, RealmList<Category> categories) {
        Firstname = firstname;
        Lastname = lastname;
        Email = email;
        this.phone = phone;
        Passward = passward;
        this.categories = categories;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassward() {
        return Passward;
    }

    public void setPassward(String passward) {
        Passward = passward;
    }

    public RealmList<Category> getCategories() {
        return categories;
    }

    public void setCategories(RealmList<Category> categories) {
        this.categories = categories;
    }
}
