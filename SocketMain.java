import java.net.*;
import java.io.*;

public class SocketMain {

    public static final int DEFAULT_PORT = 6604;
    private ServerSocket ss;
    private Socket cs;
    private SocketClient client;

    public SocketMain() {
        try {
            ss = new ServerSocket(DEFAULT_PORT);
            while (true) {
                System.out.println("Available to connect...");
                cs = ss.accept();
                System.out.println("Connection secured with " + cs);
                client = new SocketClient(cs);
                client.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SocketMain();
    }
}
