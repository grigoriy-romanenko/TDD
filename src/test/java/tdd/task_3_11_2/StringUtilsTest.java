package tdd.task_3_11_2;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static tdd.task_3_11_2.StringUtils.reverse;

@RunWith(JUnitParamsRunner.class)
public class StringUtilsTest {

    private Object[] getInvalidStrings() {
        return new Object[] {"", " ", null};
    }

    private Object[] getValidStrings() {
        return new Object[] {
                new Object[] {"123", "321"}
        };
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidStrings")
    public void shouldThrowExceptionIfInputStringIsEmpty(String stringToReverse) {
        reverse(stringToReverse);
    }

    @Test
    @Parameters(method = "getValidStrings")
    public void shouldRevertString(String input, String output) {
        assertEquals(reverse(input), output);
    }
}
