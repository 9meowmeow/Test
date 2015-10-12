package ClientServer.chatClient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Client implements Runnable
{
    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    private InetAddress address;
    private  int post;

    private boolean isConnected = false;

    public Client(String host, int port) throws IOException
    {
        this.address = Inet4Address.getByName(host);
        this.post = port;
        socket = new Socket();
    }

    public void connect() throws IOException
    {
        try
        {
            SocketAddress socketAddress = new InetSocketAddress(address, post);
            socket.connect(socketAddress);
            writer = new PrintWriter(socket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            isConnected = true;
            new Thread(this).start();
        }
        catch (IOException e)
        {
            isConnected = false;
            throw e;
        }
    }

    public void Send (String message)
    {
        writer.println(message);
    }


    @Override
    public void run()
    {
        //TODO нужно убрать привязку
        while (socket.isConnected())
        {
            try {
                String message = reader.readLine();
                System.out.println(message);
            } catch (IOException e) {
                isConnected = false;
                e.printStackTrace();
            }
        }
    }

    public boolean isConnected()
    {
        return isConnected;
    }
}