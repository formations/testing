package ch.frankel.training.testing;

@FunctionalInterface
public interface PersonRepository {
    Person find(String name);
}
