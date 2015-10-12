package ClientServer.chatServer;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunServer
{
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);

        final List<Client> clients = new ArrayList<>();
        ExecutorService pool = Executors.newCachedThreadPool();

        while (!serverSocket.isClosed())
        {
            Socket socket = serverSocket.accept();
            Client newClient = new Client(socket, clients);
            clients.add(newClient);
            pool.submit(newClient);
        }

        pool.shutdown();
    }
}
