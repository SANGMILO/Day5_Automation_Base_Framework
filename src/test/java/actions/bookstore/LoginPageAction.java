package actions.bookstore;

import actions.BasePage_Method_List;
import interfaces.bookstore.LoginPageInterface;
import org.openqa.selenium.WebDriver;

public class LoginPageAction extends BasePage_Method_List implements LoginPageInterface {
    public  LoginPageAction(WebDriver driver)
    {
        super(driver);
    }
    public void FillLoginForm(String user, String pass)
    {
        enterTextToElement(username, user);
        enterTextToElement(password, pass);
    }
    public void loginBtn(){
        dismissStickyOverlaysIfAny();
        scrollIntoView(login);
        clickSmart(login);
    }
    public boolean isOutPut(){
        return isDisplayElement(resultLogin);
    }
}
