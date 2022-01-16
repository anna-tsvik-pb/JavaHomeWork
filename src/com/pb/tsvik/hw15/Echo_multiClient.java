package com.pb.tsvik.hw15;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Echo_multiClient implements Runnable {
    private final Socket clientSocket;

    public Echo_multiClient(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            String nameClient = Thread.currentThread().getName();
            String[] clientPart = nameClient.split("-");

            System.out.println("Клиент " + clientPart[3] + " подключился, можно начинать работу.");


            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            String clientMessage;

            System.out.println("Ожидаем сообщений от клиентов...");
            while(true) {
                if ((clientMessage = reader.readLine()) != null) {
                    if ("exit".equalsIgnoreCase(clientMessage)) {
                        System.out.println("Киент №" + clientPart[3] + " вышел из чата!");
                        writer.println("Окончание работы сервера с клиентом №" + clientPart[3] );
                        break;
                    }
                    writer.println("Сообщение от клиента " + clientPart[3] + ": /" + LocalDateTime.now() + "/ " + clientMessage);

                    System.out.println("Сообщение от клиента " + clientPart[3] + ": /" + LocalDateTime.now() + "/ " + clientMessage);
                }
            }
            reader.close();
            writer.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
