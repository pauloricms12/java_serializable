package org.example;

import java.io.Serializable;

public class Contact implements Serializable {
    private String name;
    private String phoneNumber;
    public byte[] photo;

    public Contact(String name, String phoneNumber, byte[] photo) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public byte[] getPhoto() {
        return photo;
    }

    @Override
    public String toString() {
        return "org.example.Contact: Name: " + name + ", PhoneNumber: " + phoneNumber + "\n" + "Photo size: " + photo.length;
    }
}
