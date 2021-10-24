package com.pb.tsvik.hw3;

import java.util.Random;
import java.util.Scanner;

public class Bingo {
        public static void main(String[] args) {
        System.out.println("Угадайте задуманное число в диапазоне от 0 до 100!");
        System.out.println("Для завершения программы введите - exit.");

        int attempt = 0;

        Random random = new Random();

        int x = random.nextInt(101);
        System.out.println(x);

        int number;

        Scanner scan = new Scanner(System.in);

        do {
            attempt++;
            System.out.println("Ваше число: ");
            String ex = scan.next();

            if (ex.equals("exit")) {
                break;

            }

            number = Integer.parseInt(ex);

            if (x < number) {
              System.out.println("Вы не угадали число! Ваше число больше загаданного. ");
                continue;
            }

            if (x > number) {
                System.out.println("Вы не угадали число! Ваше число меньше загаданного. ");
                continue;
            }

            System.out.println("Поздравляем, Вы угадали с " + attempt + " попытки!");
        } while (x != number);
         System.out.println("Конец игры!");
    }
}
