package pages.samplepagetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SamplePage {
    WebDriver driver;

    public SamplePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//select[@name=\"g2599-experienceinyears\"]")
    WebElement selectInput;



    public void selectValue(String value) {
        Select select = new Select(driver.findElement(By.name("g2599-experienceinyears")));
        select.selectByVisibleText(value);
    }
}
