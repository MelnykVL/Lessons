package edu.lessons.inheritance;

public class InheritanceExample {
    public static void main(String[] args) {

        A a = new B();

        a.m1();
        a.m2();
//        a.m3(); !----Error-----!

        a.a2 = 3;
//        a.b2 = 4; !----Error-----!

        System.out.println();

        B b = (B) a;
        b.m1();
        b.m2();
        b.m3();

        b.b2 = 5;

        System.out.println("a2 = " + b.a2);
        System.out.println("b2 = " + b.b2);

    }
}
