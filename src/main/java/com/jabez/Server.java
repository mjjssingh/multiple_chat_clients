package com.jabez;


import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class Server {
    private static ClientListener clientListener;
    public static void main(String[] args) throws Exception{
        System.out.println("--------------\nServer started");
        ServerSocket serverSocket = new ServerSocket(1234);

        System.out.println("Type :q to quit\nType :l to list connected sockets");


        listenForClientConnection(serverSocket);




        Scanner scanner = new Scanner(System.in);

        while (true) {
            String option = scanner.next();
            if (option.equals(":q")) {
                clientListener.interrupt();
                serverSocket.close();
                break;
            }
            if (option.equals(":l")) {
                System.out.println(clientListener.getSockets());
            }
        }

        System.exit(0);
    }

    private static void listenForClientConnection(ServerSocket serverSocket) throws IOException {
        clientListener = new ClientListener(serverSocket);
        clientListener.start();
    }
}
