package ch.frankel.training.testing;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @BeforeMethod
    protected void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @DataProvider(name = "data")
    public Object[][] data() {
        Object[][] data = new Object[5][2];
        data[0] = new Object[] { 3, "12"};
        data[1] = new Object[] { 4, "12Fizz"};
        data[2] = new Object[] { 5, "12Fizz4"};
        data[3] = new Object[] { 6, "12Fizz4Buzz"};
        data[4] = new Object[] { 16, "12Fizz4BuzzFizz78FizzBuzz11Fizz1314FizzBuzz"};
        return data;
    }

    @Test(dataProvider = "data")
    public void should_output_x_when_end_is_y(int x, String y) {
        assertThat(fizzBuzz.compute(x)).isEqualTo(y);
    }
}
