package com.pb.tsvik.hw6;

import java.util.Objects;

public class Cat extends Animal {

    String colour;
    String size;


    public Cat(String kind, String food, String location, String colour, String size) {
        this.food = food;
        this.kind = kind;
        this.location = location;
        this.colour = colour;
        this.size = size;

    }
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public void makeNoise() {
        System.out.println(colour + " " + kind + " громко мяукает!");
    }

    @Override
    public void eat() {
        System.out.println(size + " " + kind + " есть много " + food + ".");
    }

    @Override
    public void sleep() {
        System.out.println(colour + " " + kind + " спит практически целый день на " + location);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(colour, cat.colour) && Objects.equals(size, cat.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colour, size);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "colour='" + colour + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
