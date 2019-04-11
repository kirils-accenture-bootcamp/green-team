package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class EditPage {
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//li[contains(.,'Pages')]")
    private WebElement allPageMenu;

    @FindBy(how = How.XPATH, using = "//a[@href='post-new.php?post_type=page']")
    private WebElement addNewPageButton;

    @FindBy(how = How.CSS, using = "#title") //#title
    private WebElement enterTitleInAddPageField;

    @FindBy(how = How.CSS, using = "//textarea[@class='wp-editor-area']")
    private WebElement addNewPageContent;

    @FindBy(how = How.CSS, using = "#publish")
    private WebElement buttonPublish;

    @FindBy(how = How.CSS, using = "#yop-poll-shortcode")
    private WebElement shortCode;

    @FindBy(how = How.XPATH, using = "//a[@href='http://192.168.8.112:81/wordpress/ssss/']")
    private WebElement existingPage;

    @FindBy(how = How.CSS, using = "#yop-poll-shortcode")
    private WebElement pageContent;

    @FindBy(how = How.CLASS_NAME, using = "wp-editor-area")
    private WebElement pageContentfield;

    @FindBy(how = How.CSS, using = "#sample-permalink>a")
    private WebElement permalink;
//http://192.168.8.112:81/wordpress/?page_id=608&preview=true

    public void pressPermalink() {
        permalink.click();
    }


    public void pressAddNewPage() {
        addNewPageButton.click();
    }


    public void enterNewPageTitle(String title) {

        enterTitleInAddPageField.clear();
        enterTitleInAddPageField.sendKeys(title);

    }

    //public void copyPasteClipboard() {
    // String data = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
    //addNewPageContent.sendKeys(data);
    //}

    public void pasteShortcode() {
        //driver.switchTo().frame (addNewPageContent);
        // driver.findElement(addNewPageContent).click();

        pageContentfield.sendKeys(Keys.chord(Keys.CONTROL, "v"));


    }

    public void pressPublish() {
        buttonPublish.click();
    }

    public void pressViewPage() {
        existingPage.click();
    }


    public void enterShortcodeToPageContent(String code) {
        addNewPageContent.sendKeys(code);


    }
}
