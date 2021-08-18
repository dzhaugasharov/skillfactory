package module13;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Queue;
import java.util.Scanner;

public class Client implements Runnable {

    private String userName;
    private Socket socket;
    private Queue<String> messagesPool;

    public Client(Socket socket, String userName, Queue<String> messagesPool) {
        this.userName = userName;
        this.socket = socket;
        this.messagesPool = messagesPool;
    }

    public boolean isConnected() {
        return socket.isConnected();
    }

    @Override
    public void run() {
        this.sendMessage(String.format("Hello, %s! Welcome to the chat!", userName));
        while (true) {
            try {
                String s = this.receiveMessage();
                System.out.println("Message received from user: " + s);
                messagesPool.add(userName + ": " + s);
                // sendMessage(s);
            }
            catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    public String receiveMessage() throws IOException {
        // получаем потоки ввода и вывода
        InputStream is = socket.getInputStream();

        // создаем удобные средства ввода и вывода
        Scanner in = new Scanner(is);

        // читаем из сети и пишем в сеть
        return in.nextLine();
    }

    public void sendMessage(String message) {
        try {
            System.out.println("Sending message: " + message);
            OutputStream os = socket.getOutputStream();
            PrintStream out = new PrintStream(os);
            out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
