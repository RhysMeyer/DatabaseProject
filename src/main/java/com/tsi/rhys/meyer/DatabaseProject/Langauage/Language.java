package com.tsi.rhys.meyer.DatabaseProject.Langauage;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Language {

    @Id
    @GeneratedValue
    private int language_id;

    private String name;

    public Language(String name){
        this.name=name;
    }

    public Language(){

    }

    public  void setLanguage_id(int id){
        this.language_id = id;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
