package br.edu.utfpr.sistemarquivos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {

    public void read(Path path) throws IOException {

        System.out.println("Contents of " + path.toString());
        Files.readAllLines(path)
                .forEach(System.out::println);
    }
}
