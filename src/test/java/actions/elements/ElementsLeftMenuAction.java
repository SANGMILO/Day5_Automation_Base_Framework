package actions.elements;

import actions.BasePage_Method_List;
import interfaces.bookstore.LoginPageInterface;
import interfaces.elements.CheckBoxPageInterface;
import interfaces.elements.ElementsLeftMenuInterface;
import interfaces.elements.RadioButtonPageInterface;
import interfaces.elements.TextBoxPageInterface;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class ElementsLeftMenuAction extends BasePage_Method_List implements ElementsLeftMenuInterface {
    public ElementsLeftMenuAction(WebDriver driver) { super(driver); }

    public void openTextBox() {
        waitForElementIsVisible(TEXTBOX_ITEM);
        scrollIntoView(TEXTBOX_ITEM);
        clickReliable(TEXTBOX_ITEM);
        try { waitUrlContains("/text-box"); } catch (Exception ignore) {}
        waitVisibleAny(TextBoxPageInterface.SUBMIT, PAGE_TITLE);
    }

    public void openCheckBox() {
        waitForElementIsVisible(CHECKBOX_ITEM);
        scrollIntoView(CHECKBOX_ITEM);
        clickReliable(CHECKBOX_ITEM);
        try { waitUrlContains("/checkbox"); } catch (Exception ignore) {}
        waitVisibleAny(CheckBoxPageInterface.EXPAND_ALL, PAGE_TITLE);
    }

    //  Sửa ở đây: chờ YES_LABEL (có sẵn khi trang mở), KHÔNG chờ RESULT_VALUE
    public void openRadioButton() {
        waitForElementIsVisible(RADIO_ITEM);
        scrollIntoView(RADIO_ITEM);
        clickReliable(RADIO_ITEM);

        // 2) Chờ URL fragment; nếu không có -> fallback mở URL trực tiếp
        boolean navigated = true;
        try {
            waitUrlContains("/radio-button");
        } catch (TimeoutException ex) {
            navigated = false;
        }

        if (!navigated) {
            System.out.println("[openRadioButton] URL chưa đổi sau click. Fallback mở thẳng URL...");
            getPageUrl("https://demoqa.com/radio-button");
        }

        // 3) Chờ dấu hiệu trang Radio Button đã sẵn sàng
        waitVisibleAny(
                RadioButtonPageInterface.YES_LABEL, // label Yes luôn có khi trang đã vào
                PAGE_TITLE                          // header "Radio Button" (phụ)
        );

        System.out.println("[openRadioButton] URL hiện tại: " + getCurrentUrl());
    }
    public void OpenLoginPage(){
        waitForElementIsVisible(LOGIN);
        scrollIntoView(LOGIN);
        clickReliable(LOGIN);
        boolean navigated = true;
        try {
            waitUrlContains("/login");
        } catch (TimeoutException ex) {
            navigated = false;
        }

        if (!navigated) {
            System.out.println("[OpenLoginPage] URL chưa đổi sau click. Fallback mở thẳng URL...");
            getPageUrl("https://demoqa.com/login");
        }

        waitVisibleAny(
                LoginPageInterface.login, // label Yes luôn có khi trang đã vào
                PAGE_TITLE                          // header "Radio Button" (phụ)
        );

        System.out.println("[OpenLoginPage] URL hiện tại: " + getCurrentUrl());
    }
}
