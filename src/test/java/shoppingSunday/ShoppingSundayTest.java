package shoppingSunday;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingSundayTest {

    private ShoppingSunday shoppingSunday;

    @BeforeEach
    public void init() {
        shoppingSunday = new ShoppingSunday();
    }

    @Test
    public void notSunday2018() {
        LocalDate localDate1 = LocalDate.of(2018, 3, 24);
        LocalDate localDate2 = LocalDate.of(2018, 3, 5);

        boolean result1 = shoppingSunday.isSundayShopping(localDate1);
        boolean result2 = shoppingSunday.isSundayShopping(localDate2);

        assertTrue(result1);
        assertTrue(result2);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/SundayTrade.txt")
    public void sundayTrade(LocalDate localDate, Boolean bool) {
        boolean result = shoppingSunday.isSundayShopping(localDate);

        assertEquals(result, bool);
    }
}
