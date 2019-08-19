import javax.xml.crypto.Data;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        Socket socket;
        DataInputStream in;
        DataOutputStream out;
        ServerSocket server;
        double input;
        double output;

        try {


            server = new ServerSocket(1);
            socket = server.accept();
            System.out.println("server startet");

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());


            while(true){
                input = in.readDouble();
                System.out.println("fra client: " + input);
                out.writeDouble(input*input*Math.PI);

                if(input == 0.0){break;}
            }

            in.close();
            out.close();
            socket.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
