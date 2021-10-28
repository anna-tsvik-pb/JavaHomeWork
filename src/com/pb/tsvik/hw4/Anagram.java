package com.pb.tsvik.hw4;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

    static String anagram(String String1, String String2){

       String str = "";

       String sortedString1 = sorted1(String1);
       String sortedString2 = sorted2(String2);

        if(sortedString1.equals(sortedString2)){
            str = "Предложения являются анаграммами";
        } else{
            str = "Предложения не являются анаграммами";
        }

        return str;
    }

    static String sorted1(String sent1) {

        sent1 = sent1.toUpperCase();
        String sentence1 = sent1.replaceAll("[^A-ZА-Я0-9]", "");
        char[] chArray1 = sentence1.toCharArray();
        Arrays.sort(chArray1);
        String sortString1 = new String(chArray1);

        return sortString1;
    }

    static String sorted2(String sent2) {

        sent2 = sent2.toUpperCase();
        String sentence2 = sent2.replaceAll("[^A-ZА-Я0-9]", "");
        char[] chArray2 = sentence2.toCharArray();
        Arrays.sort(chArray2);
        String sortString2 = new String(chArray2);

        return sortString2;
    }

    public static void main(String[] args) {
        System.out.println("Придумайте и введите предложения №1:");
        Scanner scan = new Scanner(System.in);
        String s1 = scan.nextLine();

        System.out.println("Придумайте и введите предложения №2:");
        Scanner scan2 = new Scanner(System.in);
        String s2 = scan2.nextLine();

        String result = anagram(s1, s2);

        System.out.println(result);

    }


}
