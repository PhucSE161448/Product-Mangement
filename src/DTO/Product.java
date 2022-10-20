/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
public class Product {
    private String Name;
    private String ID;
    private String Status;
    private double price;
    private double quantity;

    public Product(String Name, String ID, String Status, double price, double quantity) {
        this.Name = Name;
        this.ID = ID;
        this.Status = Status;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

// 
       @Override
    public String toString() {
        return   ID + "\t" + Name + "\t" + price + "\t" + quantity + "\t" + Status ;
    }
}
