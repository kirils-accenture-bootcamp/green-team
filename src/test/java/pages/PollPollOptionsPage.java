package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PollPollOptionsPage {

    //New Poll > Options > Poll tab
    //Vote Button fields
    @FindBy(how = How.XPATH, using = "//input[@class='form-control vote-button-label']")
    private WebElement inputVoteButtonLabel;

    public String PollOptionsUrl() {
        return "http://192.168.8.112:81/wordpress/wp-admin/admin.php?page=yop-poll-add-poll#poll-options";
    }
}
