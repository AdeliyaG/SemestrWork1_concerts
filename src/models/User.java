package models;

import java.time.LocalDate;
import java.util.*;

public class User {
    private int id;
    private String username;
    private String firstname;
    private String lastname;
    private LocalDate birthLocalDate;
    private String password;
    private String avatar;

    public User(int id, String username, String firstname, String lastname, LocalDate birthLocalDate, String password, String avatar) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthLocalDate = birthLocalDate;
        this.password = password;
        this.avatar = avatar;
    }

    public User(String username, String firstname, String lastname, String password) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
    }

    public User(String username, String firstname, String lastname, String password, String avatar) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthLocalDate() {
        return birthLocalDate;
    }

    public void setBirthLocalDate(LocalDate birthLocalDate) {
        this.birthLocalDate = birthLocalDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
