package com.example.bookdatabase;

public class BookModel {
    String bookName;
    String bookAuthor;
    String pubYear;
    double price;

    public BookModel(String bookName, String bookAuthor, String pubYear, double price) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.pubYear = pubYear;
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getPubYear() {
        return pubYear;
    }

    public double getPrice() {
        return price;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setPubYear(String pubYear) {
        this.pubYear = pubYear;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
