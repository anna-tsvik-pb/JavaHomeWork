package com.pb.tsvik.hw3;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        int[] array = new int[10];

        System.out.println("Введите элементы массива размерностью 10 элементов:");

        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < array.length; i++) {
            System.out.println("Элемент массива № " + (i+1)+": ");
            array[i] = scan.nextInt();
        }

        //Вывести на экран введенный массив.
        System.out.println("Введенный цикл:");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }

        // Подсчитать сумму всех элементов массива и вывести ее на экран.
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        System.out.println();
        System.out.println("Сумма элементов массива = " + sum);

        // Подсчитать и вывести на экран количество положительных элементов.
        int n = 0;

        for (int i = 0; i < array.length; i++) {
            if(array[i]>0)
                n++;
        }
        System.out.println("Количество положительных элементов в массиве = " + n);

        //Произвести сортировку этого массива от меньшего к большему по алгоритму сортировки пузырьком.
        boolean sort = false;
        while (!sort) {
            sort = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i-1]) {
                    int temp = array[i];
                    array[i] = array[i-1];
                    array[i-1] = temp;
                    sort = false;
                }
            }
        }

        //Вывести на экран отсортированный массив
        System.out.println("Отсортированный цикл:");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }

      //  System.out.println("Для завершения программы введите - exit.");


    }
}
