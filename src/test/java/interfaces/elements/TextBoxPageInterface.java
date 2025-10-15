package interfaces.elements;

import org.openqa.selenium.By;

public interface TextBoxPageInterface {
    By FULL_NAME = By.xpath("//*[@id=\"userName\"]");
    By EMAIL =By.xpath("//*[@id=\"userEmail\"]");
    By CURRENT_ADDR = By.xpath("//*[@id=\"currentAddress\"]");
    By PERMANENT_ADDR = By.xpath("//*[@id=\"permanentAddress\"]");
    By SUBMIT = By.id("submit");

    By OUTPUT         = By.id("output");
    By OUTPUT_NAME    = By.cssSelector("#output #name");
    By OUTPUT_EMAIL   = By.cssSelector("#output #email");
    By OUTPUT_CURR    = By.cssSelector("#output #currentAddress");
    By OUTPUT_PERM    = By.cssSelector("#output #permanentAddress");
}
