package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ViewAllPollPage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class KTViewAllPoll {
    private WebDriver driver;
    private ViewAllPollPage viewAllPollPage;

    public KTViewAllPoll() {
        this.driver = Hooks.driver;
        viewAllPollPage = PageFactory.initElements(Hooks.driver, ViewAllPollPage.class);
    }

    @And("^I click All Polls link under Yop Poll section$")
    public void iClickAllPollsLinkUnderYopPollSection() throws Throwable {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[.='Yop Poll']"))).perform();
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10)
                .ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.='All Polls']")));
        driver.findElement(By.xpath("//a[.='All Polls']")).click();
    }

    @When("^I click ([^\"]+) column$")
    public void iClickColumn(String name) throws Throwable {
        viewAllPollPage.clickColumnByName(name);
    }

    @When("^I enter ([^\"]*) in the search field$")
    public void iEnterInTheSearchField(String line) throws Throwable {
        viewAllPollPage.enterPollSearchInput(line);
    }

    @And("^I press ENTER key in the search field$")
    public void iPressENTERKeyInTheSearchField() throws Throwable {
        viewAllPollPage.pressEnterPollSearchInput();
    }

    @When("^I click ([^\"]+) filter link$")
    public void iClickFilterLink(String name) throws Throwable {
        viewAllPollPage.clickFilterLinkByName(name);
    }

    @When("^I click ([^\"]+) on poll at (\\d+)$")
    public void iClickLinkOnPollAtIndex(String name, int index) throws Throwable {
        viewAllPollPage.hoverClickByPollLinkName(name, index, new Actions(driver));
    }

    @When("^I select polls at ([^\"]*)$")
    public void iSelectPollsAtIndexes(String indexes) throws Throwable {
        viewAllPollPage.selectMultiplePolls(indexes, true);
    }

    @When("^I deselect polls at ([^\"]*)$")
    public void iDeselectPollsAtIndexes(String indexes) throws Throwable {
        viewAllPollPage.selectMultiplePolls(indexes, false);
    }

    @And("^I select ([^\"]+) option in bulk action selection$")
    public void iSelectOptionInBulkActionSelection(String option) throws Throwable {
        viewAllPollPage.selectBulkActionSelect(option);
    }

    @And("^I click ([^\"]+) button$")
    public void iClickButton(String name) throws Throwable {
        viewAllPollPage.clickBtnByName(name);
    }

    @Then("^I open Create Poll page$")
    public void iOpenCreatePollPage() throws Throwable {
        assertEquals("http://192.168.8.112:81/wordpress/wp-admin/admin.php?page=yop-poll-add-poll",
                driver.getCurrentUrl());
    }

    @And("^I click select all checkbox$")
    public void iClickSelectAllCheckbox() throws Throwable {
        viewAllPollPage.clickSelectAllPollsCheckbox();
    }

    @When("^I enter (\\d+) in Items Per Page field$")
    public void iEnterInItemsPerPageField(String input) throws Throwable {
        viewAllPollPage.enterItemsPerPageField(input);
    }

    @Then("^I see numbers on corresponding filters$")
    public void iSeeNumbersOnCorrespondingFilters(Map<String, Integer> counts) throws Throwable {
        counts.forEach((k, v) -> viewAllPollPage.checkFilterCountByName(k, v));
    }

    @And("^I remember the polls$")
    public void iRememberThePolls() throws Throwable {
        viewAllPollPage.rememberCurrentPollListOnPage();
    }

    @Then("^I see polls are sorted by ([^\"]+) in ([^\"]+) order$")
    public void iSeePollsAreSortedInAscendingOrder(String columnName, String order) throws Throwable {
        viewAllPollPage.checkPollSortedOnPage(columnName, order);
    }

    @Given("^I populate polls$")
    public void iPopulatePolls(List<String> pollValuesList) throws Throwable {
        for (String pollValues : pollValuesList) {
            driver.get("http://192.168.8.112:81/wordpress/wp-admin/admin.php?page=yop-poll-add-poll");
            String[] pollValue = pollValues.split("; ");
            driver.findElement(By.id("title")).sendKeys(pollValue[0]);
            if (pollValue[1].equals("Draft")) {
                driver.findElement(By.className("edit-poll-status")).click();
                (new Select(driver.findElement(By.id("poll_status")))).selectByValue("draft");
                driver.findElement(By.className("save-poll-status")).click();
            } else if (!pollValue[1].equals("Published")) {
                throw new InvalidArgumentException("Invalid status");
            }
            driver.findElement(By.id("publish")).click();
            driver.findElement(By.xpath("//a[contains(., 'Options')]")).click();
            driver.findElement(By.id("select2-7gr8-container")).click();
            driver.findElement(By.id("select2-7gr8-result-vs2i-custom")).click();
            driver.findElement(By.cssSelector(".start-date-section .fa-calendar")).click();
            WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
            Calendar now = Calendar.getInstance();
            Calendar startDate = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("MMMMM d, yyyy h:mm a");
            Date date = sdf.parse(pollValue[2].replace("AM", "am").replace("PM","pm"));
            startDate.setTime(date);
            int timesToClick = (now.get(Calendar.YEAR) - startDate.get(Calendar.YEAR)) * 12 +
                    (now.get(Calendar.MONTH) - startDate.get(Calendar.MONTH));
            boolean past = true;
            if (timesToClick < 0){
                past = false;
                timesToClick *= -1;
            }
            for (int i = 0; i < timesToClick; i++) {
                if (past){
                    dateWidget.findElement(By.className("ui-datepicker-prev")).click();
                } else {
                    dateWidget.findElement(By.className("ui-datepicker-next")).click();
                }
            }
            dateWidget.findElement(By.xpath("//a[text()='" + startDate.get(Calendar.DAY_OF_MONTH) + "']")).click();
            Select hourSelect = new Select(dateWidget.findElement(By.cssSelector(".ui_tpicker_hour .ui-timepicker-select")));
            int hourInt = startDate.get(Calendar.HOUR_OF_DAY);
            String hour;
            if (hourInt < 10){
                hour = "0" + Integer.toString(hourInt);
            } else {
                hour = Integer.toString(hourInt);
            }
            hourSelect.selectByVisibleText(hour);
            Select minSelect = new Select(dateWidget.findElement(By.cssSelector(".ui_tpicker_minute .ui-timepicker-select")));
            int minInt = startDate.get(Calendar.MINUTE);
            String min;
            if (hourInt < 10){
                min = "0" + Integer.toString(minInt);
            } else {
                min = Integer.toString(minInt);
            }
            minSelect.selectByVisibleText(min);
            // TODO complete
            driver.findElement(By.xpath("//a[contains(., 'Access')]")).click();
            driver.findElement(By.cssSelector(".content-options-access .form-group:nth-child(1) .select2-search__field")).sendKeys("Guest" + Keys.ENTER);
            driver.findElement(By.xpath("//a[contains(., 'Results')]")).click();
            driver.findElement(By.cssSelector(".poll-results-options .form-group:nth-child(1) .select2-search__field")).sendKeys("Never" + Keys.ENTER);
            driver.findElement(By.id("publish-poll")).click();
        }
    }
}
