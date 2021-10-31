package com.pb.tsvik.hw5;

public class Reader {

    private String fio;
    private int numberReader;
    private String faculty;
    private String birthDate;
    private String numberPhone;


    public Reader(String fio, int numberReader, String faculty, String birthDate, String numberPhone) {
        this.fio = fio;
        this.numberPhone = numberPhone;
        this.faculty = faculty;
        this.numberReader = numberReader;
        this.birthDate = birthDate;
    }

    public String getFio() {
        return fio;
    }

    public void takeBook(int tCount){
        System.out.println(fio + " взял " + tCount + " книги");
    }

    public void returnBook(int rCount){
        System.out.println(fio + " вернул " + rCount + " книги");
    }

    public void takeBook(String... names) {
        System.out.print(fio + " взял книги:");
        for (String name : names) {
            System.out.print(" " + name + ",");
        }
        System.out.println("\b");
    }

    public void returnBook(String... names){
        System.out.print(fio + " вернул книги:" );
        for (String name: names) {
            System.out.print(" " + name + ",");
        }
        System.out.println("\b");
    }

    public void takeBook(Book... books) {
        System.out.print(fio + " взял книги:");
        for (Book book : books) {
            System.out.print(" " + book.getName() + " (" + book.getAuthor() + ", " + book.getYear() + " г.),");
        }
        System.out.println("\b");
    }

    public void returnBook(Book... books) {
        System.out.print(fio + " вернул книги:");
        for (Book book : books) {
            System.out.print(" " + book.getName() + " (" + book.getAuthor() + ", " + book.getYear() + " г.),");
        }
        System.out.println("\b");
    }


    String getInfo() {
        return "[ФИО: " + fio + ", номер читательского билета: " + numberReader + ", факультет: " + faculty + ", дата рождения: " + birthDate + ", телефон: " + numberPhone + "]";
    }

}
