package main.Java;

import java.util.Scanner;

public class Lesson1 {
    public static void main(String[] args) {
        String hello = "Hello World";
        System.out.println(hello);

        Scanner scanner = new Scanner(System.in);

        System.out.print("What is your name? ");
        String name = scanner.next();
        System.out.println(name);

        System.out.print("Age? ");
        int age = scanner.nextInt();
        System.out.println(2021-age +" is the year you were born.");


    }
}
