package devthepaulcode.iofluxobytes;

import java.io.*;

public class UsingIO {

    private static final String MY_FILE = "C:\\trilhaJava\\pos-graduacao\\4-java-ii\\java-io" +
                                        File.separator + "file-using-io.txt";

    public UsingIO()  {
        try {
            writeFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        readFile();
    }

    public void readFile() {

        // 1 byte = 8bits
        // 1 char UTF-8 = 1 byte


        // Usando a interface CloseAble
        try(final InputStream input = new FileInputStream(MY_FILE)) {
            int content;
            while ((content = input.read()) != -1){
                System.out.print((char) content);

            }
            System.out.println("\nLeitura");
        }catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void writeFile() throws IOException{

//            final File file = new File(MY_FILE);
//
//            boolean fileIsCreated = false;
//
//            if(!file.exists()) {
//                fileIsCreated = file.createNewFile();
//
//            }

//            if(fileIsCreated || file.exists()){
        // Refactor
        // Classes de Fluxos de Bytes
        // Pois o FileOutputStream Cria / Recria o arquivo
        final OutputStream output = new FileOutputStream(MY_FILE);
        output.write("Hello World IO".getBytes());
        System.out.println("Escrita");
        output.close();
            //}

    }

    public static void main(String[] args) {
        new UsingIO();
    }
}
