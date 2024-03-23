package gui.tests;

import org.junit.Assert;
import org.junit.Test;
import utils.JsonManager;

public class AdminTests extends BaseTest{
    JsonManager data = new JsonManager("users");
    @Test
    public void verifyAddingANewUserAndCheckingCounterIncrease() throws InterruptedException {
        loginPage.login(data.getTestData("credentials.username"), data.getTestData("credentials.password"));
        sideMenu.NavigateToAdminTab();
        int currentNumOfRecords = basePage.extractNumber(adminPage.numOfRecordsFound);
        // System.out.println(currentNumOfRecords);
        adminPage.addNewUser(
                true,
                data.getTestData("user.employeeName"),
                true,
                data.getTestData("user.username"),
                data.getTestData("user.password"),
                data.getTestData("user.confirmPassword"));
        Assert.assertEquals(++currentNumOfRecords, basePage.extractNumber(adminPage.numOfRecordsFound));
        // System.out.println(currentNumOfRecords);
    }
    @Test
    public void verifyDeletingAnExistingUserAndCheckingCounterDecrease() throws InterruptedException {
        loginPage.login(data.getTestData("credentials.username"), data.getTestData("credentials.password"));
        sideMenu.NavigateToAdminTab();
        int currentNumOfRecords = basePage.extractNumber(adminPage.numOfRecordsFound);
        // System.out.println(currentNumOfRecords);
        adminPage.searchForAUserAndDelete(
                data.getTestData("user.employeeName"),
                data.getTestData("user.username"));

        Assert.assertEquals(--currentNumOfRecords, basePage.extractNumber(adminPage.numOfRecordsFound));
        // System.out.println(currentNumOfRecords);
    }
}
