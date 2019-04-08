package com.example.projecttest2;

public class Model {

    String image, name, water, sun, loc;

    public Model() {

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getSun() {
        return sun;
    }

    public void setSun(String sun) {
        this.sun = sun;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }


    public Model(String image, String name, String water, String sun, String loc, String id) {
        this.image = image;
        this.name = name;
        this.water = water;
        this.sun = sun;
        this.loc = loc;

    }
}