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

            OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
            BufferedWriter writer = new BufferedWriter(out);

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(isr);

            ArrayList<Integer> in = new ArrayList<Integer>();

            try {
                String data;
                data = reader.readLine();

                FileWriter file = new FileWriter("A.txt", true);
                BufferedWriter bwriter = new BufferedWriter(file);


                bwriter.append(data);
                bwriter.newLine();

                bwriter.close();
                FileReader f = new FileReader("A.txt");
                BufferedReader reader1 = new BufferedReader(f);

                String line;
                while ((line = reader1.readLine()) != null) {
                    String[] parts = line.split(" ");
                    int score = Integer.parseInt(parts[0]);
                    in.add(score);

                }
                bwriter.write(Collections.max(in));
                bwriter.flush();
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
