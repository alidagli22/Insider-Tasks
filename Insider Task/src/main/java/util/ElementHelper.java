package util;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ElementHelper {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    Select select;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    public void goToURL(String text) {
        driver.get(text);
        wait.until(ExpectedConditions.urlToBe(text));
    }

    public void checkUrlContains(String url) {
        wait.until(ExpectedConditions.urlContains(url));
    }

    public void switchWindows(){
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void scroll(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: \"center\",inline: \"start\",behavior: \"instant\"});", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        actions.moveToElement(element).build().perform();
    }

    public WebElement findElement(By by) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        scroll(element);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> findElements(By by) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        scroll(element);
        return driver.findElements(by);
    }

    public void click(By by) {
        findElement(by).click();
    }

    public void clickWithText(By by, String text) {
        boolean check = false;
        for (WebElement elem : findElements(by)) {
            if (elem.getText().equals(text)) {
                elem.click();
                check = true;
                break;
            }
        }
        Assert.assertTrue(check, "No element found on the list!");
    }

    public void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
    }

    public void checkAllElementsText(By by, String text) {
        boolean check = true;
        for (WebElement elem : findElements(by)) {
            if (!elem.getText().contains(text)) {
                System.out.println(elem.getText());
                check = false;
            }
        }
        Assert.assertTrue(check, "Found element in list not equal to text!");
    }

    public void select(By by, String text) {
        select = new Select(findElement(by));
        select.selectByVisibleText(text);
    }

}
