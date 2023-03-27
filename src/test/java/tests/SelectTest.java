package tests;

import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import pages.samplepagetest.SamplePage;

public class SelectTest extends TestBase{
    String value;
    SamplePage samplePage;

    @Test
    public void selectTest() throws InterruptedException {
        samplePage = new SamplePage(driver);
        samplePage.selectValue("3-5");
        Thread.sleep(5000);
    }
}
