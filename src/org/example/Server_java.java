package org.example;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_java {

    public static void main(String[] args) {
        int port = 6790;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server listening on port: " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New connection: IP" + clientSocket.getInetAddress());

                try (ObjectInputStream input = new ObjectInputStream(clientSocket.getInputStream())) {
                    Object obj = input.readObject();
                    System.out.println("Received: " + obj.toString());
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


