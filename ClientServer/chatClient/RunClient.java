package ClientServer.chatClient;

import java.io.IOException;
import java.util.Scanner;

public class RunClient
{
    public static void main(String[] args)
    {
        try
        {
            Client client = new Client("192.168.1.3", 9000);

            client.connect();
            String userName = "Красотка";

            while (client.isConnected())
            {
                Scanner scanner = new Scanner(System.in);
                String message = scanner.nextLine();
                client.Send(userName + ": " + message);
            }
        }
        catch (IOException e)
        {
            System.out.println("Не удалось подключиться" + e.getMessage());
        }
    }
}
