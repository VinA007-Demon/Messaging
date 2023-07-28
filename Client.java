import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static final String SERVER_HOST = "localhost";

    public static void main(String[] args){
        if(args.length < 1){
            System.out.println("Usage: java Client <port number>");
            return;
        }

        int portNumber = Integer.parseInt(args[0]);

        try (
            // Establish a connection to the server
            Socket socket = new Socket(SERVER_HOST, portNumber);
            // Set up output stream to send messages to the server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            // Set up input stream to receive messages from the server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            System.out.println("Connected to the Server");

            // Send a message to the server
            out.println("Hello Server!");

            // Receive and print a message from the server
            String response = in.readLine();
            System.out.println("Server response: " + response);

        } catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Connection closed.");
    }   
}
