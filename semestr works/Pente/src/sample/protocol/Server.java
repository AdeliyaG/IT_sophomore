package sample.protocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private int clientsCount = 0;

    // список клиентов
    private List<ClientHandler> clients;
    Integer id = 0;

    public Server() {
        clients = new CopyOnWriteArrayList<>();
    }

    public void start(int port) {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        while (true) {
            try {
                ClientHandler clientHandler = new ClientHandler(serverSocket.accept());
                clientHandler.start();
                if (clientsCount >= 2) {
                    for (ClientHandler client : clients) {
                        client.writer.println("start");
                    }
                }
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public int getClientsCount() {
        return clientsCount;
    }

    private class ClientHandler extends Thread {
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter writer;

        public PrintWriter getWriter() {
            return writer;
        }

        public void setWriter(PrintWriter writer) {
            this.writer = writer;
        }

        ClientHandler(Socket socket) {
            this.clientSocket = socket;
            try {
                this.writer = new PrintWriter(clientSocket.getOutputStream(), true);
                this.in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                writer.println(id++);
            } catch (IOException e) {
                System.out.println();
                throw new IllegalArgumentException(e);
            }
            clients.add(this);
            clientsCount++;
            System.out.println("New client");
        }

        @Override
        public void run() {
            try {
                // получем входной поток для конкретного клиента

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    for (ClientHandler client : clients) {
                        if (client.clientSocket.isClosed()) {
                            clients.remove(client);
                            continue;
                        }
                        System.out.println(inputLine);
                        client.writer.println(inputLine);

                    }
                }
                in.close();
                clientSocket.close();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }

        public Socket getClientSocket() {
            return clientSocket;
        }
    }
}
