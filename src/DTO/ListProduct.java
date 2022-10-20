/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import MyUltil.Utils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ListProduct extends ArrayList<Product> {

    public static Scanner sc = new Scanner(System.in);
    private int count = 0;

    public ListProduct() {
    }

    public void addFromFile(String fname) {
        File f = new File(fname);
        if (f.exists()) {
            return;
        }
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String details;
            while ((details = br.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, "|");
                String ID = stk.nextToken().toUpperCase();
                String name = stk.nextToken().toUpperCase();
                Double price = Double.parseDouble(stk.nextToken());
                Double quantity = Double.parseDouble(stk.nextToken());
                String Status = stk.nextToken().toUpperCase();
                Product pr = new Product(name, ID, Status, price, quantity);
                this.add(pr);
                count++;
            }
            br.close();
            fr.close();
        } catch (Exception e) {
        }
    }

    public void saveFromFile(String fname) {
        File f = new File(fname);
        if (this.isEmpty()) {
            System.out.println("FILE IS EMPTY !!");;
        }
        try {
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Product x : this) {
                bw.write(x.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }

    public void addProduct() {
        String ID, Name, Status;
        Double price, quantity;
        System.out.println("There is/are " + count + "Products.");
        ID = Utils.getString("Enter Product ID : ", "^00\\d{1}$");
        while (true) {
            Name = Utils.getString("Enter Product Name : ", "[\\S]{5}$");
            Product pr = findName(Name);
            if (pr == null) {
                break;
            } else {
                System.out.println("Duplicate Name !!!");
            }
        }
        price = Utils.getDouble("Enter UnitPrice : ", "Can not less than 0 or more than 10000 !!! ", 10000, 0);
        quantity = Utils.getDouble("Enter Quantity : ", "Can not less than 0 or more than 1000 !!! ", 1000, 0);
        Status = Utils.getStatus("Enter Status : ");
        Product pr = new Product(Name, ID, Status, price, quantity);
        this.add(pr);
        count++;
    }

    public Product findName(String name) {
        for (Product x : this) {
            if (name.equalsIgnoreCase(x.getName())) {
                return x;
            }
        }
        return null;
    }

    public Product findID(String ID) {
        for (Product x : this) {
            if (ID.equalsIgnoreCase(x.getID())) {
                return x;
            }
        }
        return null;
    }

    public void CheckExits() {
        String name;
        name = Utils.getString("Enter name you want to check : ", "[\\S]{5}$");
        Product pr = findName(name);
        if (pr == null) {
            System.out.println("No Product Found! ");
        } else {
            System.out.println("Exits Product ! ");
            System.out.println(pr.toString());
        }
    }

    public void Search() {
        String name;
        name = Utils.getString("Enter name you want to search : ", "[\\S]{5}$");
        Product pr = findName(name);
        if (pr == null) {
            System.out.println("Have no any Product ");
        } else {
            Collections.sort(this, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            System.out.println(pr.toString());
        }
    }

    public void Update() {
        String ID;
        ID = Utils.getString("Enter Product ID : ", "^00\\d{1}$");
        Product pr = findID(ID);
        if (pr == null) {
            System.out.println("Productname does not exist");
            System.out.println("UPDATE FAILED !!");
        } else if (ID.isEmpty()) {
            System.out.println("Old information will not be changed.");
        } else {
            Double oldPrice = pr.getPrice();
            String oldStatus = pr.getStatus();
            String newStatus = Utils.getStatus("Enter New Status : ");
            Double newPrice = Utils.getDouble("Enter New Price : ", "Can not less than 0 or more than 10000", 10000, 0);
            System.out.println("Old Price = " + oldPrice + " => New Price : " + newPrice);
            System.out.println("Old Status : " + oldStatus + " => New Status : " + newStatus);
            pr.setPrice(newPrice);
            pr.setStatus(newStatus);
            System.out.println("UPDATE SUCESSFULLY.");
        }
    }

    public void Delete() {
        String ID;
        ID = Utils.getString("Enter Product ID : ", "^00\\d{1}$");
        Product pr = findID(ID);
        if (pr == null) {
            System.out.println("Productname does not exist");
            System.out.println("UPDATE FAILED !!");
        } else if (ID.isEmpty()) {
            System.out.println("Old information will not be changed.");
        } else {
            this.remove(pr);
            System.out.println("DELETE SUCESSFULLY.");
        }
    }

    public void getUD() {
        String choice;
        boolean check;
        check = true;
        System.out.println("1.Update Product");
        System.out.println("2.Delete Product");
        choice = Utils.getString("Enter your choice (1 or 2): ", "[1-2]");
        switch (choice) {
            case "1":
                this.Update();
                break;
            case "2":
                this.Delete();
                break;
        }
    }
    
    public void Print(){
        Collections.sort(this, new Comparator<Product>(){
            @Override
            public int compare(Product o1, Product o2) {
                if(o1.getQuantity() == o2.getQuantity()){
                    return Double.compare(o1.getPrice(), o2.getPrice());
                }
            return Double.compare(o1.getQuantity(),o2.getQuantity());
            }     
    });
        System.out.println("");
        System.out.println("======LIST PRODUCT======");
        for (Product x : this) {
            System.out.println(x.toString());
        }
}
}
