package com.pb.tsvik.hw9;

//В нем создать методы:

    //    - createNumbersFile - создает текстовый файл "numbers.txt" заполненный случайными целыми числами от 1 до 99. 10 строк и по 10 чисел в каждой строке. Числа разделять пробелами.
  //      - createOddNumbersFile - читает файл "numbers.txt", и создает на основе него новый файл "odd-numbers.txt" в который входят все числа из "numbers.txt" только все четные заменены на 0.
  //      В методе main продемонстрировать работу методов createNumbersFile и createOddNumbersFile.
//      По желанию можно добавить логирование работы программы.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class FileNumbers {

    public static void createNumberFile(){

        Path path = Paths.get("src\\com\\pb\\tsvik\\hw9\\files\\numbers.txt");

        try(BufferedWriter writer = Files.newBufferedWriter(path)){

            Random random = new Random();

            for(int j=0; j<10; j++) {
                for (int i = 0; i < 10; i++) {
                    int x = random.nextInt(100);
                    writer.write(x + " ");
                    //writer.write(" ");
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка в записи файла: " + e);
            e.printStackTrace();
        }
        System.out.println("Запись в файл: " + path.toAbsolutePath() + " успешна!");

    }

    public static void createOddNumbersFile() {

        Path path = Paths.get("src\\com\\pb\\tsvik\\hw9\\files\\numbers.txt");
        Path path2 = Paths.get("src\\com\\pb\\tsvik\\hw9\\files\\odd-numbers.txt");

        System.out.println("Чтение из файла: " + path.toAbsolutePath());
         try (BufferedReader reader = Files.newBufferedReader(path)) {

             try(BufferedWriter writer = Files.newBufferedWriter(path2)){
                 String line;
                 while((line = reader.readLine()) != null){
                     String[] ar = line.split(" ");
                    // String[] ar = reader.readLine().split(" ");

                     for(String number : ar){
                     if (Integer.valueOf(number) % 2 == 0) {
                         writer.write(0 + " ");
                     }else writer.write(number + " ");
                     }
                     writer.newLine();
                     }
                 }

    }catch (IOException e) {
                 System.out.println("Ошибка в перезаписи файла: " + e);
                 e.printStackTrace();
        }
        System.out.println("Перезапись файла: " + path2.toAbsolutePath() + "\" успешна!");
    }

    public static void main(String[] args) {
        createNumberFile();
        createOddNumbersFile();
    }

}
