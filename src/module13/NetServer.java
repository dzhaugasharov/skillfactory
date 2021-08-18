package module13;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class NetServer {
    private List<Client> clients = new ArrayList<>();
    private Queue<String> messagesPool = new ArrayDeque<>();

    public void startServer() throws IOException {
        // создаем серверный сокет на порту 1234
        ServerSocket server = new ServerSocket(1234);
        while(true) {
            System.out.println("Waiting...");

            // ждем клиента
            Socket socket = server.accept();
            Client client = new Client(socket, "User" + (clients.size() + 1), messagesPool);
            clients.add(client);
            new Thread(client).start();
            System.out.println("Client connected! Total: " + clients.size());
        }
    }

    public void broadcastMessages() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (messagesPool.peek() != null) {
                        String msg = messagesPool.poll();
                        for (Client client : clients) {
                            if (!client.isConnected()) {
                                clients.remove(client);
                                continue;
                            }
                            client.sendMessage(msg);
                        }
                    }
                }
            }
        }).start();
    }

    public static void main(String[] args) throws IOException {
        NetServer server = new NetServer();
        server.broadcastMessages();
        server.startServer();
    }
}
