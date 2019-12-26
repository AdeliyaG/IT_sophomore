package sample.protocol;

public class ServerMain {
    public static void main(String[] args) {
        Server server = new Server();
        server.start(4321);
    }
}
