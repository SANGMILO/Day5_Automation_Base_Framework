package actions.elements;

import actions.BasePage_Method_List;
import interfaces.elements.RadioButtonPageInterface;
import org.openqa.selenium.WebDriver;

public class RadioButtonPageAction extends BasePage_Method_List implements RadioButtonPageInterface {
    public RadioButtonPageAction(WebDriver driver) {
        super(driver);
    }
    public void chooseYes() {
        waitForElementClickable(YES_LABEL);
        scrollIntoView(YES_LABEL);      // dùng helper bạn đã có
        clickReliable(YES_LABEL);       // fallback JS click nếu bị intercept
        waitVisibleAny(RESULT_VALUE);   // chờ kết quả xuất hiện
    }

    // Lấy text kết quả ("Yes" / "Impressive")
    public String selectedValue() {
        waitForElementIsVisible(RESULT_VALUE);
        return getTextElement(RESULT_VALUE).trim();
    }

    // (tuỳ chọn) kiểm tra input Yes đã được chọn chưa
    public boolean isYesChecked() {
        return getElement(YES_INPUT).isSelected();
    }
}
