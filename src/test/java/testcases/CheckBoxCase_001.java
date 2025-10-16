package testcases;

import actions.BaseTest;
import actions.HomePageAction;
import actions.elements.CheckBoxPageAction;
import actions.elements.ElementsLeftMenuAction;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxCase_001 extends BaseTest {
    @Test
    public void DQ_CB_001_POSITIVE_SINGLE(){
        HomePageAction home = new HomePageAction(driver);
        ElementsLeftMenuAction menu = new ElementsLeftMenuAction(driver);
        CheckBoxPageAction checkBox = new CheckBoxPageAction(driver);
        home.openHome();
        home.goToElementsModule();
        menu.openCheckBox();

        checkBox.expandAll();
        checkBox.selectDesktop();

        String result = checkBox.resultTokensJoined();
        Assert.assertTrue(result.contains("Desktop"),"Result should contain 'Desktop'!' "+result);
    }
}
