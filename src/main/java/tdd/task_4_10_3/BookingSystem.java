package tdd.task_4_10_3;

/**
 * Your task is to write a (very) simplified version of a booking system.
 * In fact, it can be written as a single class, which should:
 * • return a list of booked hours,
 * • not allow a particular hour to be double-booked,
 * • deal in a sensible manner with illegal values (provided as input parameters).
 * On the constraints side (to make the task more appropriate for practicing TDD), the system:
 * • has only one resource that can be booked (e.g. a classroom, a lawn mower,
 *         a restaurant table, or anything else that makes sense to you),
 * • has no notion of days, or to put it differently, it assumes all reservations are for today,
 * • should only permit booking of regular whole clock-hours (e.g. it should not allow
 *         a booking from 4:30 pm. to 5:30 pm.),
 * • is not required to remember any additional information concerning
 *         the reservation (who booked it, when etc.).
 */
public class BookingSystem {

    private boolean[] bookedHours = new boolean[24];

    public void reserve(int start, int end) {
        checkForIllegalPeriod(start, end);
        if (! isPeriodIsAvailable(start, end)) {
            throw new RuntimeException();
        }
        for (int i = start; i < end; i++) {
            bookedHours[i] = true;
        }
    }

    public void unReserve(int start, int end) {
        checkForIllegalPeriod(start, end);
        for (int i = start; i < end; i++) {
            bookedHours[i] = false;
        }
    }

    public boolean isPeriodIsAvailable(int start, int end) {
        for (int i = start; i < end; i++) {
            if (bookedHours[i]) {
                return false;
            }
        }
        return true;
    }

    private void checkForIllegalPeriod(int start, int end) {
        if (start < 0 || end > 23 || start >= end) {
            throw new IllegalArgumentException();
        }
    }
}
