package testcases;

import actions.BaseTest;
import actions.HomePageAction;
import actions.elements.ElementsLeftMenuAction;
import actions.elements.TextBoxPageAction;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextBoxCase_001 extends BaseTest {
    @Test
    public void DQ_TB_001(){
        HomePageAction home = new HomePageAction(driver);
        ElementsLeftMenuAction menu = new ElementsLeftMenuAction(driver);
        TextBoxPageAction textBox = new TextBoxPageAction(driver);

        home.openHome();
        home.goToElementsModule();
        menu.openTextBox();
        String name = "Nguyen Van A";
        String email= "user@gmail.com";
        String curr = "12 Nguyen Trai, HN";
        String perm = "34 Le Loi, HCM";

        textBox.fillAll(name,email,curr,perm);
        textBox.Submit();

        Assert.assertTrue(textBox.isOutPutShow(),"Out put block is not visible!");
        Assert.assertTrue(textBox.OutPutName().contains(name));
        Assert.assertTrue(textBox.OutPutEmail().contains(email));
        Assert.assertTrue(textBox.OutPutCurrentAddress() .contains(curr));
        Assert.assertTrue(textBox.OutPutPermanentAddress().contains(perm));
    }
}
