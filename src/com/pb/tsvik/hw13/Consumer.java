package com.pb.tsvik.hw13;

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;

public class Consumer implements Runnable {
    private final LinkedList<Integer> buffer;
    private final Lock readLock;
    private final String color;

    public Consumer(LinkedList<Integer> buffer, Lock readLock, String color) {
        this.buffer = buffer;
        this.readLock = readLock;
        this.color = color;
    }

    @Override
    public synchronized void run() {
        readLock.lock();
        try {
            if (buffer.isEmpty()) {
                try {
                    System.out.println(color + "Буфер пуст! Ждем добавления элемента...");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Ошибка: " + e);
                }
            } else {
                System.out.println(color + "Элемент: " + buffer.removeFirst() + " - удален");
                System.out.println(color + "В буфере элементов - " + buffer.size());
            }
        } finally {
            readLock.unlock();
        }
    }
}
