package testcases;

import actions.BaseTest;
import actions.HomePageAction;
import actions.elements.ElementsLeftMenuAction;
import actions.elements.TextBoxPageAction;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextBoxCase_002 extends BaseTest {
    @Test
    public void DQ_TB_002_NEGATIVE_EMAIL(){
        HomePageAction home = new HomePageAction(driver);
        ElementsLeftMenuAction menu = new ElementsLeftMenuAction(driver);
        TextBoxPageAction textBox = new TextBoxPageAction(driver);
        home.openHome();
        home.goToElementsModule();
        menu.openTextBox();

        textBox.fillAll("Nguyen Van A","user@","12 Nguyen Trai","34 Le Loi");
        textBox.Submit();

        Assert.assertTrue(textBox.isMailFailInvalid(),"Email filed should be invalid!");
        if(textBox.isOutPutShow()){
            Assert.assertTrue(textBox.OutPutEmail().contains("user@"),"Out put must not contain invalid email!");
        }
    }
}
