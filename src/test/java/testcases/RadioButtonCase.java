package testcases;

import actions.BaseTest;
import actions.HomePageAction;
import actions.elements.ElementsLeftMenuAction;
import actions.elements.RadioButtonPageAction;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonCase extends BaseTest {
    @Test
    public void DQ_RB_001_POSITIVE_YES(){
        HomePageAction home = new HomePageAction(driver);
        ElementsLeftMenuAction menu = new ElementsLeftMenuAction(driver);
        RadioButtonPageAction rb = new RadioButtonPageAction(driver);

        home.openHome();
        home.goToElementsModule();
        menu.openRadioButton();

        rb.chooseYes();
        Assert.assertEquals(rb.selectedValue(), "Yes", "Kết quả hiển thị không đúng!");
    }
}
