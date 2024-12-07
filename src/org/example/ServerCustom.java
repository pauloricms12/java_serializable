package org.example;

import java.io.IOException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCustom {

    public static void main(String[] args) {
        int port = 6790;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server listening on port: " + port);
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     ObjectInputStream input = new ObjectInputStream(clientSocket.getInputStream())) {

                    System.out.println("New connection: IP" + clientSocket.getInetAddress());
                    while (true){
                        try  {
                            //For purchase
                            String product = input.readUTF();
                            int quantity = input.readInt();
                            System.out.print("Received objects: ");
                            System.out.println("org.example.Purchase - Product: " + product + " x " + quantity + "\n");

                            //For contact
//                            String name = input.readUTF();
//                            String PhoneNumber = input.readUTF();
//                            int Length = input.readInt();
//                            byte[] photo = new byte[Length];
//                            input.readFully(photo);
//
//                            System.out.println("org.example.Contact - Name: " + name + ", Phone Number: " + PhoneNumber);
//                            System.out.println("Photo size: " + photo.length + " bytes");
                        }

                        catch (Exception e) {
                            System.err.println("Error processing object: " + e.getMessage());
                            break;
                        }
                    }
                }
                catch(IOException e){
                    System.err.println("Error: " + e.getMessage());
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


