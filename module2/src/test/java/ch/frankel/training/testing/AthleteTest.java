package ch.frankel.training.testing;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AthleteTest {

    private static final int X = 5;
    private static final int Y = 5;

    private Athlete athlete;

    @BeforeMethod
    protected void setUp() {
        athlete = new Athlete(X, Y);
    }

    @Test
    public void move_right_should_increment_x_by_1() {
        athlete.moveRight();
        assertThat(athlete.getX()).isEqualTo(X + 1);
    }

    @Test
    public void move_right_should_not_change_y() {
        athlete.moveRight();
        assertThat(athlete.getY()).isEqualTo(Y);
    }

    @Test
    public void move_left_should_decrement_x_by_1() {
        athlete.moveLeft();
        assertThat(athlete.getX()).isEqualTo(X - 1);
    }

    @Test
    public void move_left_should_not_change_y() {
        athlete.moveLeft();
        assertThat(athlete.getY()).isEqualTo(Y);
    }

    @Test
    public void move_up_should_increment_y_by_1() {
        athlete.moveUp();
        assertThat(athlete.getY()).isEqualTo(Y + 1);
    }

    @Test
    public void move_up_should_not_change_x() {
        athlete.moveUp();
        assertThat(athlete.getX()).isEqualTo(X);
    }

    @Test
    public void move_down_should_decrement_y_by_1() {
        athlete.moveDown();
        assertThat(athlete.getY()).isEqualTo(Y - 1);
    }

    @Test
    public void move_down_should_not_change_x() {
        athlete.moveDown();
        assertThat(athlete.getX()).isEqualTo(X);
    }
}
