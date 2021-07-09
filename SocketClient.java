import java.net.*;
import java.io.*;

public class SocketClient extends Thread {

    private final Socket cs;
    private InputStream is;
    private OutputStream os;
    private BufferedReader reader;

    public SocketClient(Socket cs) {
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
        String line;
        while ((line = reader.readLine()) != null) {
            if ("quit".equalsIgnoreCase(line)) { break; }
            String ms = "You typed \"" + line + "\"\n\n";
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
