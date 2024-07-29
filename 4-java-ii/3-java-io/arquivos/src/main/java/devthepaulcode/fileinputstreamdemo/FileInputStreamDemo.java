package devthepaulcode.fileinputstreamdemo;

import java.io.*;

public class FileInputStreamDemo {

    private static final String MY_FILE = "C:\\trilhaJava\\pos-graduacao\\4-java-ii\\java-io" +
            File.separator + "file-using-iostream.txt";

    String texto = "Java IO\n\n"
            + "Java IO (Input/Output) é um pacote de classes e interfaces\n"
            + "que permite a leitura e escrita de dados. Ele é essencial\n"
            + "para operações como leitura de arquivos, escrita de dados,\n"
            + "e comunicação via rede.\n\n"
            + "Principais classes e interfaces:\n\n"
            + "1. InputStream / OutputStream\n"
            + "   - Abstrações para leitura e escrita de bytes.\n"
            + "   - FileInputStream / FileOutputStream: Manipulação de arquivos.\n"
            + "   - BufferedInputStream / BufferedOutputStream: Leitura e escrita\n"
            + "     eficientes com buffer.\n\n"
            + "2. Serializable\n"
            + "   - Interface para converter um objeto em um stream de bytes,\n"
            + "     permitindo sua gravação em arquivos ou envio pela rede.\n\n"
            + "Uso comum:\n\n"
            + "- Leitura de arquivos:\n"
            + "```java\n"
            + "import java.io.*;\n\n"
            + "public class ExemploLeituraBytes {\n"
            + "    public static void main(String[] args) {\n"
            + "        try (FileInputStream fis = new FileInputStream(\"exemplo.txt\")) {\n"
            + "            int byteData;\n"
            + "            while ((byteData = fis.read()) != -1) {\n"
            + "                System.out.print((char) byteData);\n"
            + "            }\n"
            + "        } catch (IOException e) {\n"
            + "            e.printStackTrace();\n"
            + "        }\n"
            + "    }\n"
            + "}\n"
            + "```\n";
    
    public FileInputStreamDemo(){
        try {
            writeFile();
        } catch(IOException ex){
            ex.printStackTrace();
        }

        try {
            readFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void writeFile() throws IOException {
        try (final FileOutputStream file = new FileOutputStream(MY_FILE)){
            for(char c : texto.toCharArray()){
                file.write(c);
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }

    }

    private void readFile() throws IOException {
        final FileInputStream file = new FileInputStream(MY_FILE);

        int data;
        while ((data = file.read()) != -1){
            System.out.print((char) data);
        }
        file.close();
        
    }
    
    public static void main(String[] args){
        new FileInputStreamDemo();
    }

}
