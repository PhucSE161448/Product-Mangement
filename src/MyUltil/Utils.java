/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyUltil;

import java.util.Scanner;

public class Utils {

    public static Scanner sc = new Scanner(System.in);

    public static String getString(String msg, String pattern) {
        String result = "";
        boolean check = false;
        do {
            System.out.print(msg);
            result = sc.nextLine();
            if (!result.matches(pattern)) {
                System.out.println("Wrong !!! ");
            } else {
                check = true;
            }
        } while (!check);
        return result;
    }

    public static Double getDouble(String msg,String err,int max,int min) {
        Double result = 0.0;
        boolean check = false;
        do {
            try {
                System.out.print(msg);
                result = Double.parseDouble(sc.nextLine());
                if (result < min || result > max) {
                    System.out.println(err);
                } else {
                    check = true;
                }
            } catch (NumberFormatException e) {
                    System.out.println("PLEASE ENTER A NUMBER !!!");
            }
        } while (!check);
        return result;
    }
    
    public static String getStatus(String msg) {
        String result = "";
        boolean check = false;
        do {
            System.out.print(msg);
            result = sc.nextLine();
            if (result.equalsIgnoreCase("Available") || result.equalsIgnoreCase("Not available")){
                check = true;
            } else {
                System.out.println("WRONG FORMAT !!! ");
            }
        } while (!check);
        return result;
    }
    
        public static String getUserchoice(String msg){
        String result = "";
        boolean check = false;
        do {            
            System.out.print(msg);
            String x = sc.nextLine();
            if(!x.isEmpty() && x.equalsIgnoreCase("YES") || x.equalsIgnoreCase("NO")){
                result = x;
                check = true;
            }else
                System.out.println("PLEASE CHOOSE YES/NO !!! ");
        } while (!check);
        return result;
    }
    
}
