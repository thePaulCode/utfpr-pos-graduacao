package devthepaulcode.printable;

public class Main {
    public static void main(String[] args) {
       OraclePress oraclePress = new OraclePress();
        oraclePress.print();

        Printable lambdaPrintable = () -> System.out.println("\n\tLearning Java by Doing Lambda!");
        printThing(lambdaPrintable);

    }

    public static void printThing(Printable thing) {
        thing.print();
    }
}