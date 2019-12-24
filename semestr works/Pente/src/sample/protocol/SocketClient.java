package sample.protocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
    // поле, содержащее сокет-клиента
    private Socket clientSocket;
    private PrintWriter out;
    public BufferedReader in;
    private Integer id;


    public Integer getId() {
        return id;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SocketClient client = new SocketClient();
        client.startConnection("192.168.8.102", 4321);
        while (true) {
            String message = scanner.nextLine();
            client.sendMessage(message);
        }
    }
    // начало сессии - получаем ip-сервера и его порт
    public void startConnection(String ip, int port) {
        try {
            // создаем подключение
            clientSocket = new Socket(ip, port);
            // получили выходной поток
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            // входной поток
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // запустили слушателя сообщений
            id = Integer.parseInt(in.readLine());
            System.out.println(id);
//            new Thread(receiverMessagesTask).start();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    public void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

}