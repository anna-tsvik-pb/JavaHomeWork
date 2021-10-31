package com.pb.tsvik.hw5;

public class Book {

    private static int bookCount = 0;

    public static int getBookCount() {
        return bookCount;
    }

    private String name;
    private String author;
    private int year;

    public Book(String name, String author, int year) {
        this(name);
        this.author = author;
        this.year = year;
    }

    public Book(String name) {
        this.name = name;
        bookCount++;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String getAuthor() {
        return author;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public int getYear() {
        return year;
    }

    String getInfo() {
        return "[название: " + name + ", автор: " + author + ", год создания: " + year + "]";
    }

}
