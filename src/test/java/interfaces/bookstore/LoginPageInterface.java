package interfaces.bookstore;

import org.openqa.selenium.By;

public interface LoginPageInterface {
    By username = By.id("userName");
    By password = By.id("password");
    By login = By.id("login");
    By resultLogin = By.xpath("//*[@id=\"name\"]");

}
