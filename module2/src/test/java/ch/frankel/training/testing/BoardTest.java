package ch.frankel.training.testing;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BoardTest {

    private static final int SIZE = 10;
    private static final int LOCATION = 1;
    private static final int MAX_TURNS = 5;

    private Board board;
    private Athlete athlete;
    private MovingStrategy strategy;

    @BeforeMethod
    protected void setUp() {
        athlete = mock(Athlete.class);
        strategy = mock(MovingStrategy.class);
        board = new Board(SIZE, SIZE, athlete, new Torch(LOCATION, LOCATION), strategy, MAX_TURNS);
    }

    @Test(expectedExceptions = OutOfBoundException.class)
    public void should_throw_out_of_bound_when_move_over_horizontal_size() {
        when(athlete.getX()).thenReturn(SIZE);
        board.start();
    }

    @Test(expectedExceptions = OutOfBoundException.class)
    public void should_throw_out_of_bound_when_move_over_vertical_size() {
        when(athlete.getY()).thenReturn(SIZE);
        board.start();
    }

    @Test(expectedExceptions = OutOfBoundException.class)
    public void should_throw_out_of_bound_when_move_under_horizontal_size() {
        when(athlete.getX()).thenReturn(-1);
        board.start();
    }

    @Test(expectedExceptions = OutOfBoundException.class)
    public void should_throw_out_of_bound_when_move_under_vertical_size() {
        when(athlete.getY()).thenReturn(-1);
        board.start();
    }

    @Test(expectedExceptions = TimeExceededException.class)
    public void should_throw_time_exceeded_when_too_much_time_has_passed() {
        when(athlete.getX()).thenReturn(LOCATION + 1);
        when(athlete.getY()).thenReturn(LOCATION + 1);
        board.start();
    }

    @Test
    public void has_reached_origin_should_return_true_when_has_reached_origin() {
        when(athlete.getX()).thenReturn(LOCATION);
        when(athlete.getY()).thenReturn(LOCATION);
        assertThat(board.hasReachedTorch()).isTrue();
    }

    @Test
    public void has_reached_origin_should_return_false_when_has_not_reached_origin() {
        when(athlete.getX()).thenReturn(LOCATION + 1);
        when(athlete.getY()).thenReturn(LOCATION + 1);
        assertThat(board.hasReachedTorch()).isFalse();
    }
}
