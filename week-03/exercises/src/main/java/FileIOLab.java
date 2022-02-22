import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileIOLab {
    private static String readMe = "README.txt";

    public static void main(String[] args) {
        File file = new File(readMe);
        FileReader fr = null;
        try {
            fr = new FileReader(readMe);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bf = new BufferedReader(fr);
        try {
            for (String line = bf.readLine(); line != null; line = bf.readLine()) {
                if (!line.contains("#")) {
                    //System.out.println(line);
                    doCommand(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void doCommand(String line) {
        //if create
        if (line.contains("CREATE")) {
            createNewFile(line);
        }
        //if append
        if (line.contains("APPEND")){
            appendToFile(line);
        }
        //if delete
        if (line.contains("DELETE")){
            boolean deleted = deleteFile(line);
            if (deleted){
                System.out.println("File deleted");
            }
            else {
                System.out.println("File remains");
            }
        }
        if (line.contains("COPY")){
            //cpFile(line);
            System.out.println(":)");
        }

        // if copy
    }

    private static void cpFile(String line) {
        String[] fileName = line.split(" ");
        String srcFile = fileName[1];
        String dstFile = fileName[2];
        Path destinationPath = Path.of(dstFile);
        Path sourcePath = Path.of(srcFile);
        try {
            Files.copy(sourcePath,destinationPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Files.copy
    }

    private static boolean deleteFile(String line) {
        String fileName = line.substring(7);
        //System.out.println(fileName);
        File file = new File(fileName);
        boolean deleted = file.delete();

        return deleted;
    }

    private static void appendToFile(String line) {
        String toAppendPlusFile = line.substring(7); //rmv append
        char[] letters = toAppendPlusFile.toCharArray(); // look at array of rest of line
        int i = 0;
        for (char letter: letters){
            if (letter == ' '){
                break;
            }
            i++;
        }
        String fileName = toAppendPlusFile.substring(0,i);
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName,true))){
            writer.println(toAppendPlusFile.substring(i+1));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //PrintWriter pw = null;
//        try {
//            pw = new PrintWriter(fileName);
//            pw.println(toAppendPlusFile.substring(i+1));
//            pw.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        //System.out.println(toAppendPlusFile);
    }


    private static void createNewFile(String line) {
        String fileName = line.substring(7);
        //System.out.println(fileName);

        File newFile = new File(fileName);
        try {
            if (newFile.createNewFile()) {
                System.out.println("File made!");
            }
            else {
                System.out.println("already exists");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
