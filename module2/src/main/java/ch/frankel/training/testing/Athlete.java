package ch.frankel.training.testing;

public class Athlete extends Location {

    public Athlete(int x, int y) {
        super(x, y);
    }

    public void moveUp() {
        setY(getY() + 1);
    }

    public void moveDown() {
        setY(getY() - 1);
    }

    public void moveLeft() {
        setX(getX() - 1);
    }

    public void moveRight() {
        setX(getX() + 1);
    }
}
