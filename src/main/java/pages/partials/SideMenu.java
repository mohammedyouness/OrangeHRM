package pages.partials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class SideMenu extends BasePage {
    // Constructor
    public SideMenu(WebDriver driver) {
        super(driver);
    }
    // Elements Locators
    public By adminOption = By.cssSelector("li a[href$='admin/viewAdminModule']"); // //span[text()='Admin']

    // Actions
    public void NavigateToAdminTab() {
        click(adminOption);
    }

}

