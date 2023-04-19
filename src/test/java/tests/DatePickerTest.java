package tests;

import org.apache.commons.lang3.time.DateUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.demoqa.DatePickerPage;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class DatePickerTest extends TestBase{
    DatePickerPage datePickerPage;
    String testDate;
    String actualTestDate;
    String expectedTestDate;
    String time;
    String url = "https://demoqa.com/date-picker";
    Date date = DateUtils.addDays(new Date(), 1);
    Date datePlusMont = DateUtils.addMonths(new Date(), 1);
    Date timePlus = DateUtils.addHours(new Date(), 2);
    SimpleDateFormat chooseFormatter;
    SimpleDateFormat actualFormatter;
    SimpleDateFormat timeFormatter;
    SimpleDateFormat actualDateTimeFormatter;

    public String getRandomMin() {
        List<String> min = Arrays.asList("00", "15", "30", "45");
        Random random = new Random();
        int randomIndex = random.nextInt(min.size());
        return min.get(randomIndex);
    }

    @BeforeMethod
    public void openUrl() {
//        Tuesday, May 16th, 2023
        chooseFormatter = new SimpleDateFormat("EEEE, MMMM d'th', yyyy");
//        04/19/2023
        actualFormatter = new SimpleDateFormat("MM/dd/yyyy");
        String randomMin = getRandomMin();
        timeFormatter = new SimpleDateFormat("HH:" + randomMin);
        actualDateTimeFormatter = new SimpleDateFormat("MMMM d, yyyy h:" + randomMin +" aa");
        driver.get(url);
    }


    @Test
    public void choseDataTest() {
        testDate = chooseFormatter.format(date);
        expectedTestDate = actualFormatter.format(date);
        datePickerPage = new DatePickerPage(driver);
        Assert.assertTrue(datePickerPage.getCalendar());
        datePickerPage.chooseDate(testDate);
        actualTestDate = datePickerPage.getDateFromField();
        Assert.assertEquals(actualTestDate, expectedTestDate);
    }

    @Test
    public void choseDataPlusMonthTest() {
        testDate = chooseFormatter.format(datePlusMont);
        expectedTestDate = actualFormatter.format(datePlusMont);
        datePickerPage = new DatePickerPage(driver);
        Assert.assertTrue(datePickerPage.getCalendar());
        datePickerPage.getNextMont();
        datePickerPage.chooseDate(testDate);
        actualTestDate = datePickerPage.getDateFromField();
        Assert.assertEquals(actualTestDate, expectedTestDate);
    }

    @Test
    public void chooseDateTimeTest() {
        testDate = chooseFormatter.format(timePlus);
        expectedTestDate = actualDateTimeFormatter.format(timePlus);
        time = timeFormatter.format(timePlus);
        datePickerPage = new DatePickerPage(driver);
        Assert.assertTrue(datePickerPage.getDateTimeCalendar());
        datePickerPage.chooseDate(testDate);
        datePickerPage.chooseTime(time);
        actualTestDate = datePickerPage.getDateTimeFromField();
        Assert.assertEquals(actualTestDate, expectedTestDate);
    }

}
