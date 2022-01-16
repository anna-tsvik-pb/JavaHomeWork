package com.pb.tsvik.hw15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echo_client extends JFrame {
    private Socket server;
    String serverIp = "127.0.0.1";
    int serverPort = 1000;
    BufferedReader readerServer;
    PrintWriter writerServer;

    public Echo_client() throws IOException {
          ClientWindow();
      }

    public void ClientWindow() throws IOException {

        JFrame myWindow = new JFrame();

        myWindow.setSize(500, 300);

        JButton jButtonServer = new JButton("Подключиться к серверу");
        JButton jButtonMessage = new JButton("Отправить");
        JTextField jTextField = new JTextField("Введите сообщение: ");
        JTextArea jTextArea = new JTextArea();

        jButtonServer.addActionListener(ae -> {
            try{server = new Socket(serverIp, serverPort);
                readerServer = new BufferedReader(new InputStreamReader(server.getInputStream()));
                writerServer = new PrintWriter(server.getOutputStream(), true);
                JOptionPane.showMessageDialog(null, "Подключение к серверу "  + serverIp + serverPort +" прошло успешно", "Подключение к серверу",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e){
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Подключение к серверу прошло не успешно " + e.getMessage(), "Подключение к серверу",
                        JOptionPane.WARNING_MESSAGE);
            }
        });


        jButtonMessage.addActionListener(e -> {
            if (server == null) {
                JOptionPane.showMessageDialog(null, "Подключитесь к серверу", "Ошибка",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                if (!jTextField.getText().isEmpty()) {
                    try {
                        writerServer.println(jTextField.getText());
                        String s = readerServer.readLine();
                        jTextArea.append(s + "\n");
                        jTextField.setText("");
                        jTextField.grabFocus();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Поле не должно быть пустым", "Ошибка",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        jTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                jTextField.setText("");
            }
        });

        Container pane = myWindow.getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                        .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jButtonServer)
                                .addComponent(jTextArea)
                                .addComponent(jTextField))
                        .addComponent(jButtonMessage)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                        .addComponent(jButtonServer)
                .addComponent(jTextArea)
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonMessage)

                )
        );


        myWindow.setTitle("Echo-server");
        myWindow.setLocationRelativeTo(null);
        myWindow.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        myWindow.setVisible(true);

        myWindow.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                super.windowClosing(event);
                Object[] options = { "Да", "Нет!" };
                int n = JOptionPane
                        .showOptionDialog(event.getWindow(), "Закрыть окно?",
                                "Подтверждение", JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE, null, options,
                                options[0]);
                if (n == 0) {
                    try {
                        writerServer.print("exit");
                        writerServer.flush();
                        writerServer.close();
                        readerServer.close();
                        server.close();
                    }catch (Exception exc){
                        exc.getMessage();
                    }
                    JOptionPane.showMessageDialog(null, "Вы отключились от сервера! Хорошего дня!", "Отключение от сервера",
                            JOptionPane.INFORMATION_MESSAGE);
                    event.getWindow().setVisible(false);
                    System.exit(0);
                }
            }
        });

    }

       public static void main(String[] args) throws Exception {
           EventQueue.invokeLater(() -> {

               try {
                   Echo_client w = new Echo_client();
               } catch (IOException e) {
                   e.printStackTrace();
               }
               });
    }
}
