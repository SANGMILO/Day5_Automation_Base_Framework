package interfaces.elements;

import org.openqa.selenium.By;

public interface RadioButtonPageInterface {
//    By YES_LABEL     = By.xpath("//*[@id=\"yesRadio\"]");
//    By RESULT_VALUE  = By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/p");

    By YES_LABEL   = By.cssSelector("label[for='yesRadio']");
    By YES_INPUT   = By.id("yesRadio");

    // Kết quả hiển thị: You have selected Yes → span.text-success = "Yes"
    By RESULT_VALUE = By.cssSelector("span.text-success");
}
