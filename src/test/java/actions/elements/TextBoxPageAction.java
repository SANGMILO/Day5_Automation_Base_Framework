package actions.elements;

import actions.BasePage_Method_List;
import interfaces.HomePageInterface;
import interfaces.elements.TextBoxPageInterface;
import org.openqa.selenium.WebDriver;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

public class TextBoxPageAction extends BasePage_Method_List implements TextBoxPageInterface {
    public TextBoxPageAction(WebDriver driver)
    {
        super(driver);
    }
    public void fillAll(String name, String email, String current, String perm){
        enterTextToElement(FULL_NAME, name);
        enterTextToElement(EMAIL, email);
        enterTextToElement(CURRENT_ADDR, current);
        enterTextToElement(PERMANENT_ADDR, perm);
    }
    public void Submit(){
        dismissStickyOverlaysIfAny();
        scrollIntoView(SUBMIT);
        clickSmart(SUBMIT);                 // ✅ dùng click có retry + JS fallback
        waitForElementIsVisible(OUTPUT); // chờ khối output xuất hiện
    }
    public boolean isOutPutShow(){
        return isDisplayElement(OUTPUT);
    }
    public String OutPutName(){
        return getTextElement(OUTPUT_NAME);
    }
    public String OutPutEmail(){
        return getTextElement(OUTPUT_EMAIL);
    }
    public String OutPutCurrentAddress(){
        return getTextElement(OUTPUT_CURR);
    }
    public String OutPutPermanentAddress(){
        return getTextElement(OUTPUT_PERM);
    }
    public boolean isMailFailInvalid(){
        String cls = getElement(EMAIL).getAttribute("class");
        String aria = getElement(EMAIL).getAttribute("aria-invalid");
        String bdc = getElement(EMAIL).getAttribute("border-color");
        boolean ByClass = cls!=null && (cls.contains("is-invalid") || cls.contains("field-error"));
        boolean ByAria = "true".equalsIgnoreCase(aria);
        boolean ByColor = bdc!=null && bdc.startsWith("rgb(220, 53, 69)");

        return ByClass || ByAria || ByColor;
    }
}
