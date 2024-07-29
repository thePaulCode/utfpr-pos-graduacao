package br.edu.utfpr.sistemarquivos;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

import static br.edu.utfpr.sistemarquivos.Application.ROOT;

public enum Command {

    LIST() {
        @Override
        boolean accept(String command) {
            final var commands = command.split(" ");
            return commands.length > 0 && commands[0].startsWith("LIST") || commands[0].startsWith("list");
        }

        @Override
        Path execute(Path path) throws IOException {

            try(DirectoryStream<Path> file = Files.newDirectoryStream(path)){
                System.out.println("Contents of " + path.toString());
                for (Path f : file) {
                    System.out.println(f.getFileName());
                }
            } catch (IOException ex){
                ex.printStackTrace();
            }

            return path;
        }
    },
    SHOW() {
        private String[] parameters = new String[]{};

        @Override
        void setParameters(String[] parameters) {
            this.parameters = parameters;
        }

        @Override
        boolean accept(String command) {
            final var commands = command.split(" ");
            return commands.length > 0 && commands[0].startsWith("SHOW") || commands[0].startsWith("show");
        }

        @Override
        Path execute(Path path) throws IOException {

            try {
                if (parameters[1].length() == 0 || parameters.length == 0) {
                    System.out.println("Enter a file's name with the .txt file format.");
                    return path;
                }
                Path newPath = path.resolve(parameters[1]).normalize();
                FileReader fileReader = new FileReader();

                if (newPath.toString().endsWith(".txt") && Files.exists(newPath)) {
                    fileReader.read(newPath);
                } else {
                    System.out.println("Fomart not supported. Enter a .txt format.");
                }

            } catch (ArrayIndexOutOfBoundsException ex){
                    System.out.println("This is an invalid parameter.");
                    return path;
            }

            return path;
        }
    },
    BACK() {

        @Override
        boolean accept(String command) {
            final var commands = command.split(" ");
            return commands.length > 0 && commands[0].startsWith("BACK") || commands[0].startsWith("back");
        }

        @Override
        Path execute(Path path) {

            Path parentPath = path.getParent();
            if(!parentPath.startsWith(ROOT)) {
                System.out.println("Warning! Already at the root directory >" + path.toString());
                return path;
            }
            return parentPath;
        }
    },
    OPEN() {
        private String[] parameters = new String[]{};

        @Override
        void setParameters(String[] parameters) {
            this.parameters = parameters;
        }

        @Override
        boolean accept(String command) {
            final var commands = command.split(" ");
            return commands.length > 0 && commands[0].startsWith("OPEN") || commands[0].startsWith("open");
        }

        @Override
        Path execute(Path path) {

            try {
                if (parameters[1].length() == 0 || parameters.length == 0) {
                    System.out.println("Directory was not specified.");
                    return path;
                }

                Path newPath = path.resolve(parameters[1]).normalize();
                if (Files.exists(newPath) && Files.isDirectory(newPath)) {
                    return newPath;
                } else {
                    System.out.println("The directory is invalid.");
                }
            } catch (ArrayIndexOutOfBoundsException ex){
                System.out.println("This is an invalid parameter.");
                return path;
            }

            return path;
        }
    },
    DETAIL() {
        private String[] parameters = new String[]{};

        @Override
        void setParameters(String[] parameters) {
            this.parameters = parameters;
        }

        @Override
        boolean accept(String command) {
            final var commands = command.split(" ");
            return commands.length > 0 && commands[0].startsWith("DETAIL") || commands[0].startsWith("detail");
        }

        @Override
        Path execute(Path path) throws IOException {

            try {
                if (parameters.length == 0 || parameters[1].length() == 0) {
                    System.out.println("File was not specified.");
                    return path;
                }
                BasicFileAttributes attributeView = Files.readAttributes(path, BasicFileAttributes.class);

                System.out.println("Regular File: " + attributeView.isRegularFile());
                System.out.println("Size: " + attributeView.size());
                System.out.println("Creation Time: " + attributeView.creationTime());
                System.out.println("Last Access Time: " + attributeView.lastAccessTime());

                return path;

            } catch (ArrayIndexOutOfBoundsException ex){
                System.out.println("This is an invalid parameter or file.");
                return path;
            }
        }
    },
    EXIT() {
        @Override
        boolean accept(String command) {
            final var commands = command.split(" ");
            return commands.length > 0 && commands[0].startsWith("EXIT") || commands[0].startsWith("exit");
        }

        @Override
        Path execute(Path path) {
            System.out.print("Saindo...");
            return path;
        }

        @Override
        boolean shouldStop() {
            return true;
        }
    };

    abstract Path execute(Path path) throws IOException;

    abstract boolean accept(String command);

    void setParameters(String[] parameters) {
    }

    boolean shouldStop() {
        return false;
    }

    public static Command parseCommand(String commandToParse) {

        if (commandToParse.isBlank()) {
            throw new UnsupportedOperationException("Type something...");
        }

        final var possibleCommands = values();

        for (Command possibleCommand : possibleCommands) {
            if (possibleCommand.accept(commandToParse)) {
                possibleCommand.setParameters(commandToParse.split(" "));
                return possibleCommand;
            }
        }

        throw new UnsupportedOperationException("Can't parse command [%s]".formatted(commandToParse));
    }
}
