package shoppingSunday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class ShoppingSunday {

    public boolean isSundayShopping(LocalDate localDate) {
        return isNotSunday(localDate) ||
                beforeTradeBan(localDate) ||
                firstLastSunday2018(localDate) ||
                lastSunday2019(localDate) ||
                in2020TradeSunday(localDate);
    }

    private boolean in2020TradeSunday(LocalDate localDate) {
        return localDate.equals(LocalDate.of(2020, 1, 26)) ||
                localDate.equals(LocalDate.of(2020, 4, 5)) ||
                localDate.equals(LocalDate.of(2020, 4, 26)) ||
                localDate.equals(LocalDate.of(2020, 6, 28)) ||
                localDate.equals(LocalDate.of(2020, 8, 30)) ||
                localDate.equals(LocalDate.of(2020, 12, 13)) ||
                localDate.equals(LocalDate.of(2020, 12, 20));
    }

    private boolean lastSunday2019(LocalDate localDate) {
        if (localDate.isAfter(LocalDate.of(2019, 1, 1)) &&
                localDate.isBefore(LocalDate.of(2019, 12, 31))) {
            return localDate.equals(localDate.with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY))) ||
                    localDate.equals(LocalDate.of(2019, 4, 14)) ||
                    localDate.equals(LocalDate.of(2019, 12, 15)) ||
                    localDate.equals(LocalDate.of(2019, 12, 22));
        }
        return false;
    }

    private boolean firstLastSunday2018(LocalDate localDate) {
        if (localDate.isAfter(LocalDate.of(2018, 3, 1)) &&
                localDate.isBefore(LocalDate.of(2018, 12, 31))) {
            if (localDate.equals(LocalDate.of(2018, 4, 1))) {
                return false;
            }
            if (localDate.equals(localDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY))) ||
                    localDate.equals(LocalDate.of(2018, 12, 16)) ||
                    localDate.equals(LocalDate.of(2018, 12, 23))) {
                return true;
            }
            return localDate.equals(localDate.with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY)));
        }
        return false;
    }

    private boolean beforeTradeBan(LocalDate localDate) {
        return localDate.isBefore(LocalDate.of(2018, 3, 1));
    }

    private boolean isNotSunday(LocalDate localDate) {
        return !localDate.getDayOfWeek().equals(DayOfWeek.SUNDAY);
    }
}
