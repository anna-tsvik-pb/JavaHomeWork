package com.pb.tsvik.hw7;

public class Tshirt extends Clothes implements ManClothes, WomanClothes{

    public Tshirt(){
        super("Рубашка",Size.S,421,"зеленого");
    }



    @Override
    public void dressWoman(){//String name, Size size, int price, String color) {
        System.out.println(getName() + " размера " + getSize() + ", по цене: " + getPrice() + " грн, " + getColor() + " цвета.");
    }

    @Override
    public void dressMan(){//String name, Size size, int price, String color) {
        System.out.println(getName() + " размера " + getSize() + ", по цене: " + getPrice() + " грн, " + getColor() + " цвета.");
    }


}
