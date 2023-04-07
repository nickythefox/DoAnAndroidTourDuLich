package com.example.doanandroidtourdulich.model;

import android.widget.Button;

public class Home {
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

    public int getImgTour() {
        return imgTour;
    }

    public void setImgTour(int imgTour) {
        this.imgTour = imgTour;
    }

    public int imgTour;

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

    public Home( int imgTour, String nanme, String price) {
        this.imgTour = imgTour;
        this.nanme = nanme;
        this.price = price;
    }
}
