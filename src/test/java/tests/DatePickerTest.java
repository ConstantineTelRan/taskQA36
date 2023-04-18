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

public class DatePickerTest extends TestBase {

    DatePickerPage datePickerPage;
    String testDate;
    String expectedTestDate;
    String actualTestDate;
    String time;
    Date date = new Date();
    Date datePlusMonth = DateUtils.addMonths(new Date(), 1);
    Date timePlus = DateUtils.addHours(new Date(), 6);
    SimpleDateFormat chooseFormatter;
    SimpleDateFormat actualFormatter;
    SimpleDateFormat actualDateTimeFormatter;
    SimpleDateFormat timeFormatter;
    String url = "https://demoqa.com/date-picker";

    public String getRandomMin() {
        List<String> min = Arrays.asList("00", "15", "30", "45");
        Random random = new Random();
        int randomIndex = random.nextInt(min.size());
        return min.get(randomIndex);
    }

    @BeforeMethod
    public void openUrl() {
        chooseFormatter = new SimpleDateFormat("EEEE, MMMM d'th', yyyy");
        actualFormatter = new SimpleDateFormat("MM/dd/yyyy");
        String randomMin = getRandomMin();
        timeFormatter = new SimpleDateFormat("HH:" + randomMin);
        actualDateTimeFormatter = new SimpleDateFormat("MMMM d, yyyy h:" + randomMin + " aa");
        driver.get(url);
    }

    @Test
    public void chooseDateTest() {
        testDate = chooseFormatter.format(date);
        expectedTestDate = actualFormatter.format(date);
        datePickerPage = new DatePickerPage(driver);
        Assert.assertTrue(datePickerPage.getCalendar());
        datePickerPage.chooseDate(testDate);
        actualTestDate = datePickerPage.getDateFromField();
        Assert.assertEquals(actualTestDate, expectedTestDate);
    }

    @Test
    public void chooseDatePlusMonthTest() {
        testDate = chooseFormatter.format(datePlusMonth);
        expectedTestDate = actualFormatter.format(datePlusMonth);
        datePickerPage = new DatePickerPage(driver);
        Assert.assertTrue(datePickerPage.getCalendar());
        datePickerPage.getNextMonth();
        datePickerPage.chooseDate(testDate);
        actualTestDate = datePickerPage.getDateFromField();
        Assert.assertEquals(actualTestDate, expectedTestDate);
    }

    @Test
    public void chooseDateWithTimeTest() {
        testDate = chooseFormatter.format(timePlus);
        expectedTestDate = actualDateTimeFormatter.format(timePlus);
        time = timeFormatter.format(timePlus);
        datePickerPage = new DatePickerPage(driver);
        Assert.assertTrue(datePickerPage.getDateTimeCalendar());
        datePickerPage.chooseDate(testDate);
        datePickerPage.chooseTime(time);
        actualTestDate = datePickerPage.getDateTimeFromField();
        Assert.assertEquals(actualTestDate, expectedTestDate);
        System.out.println(actualTestDate);
    }


//    @Test
//    public void chooseDateJSTest() {
//        testDate = chooseFormatter.format(date);
//        expectedTestDate = actualFormatter.format(date);
//        datePickerPage = new DatePickerPage(driver);
//        datePickerPage.chooseDataWithJs();
//        actualTestDate = datePickerPage.getDateFromField();
//        Assert.assertEquals(actualTestDate, expectedTestDate);
//    }



}
