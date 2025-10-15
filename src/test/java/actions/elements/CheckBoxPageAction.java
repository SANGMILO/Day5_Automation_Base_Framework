package actions.elements;

import actions.BasePage_Method_List;
import interfaces.elements.CheckBoxPageInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class CheckBoxPageAction extends BasePage_Method_List implements CheckBoxPageInterface {
    public CheckBoxPageAction(WebDriver driver) {
        super(driver);
    }
    public void expandAll() {
        clickToElement(EXPAND_ALL);
    }
    public void selectDesktop(){
        clickToElement(DESKTOP_LABEL);
    }
    public void selectHome(){
        clickToElement(HOME_LABEL);
    }
    public String getOutputText() {
        By output = By.xpath("//*[@id='result']");
        waitForElementIsVisible(output);
        return getTextElement(output);
    }
    public  String resultTokensJoined(){
        if(!isDisplayElement(RESULT)) return "";
        List<WebElement> tokens  = getElements(RESULT);
        return  tokens.stream().map(WebElement::getText).collect(Collectors.joining(",")).toLowerCase();
    }

}
