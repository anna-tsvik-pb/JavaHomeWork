package com.pb.tsvik.hw7;

public class Pants extends Clothes implements ManClothes, WomanClothes {

    public Pants() {
        super("Штаны",Size.M, 675, "красного");
    }

    @Override
    public void dressWoman() {//String name, Size size, int price, String color) {
        System.out.println(getName() + " размера " + getSize() + ", по цене: " + getPrice() + " грн, " + getColor() + " цвета.");
    }

    @Override
    public void dressMan() {//String name, Size size, int price, String color) {
        System.out.println(getName() + " размера " + getSize() + ", по цене: " + getPrice() + " грн, " + getColor() + " цвета.");
    }



}
