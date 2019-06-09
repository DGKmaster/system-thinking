package com.hakaton.turistapp1.data;

public class Place {
    String title;
    double coordX;
    double coordY;
    String description;
    String imgURL;
    double rating;
    int id;

    public Place(String title, double coordX, double coordY, String description, String imgURL, double rating, int id) {
        this.title = title;
        this.coordX = coordX;
        this.coordY = coordY;
        this.description = description;
        this.imgURL = imgURL;
        this.rating = rating;
        this.id=id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCoordX(double coordX) {
        this.coordX = coordX;
    }

    public void setCoordY(double coordY) {
        this.coordY = coordY;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public double getCoordX() {
        return coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    public String getDescription() {
        return description;
    }

    public String getImgURL() {
        return imgURL;
    }

    public double getRating() {
        return rating;
    }
}
