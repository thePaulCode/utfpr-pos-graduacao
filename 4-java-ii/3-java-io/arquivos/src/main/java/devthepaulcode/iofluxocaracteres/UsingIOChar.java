package devthepaulcode.iofluxocaracteres;

import java.io.*;

public class UsingIOChar {
    private static final String MY_FILE = "C:\\trilhaJava\\pos-graduacao\\4-java-ii\\java-io" +
            File.separator + "file-using-io-char.txt";
    public UsingIOChar() {
        try {
            writeFile();
        } catch (IOException ex){
            ex.printStackTrace();
        }
        readFile();
    }

    public void writeFile() throws IOException {
        final FileWriter fileWriter = new FileWriter(MY_FILE);
        fileWriter.write("IO Character Flow File");
        fileWriter.close();
    }

    public void readFile(){
        try (final FileReader input = new FileReader(MY_FILE)){
            int content;
            while ((content = input.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new UsingIOChar();
    }
}
