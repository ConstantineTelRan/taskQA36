package tests;

import com.github.javafaker.Faker;
import pages.demoqa.TextBox;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.TestBase;
public class TextBoxTest extends TestBase {
    Faker faker = new Faker();
    String name = faker.name().firstName();
    String email = faker.internet().emailAddress();
    String currentAddress = faker.address().fullAddress();
    String permanentAddress = faker.address().fullAddress();

    String url = "https://demoqa.com/text-box";
    TextBox textBox;

    @BeforeMethod
    public void precondition() {
        driver.get(url);
    }

    @Test
    public void boxTest() {
        textBox = new TextBox(driver);
        textBox.fillTextBox(name,email, currentAddress, permanentAddress);
        textBox.waitText();

//        Assert.assertEquals(textBox.getName(), "Name:" + name);

        Assert.assertEquals(textBox.getTextFromInfoField("name"), "Name:" + name);
        Assert.assertEquals(textBox.getTextFromInfoField("email"), "Email:" + email);
        Assert.assertEquals(textBox.getTextFromInfoField("currentAddress"),
                "Current Address :" + currentAddress);
        Assert.assertEquals(textBox.getTextFromInfoField("permanentAddress"),
                "Permananet Address :" + permanentAddress);
    }
}
