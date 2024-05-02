package com.jabez;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ClientListener extends Thread{
    private Map<String, Socket> sockets;
    private ServerSocket serverSocket;

    public ClientListener(ServerSocket serverSocket) {
        this.sockets = new HashMap<>();
        this.serverSocket = serverSocket;
    }

    public Map<String, Socket> getSockets() {
        return sockets;
    }

    @Override
    public void run() {
        while(true){
            Socket socket;
            BufferedReader bufferedReader;
            BufferedWriter bufferedWriter;
            try{
                socket  = serverSocket.accept();
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            }catch(Exception e){
                e.printStackTrace();
                break;
            }
            System.out.println("----------------------\nConnection established\n----------------------");
            System.out.println("~~~ With " + socket.getInetAddress());

            String username = "user" + sockets.size();

            try {
                bufferedWriter.write(username);
            }catch (IOException e) {

            }

            sockets.put(username, socket);


        }
    }

}
