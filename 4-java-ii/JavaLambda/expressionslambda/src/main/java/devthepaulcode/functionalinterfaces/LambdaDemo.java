package devthepaulcode.functionalinterfaces;

public class LambdaDemo {
    public static void main(String[] args){
        // myValue e inicializada com a expressao lambda
        MyValue myValue = () -> 21.7;
        System.out.println("\n\tO Valor double e: " + myValue.getValue());

        // Expressao Lambda com parametros        
        MyParamValue myParamValue = (n) -> 1 / n;

        System.out.println("\n\tCalculo do reciproco de 5: "+ myParamValue.getValue(5.0));
    }
}
