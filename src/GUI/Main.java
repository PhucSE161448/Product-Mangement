/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.ListProduct;
import java.util.Scanner;
import MyUltil.Utils;

public class Main {

    public static void main(String[] args) {
        String response;
        int choice;
        ListProduct Pr = new ListProduct();
        String f = "Product.txt";
        Menu menu = new Menu();
        menu.add("1.Add Product.");
        menu.add("\n2.Check exitst Prodct.");
        menu.add("\n3.Search Product by Name.");
        menu.add("\n4.Update Product.");
        menu.add("\n5.Save Product to File.");
        menu.add("\n6.Print a list.");
        menu.add("\n7.Exit.");
        menu.add("\nYour choice : ");
        boolean check;
        do {
            check = false;
            Pr.addFromFile(f);
            System.out.println("------Menu-------");
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    do {
                        Pr.addProduct();
                        response = Utils.getUserchoice("Do you want to go back to menu ?");
                    } while (response.equalsIgnoreCase("No"));
                    break;
                case 2 :
                    do {   
                        Pr.CheckExits();
                        response = Utils.getUserchoice("Do you want to go back to menu ?");
                    } while (response.equalsIgnoreCase("No"));
                    break;
                case 3:
                    do {
                        Pr.Search();
                        response = Utils.getUserchoice("Do you want to go back to menu ? ");
                    } while (response.equalsIgnoreCase("No"));
                    break;
                case 4:
                    do {
                        Pr.getUD();
                        response = Utils.getUserchoice("Do you want to go back to menu ? ");
                    } while (response.equalsIgnoreCase("No"));
                    break;
                case 5:
                    do {
                        Pr.saveFromFile(f);
                        response = Utils.getUserchoice("Do you want to go back to menu ? ");
                    } while (response.equalsIgnoreCase("No"));
                    break;
                case 6 :
                    do {                        
                        Pr.Print();
                        response = Utils.getUserchoice("Do you want to go back to menu ? ");
                    } while (response.equalsIgnoreCase("No"));
                    break;
                case 7 : 
                    System.out.println("Thank you for using my software <3");
                    System.exit(0);
                default :
                    System.out.println("PLEASE ENTER NUMBER 1-7");
            }
        } while (choice > 0 && choice <=7);
    }
}
