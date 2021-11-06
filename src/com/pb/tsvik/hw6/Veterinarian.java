package com.pb.tsvik.hw6;


public class Veterinarian {


    public static void treatAnimal(Animal anim) {
        System.out.println("На приеме: " + anim.kind + " " + ", который(ая) ест " + anim.food + "(у), и спит в " + anim.location + "(е).");
        System.out.println("----------------------");

    }
}

