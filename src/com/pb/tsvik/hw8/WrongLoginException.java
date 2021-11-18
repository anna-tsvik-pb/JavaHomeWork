package com.pb.tsvik.hw8;

public class WrongLoginException extends Exception {

    private String wrLogin;

    public WrongLoginException(String wrLogin) {
        this.wrLogin = wrLogin;

    }

    public String getWrLogin() {
        return wrLogin;
    }
}
