package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;


    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitElement(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitElementToBeClickable(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitElementToBePresent(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public WebElement find(By locator) {
        waitElement(locator);
        highlightElement(locator);
        return driver.findElement(locator);
    }
    public void setText(By locator, String data)  {
        find(locator).sendKeys(data);

    }
    public void pressingArrowDownThenEnter(){
        actions = new Actions(driver);
        actions.keyDown(Keys.ARROW_DOWN).perform();
        actions.keyDown(Keys.ENTER).perform();
    }
    public void enterTextFollowedByKeystrokes(By locator, String data) throws InterruptedException {
        find(locator).sendKeys(data);
        // for debugging purposes only, it's not recommended at all using Thread.sleep()
        // Thread.sleep(2000);
        pressingArrowDownThenEnter();
    }
    public void click(By locator) {
        waitElement(locator);
        waitElementToBeClickable(locator);
        find(locator).click();
    }
    public void selectDataByText(By locator, String text) {
        Select select;
        select = new Select(find(locator));
        select.selectByVisibleText(text);
    }
    public String getContent(By locator) {
        waitElement(locator);
        return find(locator).getText();
    }

    public void highlightElement(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].style.border='2px solid fuchsia'", element);
    }

    public int extractNumber(By locator) {
        // Define the pattern to match numbers
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(getContent(locator));

        // Check if a number is found and return it
        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        } else {
            // throw new NotFoundException();
            return -1;
        }
    }
}
