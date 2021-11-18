package com.pb.tsvik.hw8;

public class WrongPasswordException extends Exception {

    private String wrPassword;

    public WrongPasswordException(String wrPassword) {
        this.wrPassword = wrPassword;

    }

    public String getWrPassword() {
        return wrPassword;
    }
}