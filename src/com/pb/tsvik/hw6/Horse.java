package com.pb.tsvik.hw6;

import java.util.Objects;

public class Horse extends Animal {

    String color;
    int age;

    public Horse(String kind, String food, String location, String color, int age) {
        this.food = food;
        this.kind = kind;
        this.location = location;
        this.color = color;
        this.age = age;

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void makeNoise() {
        System.out.println(kind + " часто ржет!");
    }

    @Override
    public void eat() {
        System.out.println(age + "-х(ти) летняя " + kind + " ест только свежее(ую) " + food + ".");
    }

    @Override
    public void sleep() {
        System.out.println(kind + " " + color + " расцветки может целый день спать в" + location);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return age == horse.age && Objects.equals(color, horse.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, age);
    }

    @Override
    public String toString() {
        return "Horse{" +
                "color='" + color + '\'' +
                ", age=" + age +
                '}';
    }
}
