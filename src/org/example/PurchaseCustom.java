package org.example;

import java.io.*;

public class PurchaseCustom extends Purchase implements Serializable {

    public PurchaseCustom(String product, int quantity) {
        super(product, quantity);
    }

    public void writeObject(ObjectOutputStream obj) throws IOException {
        obj.writeUTF(getProduct());
        obj.writeInt(getQuantity());
    }

}
