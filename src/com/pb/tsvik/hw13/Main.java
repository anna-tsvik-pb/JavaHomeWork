package com.pb.tsvik.hw13;

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        LinkedList<Integer> buffer = new LinkedList<>();
        Lock readLock = readWriteLock.readLock();
        Lock writeLock = readWriteLock.writeLock();

        Producer producer = new Producer(buffer,writeLock,"\u001B[32m");
        Consumer consumer = new Consumer(buffer,readLock,"\u001B[35m");
         for(;;){
        Thread produce = new Thread(producer);
        Thread consume = new Thread(consumer);

            produce.start();
            consume.start();
        }
    }
}
