package com.pb.tsvik.hw5;

import java.util.Scanner;

public class Library {

    public static void main(String[] args) {
      Book book1 = new Book("Приключения", "Иванов И.И.", 2000);
      Book book2 = new Book("Словарь", "Сидоров А.В.", 1980);
      Book book3 = new Book("Энциклопедия", "Гусев К.В.", 2010);

      Reader reader1 = new Reader("Петров В.В.", 15 , "Экономика", "10.05.1987", "0665247892");
      Reader reader2 = new Reader("Далас К.И.", 23 , "Техническая кибернетика", "25.11.1991", "0675214634");
      Reader reader3 = new Reader("Ветров Д.Р.", 34 , "Юридический", "05.07.1989", "0502224584");


      System.out.println("Список книг:");
      System.out.println(book1.getInfo());
      System.out.println(book2.getInfo());
      System.out.println(book3.getInfo());

      System.out.println("\nСписок читателей:");
      System.out.println(reader1.getInfo());
      System.out.println(reader2.getInfo());
      System.out.println(reader3.getInfo());

      System.out.println("\nВариант методов №1:");
      reader1.takeBook(Book.getBookCount());
      reader2.returnBook(Book.getBookCount());

      System.out.println("\nВариант методов №2:");
      reader3.takeBook(book1.getName(), book2.getName(), book3.getName());
      reader1.returnBook(book1.getName(), book2.getName(), book3.getName());

      System.out.println("\nВариант методов №3:");
      reader3.takeBook(book1, book2, book3);
      reader1.returnBook(book1, book2, book3);


    }
}
