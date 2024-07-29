package devthepaulcode.basicfileattibutesdemo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class BasicFileAttributeDemo {

    private static final String MY_FILE = "C:\\trilhaJava\\pos-graduacao\\4-java-ii\\java-io" +
            File.separator + "file-basicfileattribute.txt";
    Date primeiroDezembro = new GregorianCalendar(2023, Calendar.DECEMBER, 1).getTime();

    public BasicFileAttributeDemo() {
        try {
            writeFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void writeFile() throws IOException {
        
        Path path = Paths.get(MY_FILE);
        if(!Files.exists(path)){
            Files.createFile(path);
        }
        Files.writeString(path, "Ola BasicFileAttributes Class!");
        //FileTime fileTime = FileTime.fromMillis(primeiroDezembro.getTime());
        //Files.setLastModifiedTime(path, fileTime);
        //System.out.println("Last Modified: " + Files.getLastModifiedTime(path));
        //Files.deleteIfExists(path);
        BasicFileAttributes attributeView = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println("Regular File: " + attributeView.isRegularFile());
        System.out.println("Size: " + attributeView.size());
        System.out.println("Creation Time: " + attributeView.creationTime());
        System.out.println("Last Access Time: " + attributeView.lastAccessTime());

    }
    public static void main(String[] args) {
        new BasicFileAttributeDemo();

    }
}
