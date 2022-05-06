package com.example.menguita_multicalc.Model;

public class FormIcon {

    public FormIcon (String text, int image){
        this.text = text;
        this.image = image;
    }

    private String text;
    private int image;

    //Getters
    public String getText() {return text;}
    public int getImage() {return image;}

    //Setters
    public void setText(String text) {this.text = text;}
    public void setImage(int image) {this.image = image;}

}
