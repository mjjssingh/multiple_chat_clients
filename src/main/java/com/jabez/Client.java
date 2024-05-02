package com.jabez;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {

        System.out.println("--------------\nClient started");
        Socket socket = new Socket("localhost", 1234);
        System.out.println("----------------------\nConnection established");

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String username = reader.readLine();


    }
}
