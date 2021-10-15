package com.pb.tsvik.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите целое число: ");
        int operand = scan.nextInt();

        if (operand >= 51) {
            if (operand <= 100) {
            System.out.print("Число находится в интервале: [51 - 100]");
        } else {
                System.out.print("Число находится за рамаками интервалов");
            }
        } else if (operand >= 36) {
            System.out.print("Число находится в интервале: [36 - 50]");
        } else if (operand >= 15) {
            System.out.print("Число находится в интервале: [15 - 35]");
        } else if (operand >= 0) {
            System.out.print("Число находится в интервале: [0 - 14]");
        } else {
            System.out.print("Число находится за рамаками интервалов");
        }



    }
}
