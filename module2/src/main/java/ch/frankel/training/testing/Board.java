package ch.frankel.training.testing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Board {

    private static final Logger LOGGER = LoggerFactory.getLogger(Board.class);

    private final int height;
    private final int width;
    private final int maxTurn;
    private final MovingStrategy strategy;
    private final Athlete athlete;
    private final Torch torch;
    private int turn;

    public Board(int width, int height, Athlete athlete, Torch torch, MovingStrategy strategy, int maxTurn) {
        this.width = width;
        this.height = height;
        this.maxTurn = maxTurn;
        this.strategy = strategy;
        this.athlete = athlete;
        this.torch = torch;
    }

    public void start() {
        while (true) {
            LOGGER.info("Turn {}", turn);
            LOGGER.info("Torch is located at [{},{}]", torch.getX(), torch.getY());
            int x = athlete.getX();
            int y = athlete.getY();
            LOGGER.info("Before turn, athlete is located at [{},{}]", x, y);

            strategy.move(athlete, torch);
            LOGGER.info("After turn, athlete is located at [{},{}]", x, y);
            checkOutOfBound();
            if (hasReachedTorch()) {
                System.exit(0);
            }
            checkTimeExceeded();
            turn++;
        }
    }

    boolean hasReachedTorch() {
        if (athlete.getX() == torch.getX() && athlete.getY() == torch.getY()) {
            LOGGER.info("Great job, you reached the torch in {} turns", turn);
            return true;
        }
        return false;
    }

    private void checkTimeExceeded() {
        if (turn >= maxTurn) {
            LOGGER.error("Sorry, Time exceeded%n");
            throw new TimeExceededException();
        }
    }

    private void checkOutOfBound() {
        int x = athlete.getX();
        int y = athlete.getY();
        if (x < 0 || x >= height || y < 0 || y >= width) {
            LOGGER.error("Sorry, you went over the board%n");
            throw new OutOfBoundException();
        }
    }
}
