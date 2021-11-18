package com.pb.tsvik.hw8;

import java.util.Scanner;

public class OnlineShop {

    public static void main(String[] args) throws WrongLoginException, WrongPasswordException {

        System.out.println("НАЧИНАЕМ РЕГИСТРАЦИЮ!");

        System.out.print("Придумайте логин: ");
        Scanner scan1 = new Scanner(System.in);
        String newlog = scan1.nextLine();

        System.out.print("Придумайте пароль: ");
        Scanner scan2 = new Scanner(System.in);
        String newpass = scan2.nextLine();

        System.out.print("Повторите пароль: ");
        Scanner scan3 = new Scanner(System.in);
        String cpass = scan3.nextLine();

        try{
            Auth.signUp(newlog,newpass,cpass);
            System.out.println("Регистрация прошла успешно!");

            System.out.println("\nДля дальнейшей работы просьба авторизоваться: ");
            System.out.print("Ваш логин: ");
            Scanner scan4 = new Scanner(System.in);
            String log = scan4.nextLine();

            System.out.print("Ваш пароль: ");
            Scanner scan5 = new Scanner(System.in);
            String pass = scan5.nextLine();

            try{
                Auth.signIn(log,pass);
            } catch(WrongLoginException e) {
                System.out.println(e.getWrLogin());
                e.printStackTrace();
            }


        } catch(WrongLoginException e) {
            System.out.println(e.getWrLogin());
            e.printStackTrace();
        } catch(WrongPasswordException e){
                System.out.println(e.getWrPassword());
                e.printStackTrace();
        }

    }

}
