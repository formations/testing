package ch.frankel.training.testing;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleMovingStrategyTest {

    private SimpleMovingStrategy strategy;
    private Athlete athlete;
    private Torch torch;

    @BeforeMethod
    protected void setUp() {
        strategy = new SimpleMovingStrategy();
        torch = new Torch(0, 0);
    }

    @DataProvider(name = "data")
    public Object[][] data() {
        Object[][] data = new Object[8][2];
        data[0] = new Object[] { 0, 1 };
        data[1] = new Object[] { 1, 0 };
        data[2] = new Object[] { 1, 1 };
        data[3] = new Object[] { 2, 2 };
        data[4] = new Object[] { -2, -2 };
        data[5] = new Object[] { 0, 6 };
        data[6] = new Object[] { 0, -6 };
        data[7] = new Object[] { 10, -6 };
        return data;
    }

    @Test(dataProvider = "data")
    public void should_move_to_origin_when_torch_is_at_origin_and_athlete_at_x_y_in_max_turns(int x, int y) {
        int maxTurns = Math.max(Math.abs(x), Math.abs(y));
        athlete = new Athlete(x, y);
        for (int turn = 0; turn < maxTurns; turn++) {
            strategy.move(athlete, torch);
        }
        assertThat(athlete.getX()).isEqualTo(0);
        assertThat(athlete.getY()).isEqualTo(0);
    }
}
