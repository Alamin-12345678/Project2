import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        JFrame frame =new JFrame();
        Gameplay gamePlay= new Gameplay();

        frame.setBounds(10,10,700,600);
        frame.setTitle("Breakout Ball");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gamePlay);
        frame.setVisible(true);

        BufferedReader reader;
        BufferedWriter writer;
        try {
            Socket socket = new Socket("12.0.0.1", 5000);

            OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
            writer =new BufferedWriter(out);
            InputStreamReader isr =new InputStreamReader(socket.getInputStream());
            reader =new BufferedReader(isr);
           Thread thread =new Thread(new Runnable(){


               @Override
               public void run() {

               try{
                   Thread.sleep(10000);
                   writer.write(String.valueOf(Gameplay.score));
                   writer.newLine();
                   writer.flush();
                   int HighScore =reader.read();


               }
               catch (Exception e){

                   e.printStackTrace();
               }
               }
           });
           thread.start();
        }
        catch (Exception e)
        {

        }
    }
}
