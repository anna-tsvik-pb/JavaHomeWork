package com.pb.tsvik.hw14;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Echo_server {
    public static void main(String[] args) throws Exception {
        int serverPort = 1000;

        System.out.println("Сервер запущен на порту: " + serverPort + " !");

        ServerSocket server = null;
//        Socket clientSocket = null;

        try {
            server = new ServerSocket(serverPort);
        } catch (IOException e) {
            System.out.println("Ошибка связывания с портом 1000");
            System.exit(-1);
        }

        System.out.println("Ждем соединения с клиентом!");

        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        // В цикле ждем запроса клиента
        while (true) {
            Socket clientSocket = server.accept();
            threadPool.submit(new Echo_multiClient(clientSocket));
        }

    }
}
