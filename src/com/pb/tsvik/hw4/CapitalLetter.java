package com.pb.tsvik.hw4;

import java.util.Scanner;

public class CapitalLetter {

    static String up(String sent){

        char[] chArray = sent.toCharArray();

        for (int i = 1; i < chArray.length-1; i++) {
            if (chArray[i] == ' ') {
                chArray[i + 1] = Character.toUpperCase(chArray[i + 1]);
            }
        }

        chArray[0] = Character.toUpperCase(chArray[0]);

        sent = new String(chArray);
        return sent;
    }

    public static void main(String[] args) {
        System.out.println("Придумайте и введите предложения:");
       Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        String result = up(s);

        System.out.println("Вид преобразованного предложения:");
        System.out.println(result);

    }



}
