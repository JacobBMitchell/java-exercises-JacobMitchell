import java.io.*;

public class LearnFiles {
    private static String fileName = "colors.txt";
    public static void main(String[] args) {

        File file = new File(fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("File made!");
            } else {
                System.out.println("already exists");

            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        writeToFile();

        readfromFile();

        boolean deleted = false;
        //deleted = deleteFile(file);
        if (deleted){
            System.out.println("File was deleted");
        }
        else {
            System.out.println("File remains");
        }
    }

    private static boolean deleteFile(File file) {
        boolean result = file.delete();
        return result;
    }

    private static void readfromFile() {
        System.out.println("File " + fileName + " Contents:");
        try{
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // the line starts at the first line... while line isn't null... read the next line
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()){
                System.out.println(line);
            }
            bufferedReader.close();
            fileReader.close();

        } catch (IOException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }

    private static void writeToFile() {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(fileName);
            printWriter.println("Red");
            printWriter.println("Blue");
            printWriter.println("Green");
            printWriter.println("Orange");
            printWriter.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(printWriter != null) {
                printWriter.close();
            }
        }

    }
}
