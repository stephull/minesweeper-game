import java.net.*;
import java.util.*;
import java.io.*;

public class SocketClient extends Thread {

    private final Socket cs;
    private InputStream is;
    private OutputStream os;
    private BufferedReader reader;
    private Scanner sc;

    SocketClient(Socket cs) {
        this.cs = cs;
    }

    @Override
    public void run() {
        try {
            handleSocketClient();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleSocketClient() throws IOException, InterruptedException {
        is = cs.getInputStream();
        os = cs.getOutputStream();

        reader = new BufferedReader(new InputStreamReader(is));
        sc = new Scanner(System.in);

        String line, user;

        String input = "Enter your username: ";
        os.write(input.getBytes());
        user = sc.nextLine();

        while ((line = reader.readLine()) != null) {

            if ("quit".equalsIgnoreCase(line)) { break; }
            String ms = user + " typed \"" + line + "\"\n\n";
            os.write(ms.getBytes());
        }
        /*  for (int i = 0; i < 10; i++) {
                os.write(("TIME: " + new Date() + "\n").getBytes());
                Thread.sleep(1000);
            }
        */
        cs.close();
    }
}
