package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.demoqa.DynamicProperties;

public class DynamicPropertiesTest extends TestBase {
    String url = "https://demoqa.com/dynamic-properties";
    DynamicProperties dynamicProperties;

    @BeforeMethod
    public void openUrl() {
        driver.get(url);
    }

    @Test
    public void waitButton() {
        dynamicProperties = new DynamicProperties(driver);
        dynamicProperties.waitButton();
    }
}
