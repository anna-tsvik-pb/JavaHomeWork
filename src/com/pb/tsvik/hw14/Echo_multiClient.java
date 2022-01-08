package com.pb.tsvik.hw14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;

public class Echo_multiClient implements Runnable {
    private final Socket clientSocket;

    public Echo_multiClient(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
//        try {
 //           clientSocket = server.accept();
            String nameClient = Thread.currentThread().getName();
            String[] clientPart = nameClient.split("-");

            System.out.println("Клиент " + clientPart[3] + " подключился, можно начинать работу.");

//        } catch (IOException e) {
//            System.out.println("Не могу установить соединение");
//            System.exit(-1);
//        }

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            String clientMessage;

            System.out.println("Ожидаем сообщений от клиентов...");
            while ((clientMessage = reader.readLine()) != null) {
                if ("exit".equalsIgnoreCase(clientMessage)) {
                    System.out.println("Окончание работы клиент-сервера!");
                    writer.println("Окончание работы клиент-сервера!");
                    break;
                }
                writer.println("Сообщение от клиента " + clientPart[3] + ": /" + LocalDateTime.now() + "/ " + clientMessage);

                System.out.println("Сообщение от клиента " + clientPart[3] + ": /" + LocalDateTime.now() + "/ " + clientMessage);
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
