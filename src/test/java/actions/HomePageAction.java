package actions;

import interfaces.HomePageInterface;
import interfaces.elements.ElementsLeftMenuInterface;
import org.openqa.selenium.WebDriver;

public class HomePageAction extends BasePage_Method_List implements HomePageInterface {
    public HomePageAction(WebDriver driver) { super(driver); }

    public void openHome() { getPageUrl(HOME_URL); }

    public void goToElementsModule() {
        waitForElementClickable(ELEMENT_CARD);
        scrollIntoView(ELEMENT_CARD);
        clickReliable(ELEMENT_CARD);

        // chờ điều hướng thành công
        try { waitUrlContains("/elements"); } catch (Exception ignore) {}
        // hoặc menu trái/tiêu đề render
        waitVisibleAny(
                ElementsLeftMenuInterface.TEXTBOX_ITEM,
                ElementsLeftMenuInterface.CHECKBOX_ITEM,
                ElementsLeftMenuInterface.RADIO_ITEM,
                ElementsLeftMenuInterface.PAGE_TITLE
        );
    }
}
