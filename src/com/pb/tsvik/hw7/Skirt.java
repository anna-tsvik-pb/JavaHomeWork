package com.pb.tsvik.hw7;

public class Skirt extends Clothes implements WomanClothes{

    public Skirt(){
        super("Юбка",Size.XS,800,"салатового");
    }

    @Override
    public void dressWoman(){//String name, Size size, int price, String color) {
        System.out.println(getName() + " размера " + getSize() + ", по цене: " + getPrice() + " грн, " + getColor() + " цвета.");
    }


}
