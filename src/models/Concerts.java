package models;

import java.time.LocalDate;

public class Concerts {
    private int id;
    private String title;
    private String description;
    private String poster;
    private LocalDate date;
    private int place_id;
    private int rec_age;
    private int pefrormer_id;

    public Concerts(int id, String title, String description, String poster, LocalDate date, int place_id, int rec_age, int pefrormer_id) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.poster = poster;
        this.date = date;
        this.place_id = place_id;
        this.rec_age = rec_age;
        this.pefrormer_id = pefrormer_id;
    }

    public Concerts(String title, String description, String poster, LocalDate date, int place_id, int rec_age, int pefrormer_id) {
        this.title = title;
        this.description = description;
        this.poster = poster;
        this.date = date;
        this.place_id = place_id;
        this.rec_age = rec_age;
        this.pefrormer_id = pefrormer_id;
    }

    public Concerts(int id, String title, String poster, LocalDate date) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getPlace_id() {
        return place_id;
    }

    public void setPlace_id(int place_id) {
        this.place_id = place_id;
    }

    public int getRec_age() {
        return rec_age;
    }

    public void setRec_age(int rec_age) {
        this.rec_age = rec_age;
    }

    public int getPefrormer_id() {
        return pefrormer_id;
    }

    public void setPefrormer_id(int pefrormer_id) {
        this.pefrormer_id = pefrormer_id;
    }
}
