package devthepaulcode.newiotwo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingNewIOTwo {
    private static final String MY_FILE = "C:\\trilhaJava\\pos-graduacao\\4-java-ii\\java-io" +
            File.separator + "file-using-new-io-two.txt";
    public UsingNewIOTwo(){
        try {
            writeFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            readFile();
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }

    private void writeFile() throws IOException {
        final Path path = Paths.get(MY_FILE);
        Files.writeString(path, "Ola mundo NIO2");

        System.out.println("Arquivo gravado com sucesso");
    }
    private void readFile() throws IOException {

        final Path path = Paths.get(MY_FILE);
        Files.readAllLines(path)
                .forEach(System.out::print);
    }

    public static void main(String[] args) {
        new UsingNewIOTwo();
    }
}
