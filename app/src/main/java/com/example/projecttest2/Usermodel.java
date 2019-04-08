package com.example.projecttest2;

public class Usermodel {


    String email;
    String name;
    String password;
    String plantName;
    String image;

    public Usermodel() {
    }

    public Usermodel(String email, String name, String password, String plantName, String image) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.plantName = plantName;
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }
}