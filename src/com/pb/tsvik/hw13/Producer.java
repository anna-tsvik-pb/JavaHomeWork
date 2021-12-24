package com.pb.tsvik.hw13;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Lock;

public class Producer implements Runnable{
      private final LinkedList<Integer> buffer;
      private final Lock writeLock;
      private final String color;

    public Producer(LinkedList<Integer> buffer, Lock writeLock, String color) {
        this.buffer = buffer;
        this.writeLock = writeLock;
        this.color = color;
    }

    @Override
    public synchronized void run() {
        writeLock.lock();
        try {
            if (buffer.size() >= 5) {
                try {
                    System.out.println(color + "Буфер заполнен! Ждем удаления элемента...");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Ошибка: " + e);
                }
            } else {
                Random random = new Random();
                buffer.add(random.nextInt(100));

                System.out.println(color + "Добавлен элемент: " + buffer.getLast());
                System.out.println(color + "В буфере элементов - " + buffer.size());
            }
        } finally {
                writeLock.unlock();
            }
        }
}
