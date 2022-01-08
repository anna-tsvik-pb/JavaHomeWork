package com.pb.tsvik.hw14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echo_client {
    public static void main(String[] args) throws Exception {
        String serverIp = "127.0.0.1";
        int serverPort = 1000;
        System.out.println("Клиент готов к работе!");

        System.out.println("Подключаемся к серверу - " + serverIp + ":" + serverPort);

        Socket server = new Socket(serverIp, serverPort);

        BufferedReader readerServer = new BufferedReader(new InputStreamReader(server.getInputStream()));
        PrintWriter writerServer = new PrintWriter(server.getOutputStream(), true);
        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));

        String dataFromUser, dataFromServer;

        System.out.println("Введите комментарий: ");

        while ((dataFromUser = readerConsole.readLine()) != null) {
            writerServer.println(dataFromUser);
            dataFromServer = readerServer.readLine();
            System.out.println(dataFromServer);
            if ("exit".equalsIgnoreCase(dataFromUser)) {
                break;
            } else
            System.out.println("Введите новый комментарий: ");
        }
        writerServer.close();
        readerServer.close();
        readerConsole.close();
        server.close();
    }
}
