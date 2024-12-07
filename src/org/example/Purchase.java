package org.example;

import java.io.Serializable;

public class Purchase implements Serializable {
    private String product;
    private int quantity;

    public Purchase(String product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product){
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        return "Item: " + product + " x " + quantity + "\n";
    }
}
