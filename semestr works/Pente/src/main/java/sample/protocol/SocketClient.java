package sample.protocol;

import javafx.application.Application;
import sample.controllers.GameController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
    // поле, содержащее сокет-клиента
    private Socket client;
    private PrintWriter output;
    private BufferedReader input;
    /*private Dispatcher dispatcher;*/
    private GameController game;

    public void setGame(GameController   game) {
        this.game = game;
    }

    // начало сессии - получаем ip-сервера и его порт
    public void startConnection(String ip, int port) {
        try {
            // создаем подключение
            client = new Socket(ip, port);
            // получили выходной поток
            output = new PrintWriter(client.getOutputStream(), true);
            // входной поток
            input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            // запустили слушателя сообщений
            String response = input.readLine();
            if (response != null) {
                System.out.println(response);
                game.makeAction(response);
            }
            new Thread(receiverMessagesTask).start();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public void sendMessage(String message) {
        output.println(message);
    }

    private Runnable receiverMessagesTask = new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    String response = input.readLine();
                    if (response != null) {
                        System.out.println(response);
                        game.makeAction(response);
                    }
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
            }
        }
    };

    public void stopConnection() {
        try {
            input.close();
            output.close();
            client.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}