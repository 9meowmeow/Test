package ClientServer.chatServer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class Client implements Runnable
{
    private Socket socket;
    private List<Client> clients;
    private PrintWriter writer;
    private BufferedReader reader;
    private boolean isConnected = false;

    public Client (Socket socket, List<Client> clients) throws IOException {
        this.socket = socket;
        this.clients = clients;

        writer = new PrintWriter(socket.getOutputStream(), true);
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        isConnected = true;
    }

    public void send (String message)
    {
        writer.println(message);
    }

    public boolean isConnected()
    {
        return isConnected;
    }

    @Override
    public void run()
    {
        while (isConnected())
        {
            try {
                String message = reader.readLine();
                for(Client c : clients)
                {
                    if(c!=this && c.isConnected())
                    {
                        c.send(message);
                    }
                }
            } catch (IOException e) {
                isConnected = false;
                e.printStackTrace();
            }
        }
    }
}
