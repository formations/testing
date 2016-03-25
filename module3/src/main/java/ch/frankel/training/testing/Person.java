package ch.frankel.training.testing;

public class Person {

    private final String name;
    private final String hash;

    public Person(String name, String hash) {
        this.name = name;
        this.hash = hash;
    }

    public String getName() {
        return name;
    }

    public String getHash() {
        return hash;
    }
}
