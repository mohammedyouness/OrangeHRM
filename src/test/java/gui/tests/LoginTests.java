package gui.tests;

import org.junit.Assert;
import org.junit.Test;
import utils.JsonManager;

public class LoginTests extends BaseTest{
    JsonManager data = new JsonManager("loginCredentials");
    @Test
    public void loginWithValidCredentials() throws InterruptedException {
        loginPage.login(
                data.getTestData("credentials.username"),
                data.getTestData("credentials.password"));

        Assert.assertEquals(
                basePage.getContent(adminPage.dashboardTitle),
                data.getTestData("content.dashboardTitle"));
    }
}
