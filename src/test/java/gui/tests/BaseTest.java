package gui.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.AdminPage;
import pages.BasePage;
import pages.LoginPage;
import pages.partials.SideMenu;

public class BaseTest {
    protected WebDriver driver;
    BasePage basePage;
    LoginPage loginPage;
    SideMenu sideMenu;
    AdminPage adminPage;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*")
                .addArguments("--incognito");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        driver.navigate().to(url);
        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);
        sideMenu = new SideMenu(driver);
        adminPage = new AdminPage(driver);
    }

    @After
    public void tearDown() {
         // driver.quit();
    }
}
