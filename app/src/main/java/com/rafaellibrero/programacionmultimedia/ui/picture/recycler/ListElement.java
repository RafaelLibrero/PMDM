package com.rafaellibrero.programacionmultimedia.ui.picture.recycler;

import java.io.Serializable;

public class ListElement implements Serializable {

    public String name;
    public String year;
    public String ubication;
    public int image;

    public ListElement(String name, String year, String ubication, int image) {
        this.name = name;
        this.year = year;
        this.ubication = ubication;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year){
        this.year = year;
    }

    public String getUbication() {
        return ubication;
    }

    public void setUbication(String ubication){
        this.ubication = ubication;
    }

    public int getImage () {
        return image;
    }

    public void setImage(int image){
        this.image = image;
    }

}
