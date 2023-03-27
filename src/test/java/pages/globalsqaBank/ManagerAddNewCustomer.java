package pages.globalsqaBank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManagerAddNewCustomer {

    WebDriver driver;

    public ManagerAddNewCustomer(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[normalize-space()=\"Add Customer\"]")
    WebElement addCustomerBigButton;

    @FindBy(xpath = "//input[@ng-model=\"fName\"]")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[@ng-model=\"lName\"]")
    WebElement lastNameInput;

    @FindBy(xpath = "//input[@ng-model=\"postCd\"]")
    WebElement postCodeInput;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement addCustomerButton;

    public void clickAddCustomerBigButton() {
        addCustomerBigButton.click();
    }

    public void fillData(String firstName, String lastName, String postCode) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        postCodeInput.clear();
        postCodeInput.sendKeys(postCode);
        addCustomerButton.click();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public String getTextAlert() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }

}
