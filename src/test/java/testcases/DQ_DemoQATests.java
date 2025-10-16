package testcases;

import actions.BaseTest;
import actions.HomePageAction;
import actions.bookstore.LoginPageAction;
import actions.elements.ElementsLeftMenuAction;
import actions.elements.TextBoxPageAction;
import actions.elements.CheckBoxPageAction;
import actions.elements.RadioButtonPageAction;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DQ_DemoQATests extends BaseTest {
    //testcase:DQ-TB-001
   @Test
    public void DQ_TB_001_POSITIVE_E2E(){
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
    //testcase:DQ-TB-002
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
    //testcase:DQ-CB-001
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
    //testcase: DQ-CB-002_POSITIVE_PARENT_CASCADE
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

    //testcase:DQ-RB-001_POSITIVE_YES
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

    //login
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
