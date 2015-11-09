package tdd.task_4_10_3;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class BookingSystemTest {

    private BookingSystem bookingSystem;

    @Before
    public void init() {
        bookingSystem = new BookingSystem();
    }

    @Test
    public void shouldReserveThreeHours() {
        int start = 10;
        int end = 13;
        bookingSystem.reserve(start, end);
        assertFalse(bookingSystem.isPeriodIsAvailable(start, end));
        assertTrue(bookingSystem.isPeriodIsAvailable(0, start));
        assertTrue(bookingSystem.isPeriodIsAvailable(end, 23));
    }

    @Test
    public void shouldUnreserveThreeHours() {
        bookingSystem.reserve(0, 23);
        int start = 10;
        int end = 13;
        bookingSystem.unReserve(start, end);
        assertTrue(bookingSystem.isPeriodIsAvailable(start, end));
        assertFalse(bookingSystem.isPeriodIsAvailable(0, start));
        assertFalse(bookingSystem.isPeriodIsAvailable(end, 23));
    }

    @Test(expected = RuntimeException.class)
    public void shouldNotAllowDoubleBooking() {
        bookingSystem.reserve(10, 13);
        bookingSystem.reserve(10, 13);
    }

    private Object[] getInvalidPeriods() {
        return new Object[] {
                new Object[] {-1, 1},
                new Object[] {1, 24},
                new Object[] {0, 0},
                new Object[] {10, 0}
        };
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidPeriods")
    public void shouldRejectInvalidPeriod(int start, int end) {
        bookingSystem.reserve(start, end);
    }

    @Test
    public void shouldReturnBookedHours() {
        bookingSystem.reserve(10, 13);
        assertEquals(Arrays.asList(10, 11, 12), bookingSystem.getBookedHours());
    }
}
