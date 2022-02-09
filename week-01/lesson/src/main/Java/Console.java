package main.Java;

import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scnr.nextLine();
        System.out.println("Yo what is up " + name);
        System.out.printf("Hey its you %s what is up dog, how is your %s?", name, "mom");
        /*for (int i = 0; i < 1000; i++) {
            System.out.println(i);

        }*/
    }
}