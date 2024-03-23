package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Elements Locators
    public By emailField = By.name("username");
    public By passwordField = By.name("password");
    public By loginBtn = By.cssSelector("button.orangehrm-login-button");


    // Actions
    public void setUsername(String username) {
        setText(emailField, username);
    }
    public void setPassword(String password){
        setText(passwordField, password);
    }
    public void  clickOnLogin() {
        click(loginBtn);
    }
     public void login(String username, String password) {
         setText(emailField, username);
         setText(passwordField, password);
         click(loginBtn);
    }

}
