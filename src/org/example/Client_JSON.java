package org.example;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Client_JSON {
    public static void main(String[] args) {

        List<Purchase> purchase_list = new ArrayList<>();
        purchase_list.add(new Purchase("Laptop", 1));
        purchase_list.add(new Purchase("Mouse", 2));
        purchase_list.add(new Purchase("Keyboard", 1));
        purchase_list.add(new Purchase("Mousepad", 3));
        purchase_list.add(new Purchase("Table", 2));
        purchase_list.add(new Purchase("TV", 1));
        purchase_list.add(new Purchase("Gaming Chair", 1));

        List<Contact> contacts_list = new ArrayList<>();
        try {
            String path = "images/pessoa";
            contacts_list.add(new Contact("people1", "123456789", Load_image.loadImage(path + "(1).png")));
            contacts_list.add(new Contact("people2", "987654321", Load_image.loadImage(path + "(2).png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String ip_host = "localhost";
        int port = 6790;

        try (Socket client_socket = new Socket(ip_host, port)) {
            System.out.println("Connected to: " + ip_host + ":" + port);

            ObjectMapper objectMapper = new ObjectMapper();
            try (ObjectOutputStream output = new ObjectOutputStream(client_socket.getOutputStream())) {
                String json = objectMapper.writeValueAsString(contacts_list);
                output.writeObject(json);
                System.out.println("Json sent: " + json);
                client_socket.close();
            } catch (IOException e) {
                System.err.println("Error to send: " + e.getMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
