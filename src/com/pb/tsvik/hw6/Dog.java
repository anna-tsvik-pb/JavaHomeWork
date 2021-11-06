package com.pb.tsvik.hw6;

import java.util.Objects;

public class Dog extends Animal {

    String name;
    String breed;

    public Dog(String kind, String food, String location, String name, String breed) {
       this.food = food;
       this.kind = kind;
       this.location = location;
       this.name = name;
       this.breed = breed;

   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeNoise() {
        System.out.println(kind + " по кличке "+ name + " гавкает!");
    }

    @Override
    public void eat() {
        System.out.println(kind +  " породы " + breed + " ест " + food + ".");
    }

    @Override
    public void sleep() {
        System.out.println(kind +  " породы " + breed + " спит в " + location + "(е).");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(name, dog.name) && Objects.equals(breed, dog.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, breed);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                '}';
    }
}



