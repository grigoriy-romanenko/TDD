package tdd.task_4_10_3;

import java.util.LinkedList;
import java.util.List;

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

    public List<Integer> getBookedHours() {
        List<Integer> bookedHoursList = new LinkedList<Integer>();
        for (int i = 0; i < bookedHours.length; i++) {
            if (bookedHours[i]) {
                bookedHoursList.add(i);
            }
        }
        return bookedHoursList;
    }

    private void checkForIllegalPeriod(int start, int end) {
        if (start < 0 || end > 23 || start >= end) {
            throw new IllegalArgumentException();
        }
    }
}
