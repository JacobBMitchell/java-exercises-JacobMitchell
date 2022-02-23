import java.io.*;
import java.util.Scanner;

public class SecretMessage {
    static Scanner scn = new Scanner(System.in);
    private static String fileName = "secret.txt";
    public static void main(String[] args) {
        File file = new File(fileName);
        try{
            if(file.createNewFile()){
                System.out.println("File created");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.print("Read(r) or Write(w) your secret? ");
        String choice = scn.nextLine();
        if (choice.equalsIgnoreCase("r")){
            readFromFile(file);
        }
        else if(choice.equalsIgnoreCase("w")){
            writeToFile(file);
        }
        System.out.print("Again?(y/n) ");
        String again = scn.nextLine();
        if (again.equalsIgnoreCase("y")) {
            main(null);
        }
    }

    private static void writeToFile(File file) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(file);
            System.out.print("What is the secret? ");
            String secret = scn.nextLine();
            pw.println(secret);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        pw.close();
    }

    private static void readFromFile(File file) {
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            System.out.println(br.readLine());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
