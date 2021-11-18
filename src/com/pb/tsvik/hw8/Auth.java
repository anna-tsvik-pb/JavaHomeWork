package com.pb.tsvik.hw8;

public class Auth {
    private static String login;
    private static String password;



    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public static void signUp(String log, String pass, String confirmPassword) throws WrongLoginException, WrongPasswordException {

        if (log.matches("[A-Za-z0-9]+") && log.length() <= 20 && log.length() >= 5) {
            login = log;
           // System.out.println("Регистрация логина прошла успешно");
        } else if (log.length() >= 20 || log.length() <= 5) {
            String wrLog1 = "Логин некорректной длины";
            throw new WrongLoginException(wrLog1);
        } else {
            String wrLog1 = "В логине указаны недопустимые символы";
            throw new WrongLoginException(wrLog1);
        }

        if (pass.matches("[A-Za-z0-9_]+") && pass.length() > 5 && pass.equals(confirmPassword)) {
            password = pass;
           // System.out.println("Пароль успешно записан");
        } else {
            String wrPass = "Пароль не соответствует требованиям";
            throw new WrongPasswordException(wrPass);
        }

    }

    public static void signIn(String log, String pass) throws WrongLoginException {
        if (log.equals(login) && pass.equals(password)) {
            System.out.println("Вход выполнен успешно!");
        } else {
            String wrLogPass = "Логин или пароль не совпадает";
            throw new WrongLoginException(wrLogPass);
        }


    }
}