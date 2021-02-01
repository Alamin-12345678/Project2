import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;

public class Server {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            Socket socket = serverSocket.accept();

            OutputStreamWriter o = new OutputStreamWriter(socket.getOutputStream());
            BufferedWriter writer = new BufferedWriter(o);

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(isr);

            ArrayList<Integer> sc = new ArrayList<Integer>();
            String data;
            try {
                data = reader.readLine();

                FileWriter file = new FileWriter("A.txt", true);
                BufferedWriter writer1 = new BufferedWriter(file);


                writer1.append(data);
                writer1.newLine();

                writer1.close();
                FileReader f = new FileReader("A.txt");
                BufferedReader reader1 = new BufferedReader(f);

                String line;
                while ((line = reader1.readLine()) != null) {
                    String[] parts = line.split(" ");
                    int score = Integer.parseInt(parts[0]);
                    sc.add(score);

                }
                writer.write(Collections.max(sc));
                writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
            writer.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
