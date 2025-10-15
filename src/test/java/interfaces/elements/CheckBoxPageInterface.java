package interfaces.elements;

import org.openqa.selenium.By;

public interface CheckBoxPageInterface {
    By EXPAND_ALL     = By.cssSelector("button[title='Expand all']");
    By HOME_LABEL     = By.cssSelector("label[for='tree-node-home']");
    By DESKTOP_LABEL  = By.cssSelector("label[for='tree-node-desktop']");
    By RESULT         = By.id("result");
    By RESULT_TOKENS  = By.cssSelector("#result .text-success");
}
