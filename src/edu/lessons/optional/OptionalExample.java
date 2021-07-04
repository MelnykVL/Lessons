package edu.lessons.optional;

import java.util.Optional;

class Person {

    private final String name;
    private final String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }

}

public class OptionalExample {
    public static void main(String[] args) {

        Optional<String> strOpt = Optional.ofNullable("hello");

        orElseDemo(strOpt, "world");
        System.out.println();
        ifPresentOrElseDemo();
        System.out.println();
        optDemo1();
        System.out.println();
        optDemo2();

    }

    private static void optDemo1() {

        Person person = new Person("Vlad", null);
        String email = person
                .getEmail()
                .map(String::toUpperCase)
                .orElse("Vlad don't have an email!");

        System.out.println(email);

    }

    private static void optDemo2() {

        Person person = new Person("Bruno", null);

        if (person.getEmail().isPresent()) {
            String email = person.getEmail().get();
            System.out.println(email.toUpperCase());
        } else {
            System.out.println("Bruno don't have an email!");
        }

    }

    private static void ifPresentOrElseDemo() {

        Optional<String> hello = Optional.ofNullable(null);

        hello.ifPresentOrElse(System.out::println, () -> System.out.println("world"));

    }

    private static <T> void orElseDemo(Optional<T> opt, T t) {

        System.out.println(opt.isPresent());
        System.out.println(opt.isEmpty());

        T orElse = opt.orElse(t); // returns the value if present, otherwise return other

        System.out.println(orElse);
    }

}
