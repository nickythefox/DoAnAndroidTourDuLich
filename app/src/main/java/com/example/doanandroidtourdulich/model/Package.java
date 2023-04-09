package com.example.doanandroidtourdulich.model;

import android.widget.Button;
import android.widget.ImageView;

import java.io.Serializable;

public class Package implements Serializable {
    public String getNanme() {
        return nanme;
    }

    public Button getBtndetail() {
        return btndetail;
    }

    public void setBtndetail(Button btndetail) {
        this.btndetail = btndetail;
    }



    public Button btndetail;


    public byte[] getImgTour() {
        return imgTour;
    }

    public void setImgTour(byte[] imgTour) {
        this.imgTour = imgTour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int id;


    public byte[] imgTour;

    public String getDecsriptiion() {
        return decsriptiion;
    }

    public void setDecsriptiion(String decsriptiion) {
        this.decsriptiion = decsriptiion;
    }

    public String decsriptiion;

    public void setNanme(String nanme) {
        this.nanme = nanme;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String nanme;



    private String price;

    public Package( byte[] imgTour, String nanme, String price) {
        this.imgTour = imgTour;
        this.nanme = nanme;
        this.price = price;
    }
    public Package(byte[] imgTour, String nanme, String price,String decsriptiion){
        this.imgTour = imgTour;
        this.nanme = nanme;
        this.price = price;
        this.decsriptiion=decsriptiion;

    }

}
