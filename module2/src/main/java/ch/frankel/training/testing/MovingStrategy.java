package ch.frankel.training.testing;

@FunctionalInterface
public interface MovingStrategy {

    void move(Athlete athlete, Torch torch);
}
