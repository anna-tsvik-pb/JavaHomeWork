package com.pb.tsvik.hw7;

public class Tie extends Clothes implements ManClothes{

    public Tie(){
        super("Галстук",Size.L,700,"черного");
    }

    @Override
    public void dressMan(){//String name, Size size, int price, String color) {
        System.out.println(getName() + " размера " + getSize() + ", по цене: " + getPrice() + " грн, " + getColor() + " цвета.");
    }
}
