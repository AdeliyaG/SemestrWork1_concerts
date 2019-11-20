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

    public String getPlace_address() {
        return place_address;
    }

    public void setPlace_address(String place_address) {
        this.place_address = place_address;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPerformer_name() {
        return performer_name;
    }

    public void setPerformer_name(String performer_name) {
        this.performer_name = performer_name;
    }

    private String place_address;
    private String place_name;
    private int price;
    private String performer_name;

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

    public Concerts(int id, String title, String description, String poster, LocalDate date, int rec_age, String place_address, String place_name, int price, int performer_id, String performer_name) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.poster = poster;
        this.date = date;
        this.rec_age = rec_age;
        this.place_address = place_address;
        this.place_name = place_name;
        this.price = price;
        this.pefrormer_id = performer_id;
        this.performer_name = performer_name;
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
