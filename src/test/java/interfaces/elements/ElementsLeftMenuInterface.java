package interfaces.elements;

import org.openqa.selenium.By;

public interface ElementsLeftMenuInterface {
    By TEXTBOX_ITEM  = By.xpath("//li[@class='btn btn-light ']/span[contains(text(),'Text Box')]");
    By CHECKBOX_ITEM = By.xpath("//li[@class='btn btn-light ']/span[contains(text(),'Check Box')]");
    By RADIO_ITEM    = By.xpath("//li[@id='item-2']/span[normalize-space()='Radio Button'] | //span[normalize-space()='Radio Button' and ancestor::div[contains(@class,'element-list')]]");
    By LOGIN = By.xpath("(//*[@id=\"item-0\"]/span)[6]");

    By PAGE_TITLE    = By.cssSelector("div.main-header");
}
