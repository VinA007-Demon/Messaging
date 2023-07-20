import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable{
    
    private Socket clientSocket;
    
    public ClientHandler(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    @Override
    public void run(){
        try 
            // Set up input and output streams for the client connection
            (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            //Handle client requests
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                //Process client input (you can add your custom logic here)
                String response = "Server response: " + inputLine;
                out.println(response);
            }
        } catch (IOException e) {
            System.out.println("A client has disconnected: " + clientSocket.getRemoteSocketAddress());
        } finally {
            try {
                if (clientSocket != null){
                    clientSocket.close();
                }
            } catch (IOException e) {
                System.out.println("Error when closing the client socket: " + clientSocket.getRemoteSocketAddress());
                e.printStackTrace();
            }
        }
    }
}