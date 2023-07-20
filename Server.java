import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
    
    private int port;
    public Server(int port){
        this.port = port;
    }
    
    public void start() throws IOException{
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on the port" + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from" + clientSocket.getRemoteSocketAddress());
                //Create a new thread for each client connection
                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();

            }
        }
    }
    public static void main(String[] args) throws IOException{
        int port = Integer.parseInt(args[0]);
        //Taking the port number as a string and converting to integer.
        new Server(port).start();
        //starting the server for this port.
    }
}
