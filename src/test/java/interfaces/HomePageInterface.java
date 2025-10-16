package interfaces;

import org.openqa.selenium.By;

public interface HomePageInterface {
    String HOME_URL ="https://demoqa.com";
    By ELEMENT_CARD = By.xpath("//div[@class='card-body']/h5[contains(text(),'Elements')]");
    By BOOKSTORE_APPLICATION = By.xpath("//div[@class='card-body']/h5[contains(text(),'Book Store Application')]");
}
