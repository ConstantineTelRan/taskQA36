package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.demoqa.TextBox;
import util.DataProviders;

public class ParamTexBoxTest extends TestBase {
    String url = "https://demoqa.com/text-box";
    TextBox textBox;

    @BeforeMethod
    public void precondition() {
        driver.get(url);
    }

    @Test(dataProvider = "newContact", dataProviderClass = DataProviders.class)
    public void boxTest(String name, String email, String currentAddress, String permanentAddress) {
        textBox = new TextBox(driver);
        textBox.fillTextBox(name,email, currentAddress, permanentAddress);
        textBox.waitText();

        Assert.assertEquals(textBox.getTextFromInfoField("name"), "Name:" + name);
        Assert.assertEquals(textBox.getTextFromInfoField("email"), "Email:" + email);
        Assert.assertEquals(textBox.getTextFromInfoField("currentAddress"),
                "Current Address :" + currentAddress);
        Assert.assertEquals(textBox.getTextFromInfoField("permanentAddress"),
                "Permananet Address :" + permanentAddress);
    }

    @Test(dataProvider = "newContactWithCsv", dataProviderClass = DataProviders.class)
    public void boxTestCsv(String name, String email, String currentAddress, String permanentAddress) {
        textBox = new TextBox(driver);
        textBox.fillTextBox(name,email, currentAddress, permanentAddress);
        textBox.waitText();

        Assert.assertEquals(textBox.getTextFromInfoField("name"), "Name:" + name);
        Assert.assertEquals(textBox.getTextFromInfoField("email"), "Email:" + email);
        Assert.assertEquals(textBox.getTextFromInfoField("currentAddress"),
                "Current Address :" + currentAddress);
        Assert.assertEquals(textBox.getTextFromInfoField("permanentAddress"),
                "Permananet Address :" + permanentAddress);
    }
}
