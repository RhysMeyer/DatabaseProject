package com.tsi.rhys.meyer.DatabaseProject.Film;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Year;

@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int film_id;
    private String title;
    private String description;
    private int release_year;
    private int language_id;
    //private int original_language_id;
    private int rental_duration;
    private double rental_rate;
    private int length;
    private double replacement_cost;
    private String rating;
    private String special_features;

//    public Film(int film_id, String title, String description, Year release_year, int language_id, int original_language_id, int rental_duration, double rental_rate, int length, double replacement_cost) {
//        this.film_id = film_id;
//        this.title = title;
//        this.description = description;
//        this.release_year = release_year;
//        this.language_id = language_id;
//        this.original_language_id = original_language_id;
//        this.rental_duration = rental_duration;
//        this.rental_rate = rental_rate;
//        this.length = length;
//        this.replacement_cost = replacement_cost;
//        this.rating = rating;
//        this.special_features = special_features;
//    }

    public Film()
    {}

    public Film(String title, String description, int release_year, int length, String rating, int language_id) {

        this.title = title;
        this.description = description;
        this.release_year = release_year;
        this.length = length;
        this.rating = rating;
        this.language_id = language_id;

    }
    //saveFilm.getTitle(),saveFilm.getDescription(),saveFilm.getRelease_year(),saveFilm.getLength(),saveFilm.getRating(),saveFilm.getLanguage_id(),saveFilm.getSpecial_features());
    //Film saveFilm = new Film("Test Name", "Description Test",2006, 1, "PG", 90, "Test Feature");
    public Film(String title, String description, int release_year, int length, String rating, int language_id,String special_features ) {

        this.title = title;
        this.description = description;
        this.release_year = release_year;
        this.length = length;
        this.rating = rating;
        this.language_id = language_id;
        this.special_features = special_features;

    }

    public Film(String title) {
    }



    public int getFilm_id() {
        return film_id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getRelease_year() {
        return release_year;
    }

    public int getLanguage_id() {
        return language_id;
    }

//    public int getOriginal_language_id() {
//        return original_language_id;
//    }

    public int getRental_duration() {
        return rental_duration;
    }

    public double getRental_rate() {
        return rental_rate;
    }

    public int getLength() {
        return length;
    }

    public double getReplacement_cost() {
        return replacement_cost;
    }

    public String getRating() {
        return rating;
    }

    public String getSpecial_features() {
        return special_features;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
//
    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

//    public void setOriginal_language_id(int original_language_id) {
//        this.original_language_id = original_language_id;
//    }
//
    public void setRental_duration(int rental_duration) {
        this.rental_duration = rental_duration;
    }

    public void setRental_rate(double rental_rate) {
        this.rental_rate = rental_rate;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setReplacement_cost(double replacement_cost) {
        this.replacement_cost = replacement_cost;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setSpecial_features(String special_features) {
        this.special_features = special_features;
    }


}
