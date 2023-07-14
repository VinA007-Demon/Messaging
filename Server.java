import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
    
    private int port;
    public Server(int port){
        this.port = port;
    }
    
    public void start() throws IOException{
        try (ServerSocket ServerSocket = new ServerSocket(port)) {
            System.out.println("Server started on the port" + port);

            while (true) {
                Socket clienSocket = ServerSocket.accept();
                System.out.println("Client connected from" + clienSocket.getRemoteSocketAddress());
                //add seperate thread for each connection
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
