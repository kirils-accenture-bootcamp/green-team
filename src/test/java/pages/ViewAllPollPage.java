package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ViewAllPollPage {
    @FindBy(how = How.XPATH, using = "//i[@class='fa fa-code']")
    private List<WebElement> codeList;

    @FindBy(how = How.CSS, using = "#yop-poll")
    private  WebElement buttonCopyToClipBoard;


}
