package org.example;
import com.google.protobuf.ByteString;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client_Protobuf {

    public static void main(String[] args) {

        List<PurchaseProtoBuf.PurchaseProto> purchase_list = new ArrayList<>();
        purchase_list.add(PurchaseProtoBuf.PurchaseProto.newBuilder().setProduct("Laptop").setQuantity(1).build());
        purchase_list.add(PurchaseProtoBuf.PurchaseProto.newBuilder().setProduct("Mouse").setQuantity(2).build());
        purchase_list.add(PurchaseProtoBuf.PurchaseProto.newBuilder().setProduct("Keyboard").setQuantity(1).build());
        purchase_list.add(PurchaseProtoBuf.PurchaseProto.newBuilder().setProduct("Mousepad").setQuantity(3).build());
        purchase_list.add(PurchaseProtoBuf.PurchaseProto.newBuilder().setProduct("Table").setQuantity(2).build());
        purchase_list.add(PurchaseProtoBuf.PurchaseProto.newBuilder().setProduct("TV").setQuantity(1).build());
        purchase_list.add(PurchaseProtoBuf.PurchaseProto.newBuilder().setProduct("Gaming Chair").setQuantity(1).build());


        String path = "images/pessoa";
        byte[] image1 = null;
        byte[] image2 = null;
        try {
            image1 = Load_image.loadImage(path + "(1).png");
            image2 = Load_image.loadImage(path + "(2).png");
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<ContactProtoBuf.ContactProto> contacts_list = new ArrayList<>();
        contacts_list.add(ContactProtoBuf.ContactProto.newBuilder()
                .setName("people1")
                .setPhonenumber("123456789")
                .setPhoto(ByteString.copyFrom(image1))
                .build());
        contacts_list.add(ContactProtoBuf.ContactProto.newBuilder()
                .setName("people2")
                .setPhonenumber("987654321")
                .setPhoto(ByteString.copyFrom(image2))
                .build());

        String ip_host = "localhost";
        int port = 6790;

        try (Socket clientSocket = new Socket(ip_host, port);
             OutputStream output = clientSocket.getOutputStream()) {
            System.out.println("Connected to: " + ip_host + ":" + port);

            for(ContactProtoBuf.ContactProto purchase : contacts_list){
                purchase.writeTo(output);
                System.out.println("Object sent: " + purchase);
            }
            System.out.println("Data sent.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
                }
    }
}

