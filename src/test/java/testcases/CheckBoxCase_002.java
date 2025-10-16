package testcases;

import actions.BaseTest;
import actions.HomePageAction;
import actions.elements.CheckBoxPageAction;
import actions.elements.ElementsLeftMenuAction;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxCase_002 extends BaseTest {
    @Test
    public void DQ_CB_002_POSITIVE_PARENT_CASCADE(){
        HomePageAction home = new HomePageAction(driver);
        ElementsLeftMenuAction menu = new ElementsLeftMenuAction(driver);
        CheckBoxPageAction checkBox = new CheckBoxPageAction(driver);
        home.openHome();
        home.goToElementsModule();
        menu.openCheckBox();

        checkBox.expandAll();
        checkBox.selectHome();

        String outputText = checkBox.getOutputText();
        System.out.println("===> Output hiển thị: " + outputText);

        // Kiểm tra từng phần text hiển thị có đúng không
        Assert.assertTrue(outputText.contains("home"), "Không thấy text 'home' trong output");
        Assert.assertTrue(outputText.contains("desktop"), "Không thấy text 'desktop' trong output");
        Assert.assertTrue(outputText.contains("documents"), "Không thấy text 'documents' trong output");
        Assert.assertTrue(outputText.contains("downloads"), "Không thấy text 'downloads' trong output");
    }
}
