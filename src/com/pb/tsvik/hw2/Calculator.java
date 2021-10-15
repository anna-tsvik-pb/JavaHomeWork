package com.pb.tsvik.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int operand1;
        int operand2;

        Scanner scan = new Scanner(System.in);

        System.out.print("Введите значение 1-го числа: ");
        operand1 = scan.nextInt();

        System.out.print("Введите значение 2-го числа: ");
        operand2 = scan.nextInt();

        System.out.print("Введите знак арифметической операции: ");
        String sign = scan.next();

        System.out.print("Результат: " + operand1 + " " + sign + " " + operand2 + " = ");


        switch (sign) {
            case "+":
                System.out.println(operand1+operand2);
                break;
            case "-":
                System.out.println(operand1-operand2);
                break;
            case "*":
                System.out.println(operand1*operand2);
                break;
            case "/":
                if (operand2 == 0) {
                   System.out.println("ОШИБКА! Нельзя делить на ноль!");
                }
                System.out.println(operand1/operand2);
                break;
            default:
                System.out.println("ОШИБКА!  " + sign + " - Неверный знак!");
        }
    }
}