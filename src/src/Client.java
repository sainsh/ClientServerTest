import javax.xml.crypto.Data;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {



    public static void main(String[] args) {
        Socket socket;
        DataInputStream in;
        DataOutputStream out;
        String simon = "192.168.86.21";
        int simonPort = 8000;


        try {
            socket = new Socket("localhost", 1);

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            System.out.println("forbindelse oprettet");





            Scanner scan = new Scanner(System.in);
            double output;
            double input;

            while(true){

                System.out.println("skriv et tal: ");
                output = scan.nextDouble();
                out.writeDouble(output);
                input = in.readDouble();
                System.out.println(input);

                if(output == 0.0){break;}

            }

            in.close();
            out.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
