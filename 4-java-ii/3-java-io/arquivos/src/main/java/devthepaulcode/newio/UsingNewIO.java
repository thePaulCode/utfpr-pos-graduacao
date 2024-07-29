package devthepaulcode.newio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class UsingNewIO {
    private static final String MY_FILE = "C:\\trilhaJava\\pos-graduacao\\4-java-ii\\java-io" +
            File.separator + "file-using-new-io.txt";

    public UsingNewIO(){
        try {
            writeFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("---------------------------------");
        try {
            readFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void writeFile() throws IOException {
        final RandomAccessFile file = new RandomAccessFile(MY_FILE, "rw");
        final FileChannel channel = file.getChannel();

        channel.write(ByteBuffer.wrap("Ola Mundo NIO".getBytes(StandardCharsets.UTF_8)));
        channel.close();
        file.close();

        System.out.println("Dados gravados no arquivo.");
    }

    private void readFile() throws IOException {
        final RandomAccessFile file = new RandomAccessFile(MY_FILE, "rw");
        final FileChannel channel = file.getChannel();

        final long fileSize = channel.size();
        final ByteBuffer buffer = ByteBuffer.allocate((int) fileSize);

        channel.read(buffer);
        buffer.flip();

        for (int i = 0; i < fileSize; i++) {

            System.out.print((char) buffer.get());
        }
        channel.close();
        file.close();

    }

    public static void main(String[] args) {
        new UsingNewIO();
    }
}
