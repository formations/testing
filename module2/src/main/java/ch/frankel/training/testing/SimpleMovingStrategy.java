package ch.frankel.training.testing;

public class SimpleMovingStrategy implements MovingStrategy {

    @Override
    public void move(Athlete athlete, Torch torch) {
        int horizontal = torch.getX() - athlete.getX();
        if (horizontal > 0) {
            athlete.moveRight();
        } else if (horizontal < 0) {
            athlete.moveLeft();
        }
        int vertical = torch.getY() - athlete.getY();
        if (vertical > 0) {
            athlete.moveUp();
        } else if (vertical < 0) {
            athlete.moveDown();
        }
    }
}
