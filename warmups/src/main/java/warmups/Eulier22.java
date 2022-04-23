package warmups;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Eulier22 {
    public static void main(String[] args) {
        String text = "";
        try {
            File file = new File("p022_names.txt");
            Scanner myReader = new Scanner(file);
            text = myReader.nextLine();
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[] split = text.split("\",\"");
        split[0] = split[0].substring(1);
        split[split.length-1] = split[split.length-1].replace("\"","");
        List<String> collect = Arrays.stream(split).sorted().toList();
        collect.forEach(System.out::println);

    }
}
