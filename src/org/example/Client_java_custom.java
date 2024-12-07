package org.example;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client_java_custom {

    public static void main(String[] args) {

        List<PurchaseCustom> purchase_list = new ArrayList<>();
        purchase_list.add(new PurchaseCustom("Laptop", 1));
        purchase_list.add(new PurchaseCustom("Mouse", 2));
        purchase_list.add(new PurchaseCustom("Keyboard", 1));
        purchase_list.add(new PurchaseCustom("Mousepad", 3));
        purchase_list.add(new PurchaseCustom("Table", 2));
        purchase_list.add(new PurchaseCustom("TV", 1));
        purchase_list.add(new PurchaseCustom("Gaming Chair", 1));

        List<ContactCustom> contacts_list = new ArrayList<>();
        try{
            String path = "images/pessoa";
            contacts_list.add(new ContactCustom("people1", "123456789", Load_image.loadImage(path + "(1).png")));
            contacts_list.add(new ContactCustom("people2", "987654321", Load_image.loadImage(path + "(2).png")));
        }
        catch (IOException e){
            e.printStackTrace();
        }

        String ip_host = "localhost";
        int port = 6790;

        try (Socket client_socket = new Socket(ip_host, port)) {
            System.out.println("Connected to: " + ip_host + ":" + port);

            try (ObjectOutputStream output = new ObjectOutputStream(client_socket.getOutputStream())) {
                //For Purchase
                for (org.example.PurchaseCustom purchase : purchase_list) {
                    purchase.writeObject(output);
                    System.out.println("Object sent: " + purchase.toString());
                }
                // For Contacts
//                for (ContactCustom contact : contacts_list) {
//                    contact.writeObject(output);
//                    System.out.println("Object sent: " + contact.toString());
//                }
            } catch (IOException e) {
                System.err.println("Error to send: " + e.getMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

