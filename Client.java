import java.io.IOException;
import java.net.Socket;

public class Client {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args){
        try{
            Socket socket = new Socket(SERVER_HOST, SERVER_PORT); //connect to the server
            System.out.println("Connected to the Server");

            //Close the connection when done
            //socket.close();
            //System.out.println("Connection closed.");
        }catch(IOException e){
            e.printStackTrace();

        }
    }   
}
