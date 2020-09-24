package com.example.booking;

public class book {

    public String  bname,author,selling;

    public book(String bname, String author, String selling) {
        this.bname = bname;
        this.author = author;
        this.selling = selling;

    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSelling() {
        return selling;
    }

    public void setSelling(String selling) {
        this.selling = selling;
    }
}
