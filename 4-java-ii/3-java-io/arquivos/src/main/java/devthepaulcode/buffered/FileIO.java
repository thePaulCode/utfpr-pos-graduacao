package devthepaulcode.buffered;

import java.io.*;

public class FileIO {

    private static final String MY_FILE = "C:\\trilhaJava\\pos-graduacao\\4-java-ii\\java-io" +
            File.separator + "file-using-buffered.txt";
    public FileIO(){
        try {
            writeFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            readFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void writeFile() throws IOException {

        BufferedWriter file = new BufferedWriter(new FileWriter(MY_FILE));
        file.write("Ola BufferedWriter and Reader");
        file.write("\nOla BufferedWriter and Reader2");
        file.write("\nOla BufferedWriter and Reader3");
        file.write("\nOla BufferedWriter and Reader4");
        file.close();
    }
    private void readFile() throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(MY_FILE));
        String line;
        while ((line = file.readLine()) != null){
            System.out.println(line);
        }
        file.close();
    }

    public static void main(String[] args) {
        new FileIO();
    }

}
