import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        System.out.println("Started server");
        int port = 8886;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true){
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                System.out.println("Соединение установлено, " + "на порте: " + clientSocket.getPort());
                final String name = in.readLine();
                out.println("Привет" + name + "твой порт : " + clientSocket.getPort());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
