package com.pb.tsvik.hw10;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        NumBox<Float> floatNumBox = new NumBox<>(Float.class, 8);

        floatNumBox.add(5F);
        floatNumBox.add(10F);
        floatNumBox.add(8F);

        System.out.println("[5,10,8]: average = " + floatNumBox.average() + " sum = " + floatNumBox.sum());
    }
}
