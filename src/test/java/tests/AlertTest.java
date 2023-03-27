package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.globalsqaBank.CustomersListPage;
import pages.globalsqaBank.LoginPage;
import pages.globalsqaBank.ManagerAddNewCustomer;

public class AlertTest extends TestBase {
    Faker faker = new Faker();

    LoginPage loginPage;
    ManagerAddNewCustomer managerAddNewCustomer;
    CustomersListPage customersListPage;

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String postCode = faker.address().zipCode();

    String fullName = firstName + " " + lastName;

    @Test
    public void addNewCustomerTest() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.clickToBankManagerButton();
        managerAddNewCustomer = new ManagerAddNewCustomer(driver);
        managerAddNewCustomer.clickAddCustomerBigButton();
        managerAddNewCustomer.fillData(firstName, lastName, postCode);

        Assert.assertTrue(managerAddNewCustomer.getTextAlert().contains("Customer added successfully with customer id"));

        managerAddNewCustomer.acceptAlert();
        customersListPage = new CustomersListPage(driver);
        customersListPage.clickToCustomersButton();

        customersListPage.getCustomerSearch(firstName);

        String actualResult = customersListPage.getCustomerSearchData();

        Assert.assertTrue(actualResult.contains(fullName));
        Assert.assertTrue(actualResult.contains(postCode));
    }

}
