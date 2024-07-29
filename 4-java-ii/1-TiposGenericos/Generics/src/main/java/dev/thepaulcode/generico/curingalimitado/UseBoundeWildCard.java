package dev.thepaulcode.generico.curingalimitado;

public class UseBoundeWildCard {

    // Curinga limitado para operar somente com objetos
    // de Gen<tipo>, onde tipo é A ou subclasse de A
    static void teste(Gen<? extends A> o) {
        System.out.println("Status: 200 ");
    }
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();

        Gen<A> w = new Gen<>(a);
        Gen<B> w2 = new Gen<>(b);
        Gen<C> w3 = new Gen<>(c);
        Gen<D> w4 = new Gen<>(d);

        teste(w);
        teste(w2);
        teste(w3);

        // Nao e valido, pois w4 nao e
        // subclasse de A
//      teste(w4)
    }
}
