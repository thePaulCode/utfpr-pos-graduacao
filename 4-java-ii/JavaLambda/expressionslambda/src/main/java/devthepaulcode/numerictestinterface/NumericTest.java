package devthepaulcode.numerictestinterface;
@FunctionalInterface
public interface NumericTest<T> {
    boolean test(T n, T m);
}
