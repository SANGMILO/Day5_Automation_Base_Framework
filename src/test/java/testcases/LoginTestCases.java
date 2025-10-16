package testcases;

import actions.BaseTest;
import actions.HomePageAction;
import actions.bookstore.LoginPageAction;
import actions.elements.ElementsLeftMenuAction;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestCases extends BaseTest {
    @Test
    public void LoginTest(){
        HomePageAction home = new HomePageAction(driver);
        ElementsLeftMenuAction menu = new ElementsLeftMenuAction(driver);
        LoginPageAction login = new LoginPageAction(driver);
        home.openHome();
        home.goToBookStore();
        menu.OpenLoginPage();

        String user = "sang@gmail.com";
        String pass= "12345678";

        login.FillLoginForm(user,pass);
        login.loginBtn();
        Assert.assertTrue(login.isOutPut());
    }
}
