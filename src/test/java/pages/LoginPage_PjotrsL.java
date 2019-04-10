package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage_PjotrsL {

    @FindBy(how = How.ID, using = "user_login")
    private WebElement inputLogin;
    @FindBy(how = How.ID, using = "user_pass")
    private WebElement inputPassword;
    @FindBy(how = How.ID, using = "wp-submit")
    private WebElement btnLogin;

    public void LoginAsAdmin() {
        inputLogin.sendKeys("gt");
        inputPassword.sendKeys("gt1234");
        btnLogin.click();
    }

}
