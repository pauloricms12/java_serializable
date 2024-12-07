package org.example;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ContactCustom extends Contact implements Serializable {

    public ContactCustom(String name, String PhoneNumber, byte[] photo){
        super(name, PhoneNumber, photo);
    }

    public void writeObject(ObjectOutputStream obj) throws IOException{
        obj.writeUTF(getName());
        obj.writeUTF(getPhoneNumber());
        obj.writeInt(photo.length);
        obj.write(getPhoto());
    }

}
