package pages;

        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.How;

        import java.util.List;

public class EditPagePage {

    @FindBy(how = How.XPATH, using = "//li[contains(.,'Pages')]")
    private  WebElement allPageMenu;

    @FindBy(how = How.XPATH, using = "//a[@href='post-new.php?post_type=page']")
    private  WebElement addNewPageButton;

    @FindBy(how = How.XPATH, using = "//#title-prompt-text")
    private  WebElement enterTitleInAddPageField;

    @FindBy(how = How.CSS, using = "#tinymce")
    private  WebElement addNewPageContent;

    @FindBy(how = How.CSS, using = "#publish")
    private  WebElement buttonPublish;


    public void pressAddNewPage(){
        addNewPageButton.click();
    }


}
