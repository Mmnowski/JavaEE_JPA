package com.example.restejbjpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class MovieCategory {

    private long id;
    private String genre;
    private boolean adult;
    private boolean isThreeDimension;

    public MovieCategory() {
        super();
    }

    public MovieCategory(String genre, boolean adult, boolean isThreeDimension) {
        this.adult = adult;
        this.isThreeDimension = isThreeDimension;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean getAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public boolean getThreeDimension() {
        return isThreeDimension;
    }

    public void setThreeDimension(boolean isThreeDimension) {
        this.isThreeDimension = isThreeDimension;
    }

}
