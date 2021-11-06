package com.pb.tsvik.hw6;

public class Animal {
    public String kind;
    public String food;
    public String location;


    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void sleep() {
        System.out.println(kind + " спит в " + location);
    }

    public void makeNoise() {
        System.out.println(kind + " шумит!");
    }

    public void eat() {
        System.out.println(kind + " ест " + food);
    }
}
