package stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class Hooks {
    public static WebDriver driver;
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";

    @Before
    public void openBrowser() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();

        driver.get("http://192.168.8.112:81/wordpress/wp-login.php");
        driver.findElement(By.id("user_login")).sendKeys("gt");
        driver.findElement(By.id("user_pass")).sendKeys("gt1234");
        driver.findElement(By.id("wp-submit")).click();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[.='Yop Poll']"))).perform();
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10)
                .ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.='All Polls']")));
        driver.findElement(By.xpath("//a[.='All Polls']")).click();
        driver.findElement(By.id("cb-select-all-1")).click();

        if (driver.findElements(By.cssSelector("tbody > tr")).size() != 0){
            Select bulkActionSelect = new Select(driver.findElement(By.className("bulk-action-top")));
            bulkActionSelect.selectByValue("trash");
            driver.findElement(By.cssSelector("input[value='Apply']")).click();
        }
    }

    @After
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }
        driver.quit();
    }
}