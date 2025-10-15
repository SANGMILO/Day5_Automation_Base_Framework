package actions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage_Method_List {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage_Method_List(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.actions = new Actions(driver);
    }

    //1. getXpath
    public By getXpath(String xpath){
        return By.xpath(xpath);
    }

    //2. getDynamicXpath
    public By getDynamicXpath(String pattern,String... params){
        return By.xpath(String.format(pattern,(Object[])params));
    }

    //3. getElement
    public WebElement getElement(By locator){
        return driver.findElement(locator);
    }

    //4. getElements
    public List<WebElement> getElements(By locator){
        return driver.findElements(locator);
    }

    //5. getElements (params)
    public List<WebElement> getElements(String pattern, String... params){
        return driver.findElements(getDynamicXpath(pattern,params));
    }

    //6. getDynamicLocator
    public String getDynamicLocator(String pattern, String... params){
        return String.format(pattern,(Object[])params);
    }

    //7. getDynamicElement
    public WebElement getDynamicElement(String pattern, String... params){
        return driver.findElement(getDynamicXpath(pattern,params));
    }

    //8. clickToElement
    public void clickToElement(By locator){
        getElement(locator).click();
    }

    //9. clickToElement (params)
    public void clickToElement(String pattern, String... params){
        getDynamicElement(pattern,params).click();
    }

    //10. enterTextToElement
    public void enterTextToElement(By locator, String value){
        WebElement element = getElement(locator);
        element.clear();
        element.sendKeys(value);
    }

    //11. enterTextToElement (params)
    public void enterTextToElement(String pattern, String value, String... params){
        WebElement element = getDynamicElement(pattern,params);
        element.clear();
        element.sendKeys(value);
    }

    //12. enterTextToElementUsingActions
    public void enterTextToElementUsingActions(By locator, String value){
        actions.sendKeys(getElement(locator),value).perform();
    }

    //13. enterTextToElementUsingActions (params)
    public void enterTextToElementUsingActions(String pattern, String value, String... params){
        actions.sendKeys(getDynamicElement(pattern,params),value).perform();
    }

    //14. clickToElementByJS
    public  void clickToElementByJS(By locator){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", getElement(locator));
    }

    //15. waitForElementIsVisible
    public void waitForElementIsVisible(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //16. waitForElementIsVisible (params)
    public void waitForElementIsVisible(String pattern, String... params){
        wait.until(ExpectedConditions.visibilityOfElementLocated(getDynamicXpath(pattern,params)));
    }

    //17. waitForElementClickable
    public void waitForElementClickable(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    //18. waitForElementClickable (params)
    public void waitForElementClickable(String pattern, String... params){
        wait.until(ExpectedConditions.elementToBeClickable(getDynamicXpath(pattern,params)));
    }

    //19. highLightElement
    public void highlightElement(By locator){
        WebElement element = getElement(locator);
        String style = element.getAttribute("style");
        ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style',arguments[1]);)",element,style);
    }

    //20. highLightElement (params)
    public void highlightElement(String pattern, String... params){
        highlightElement(getDynamicXpath(pattern,params));
    }

    //21. SleepInSecond
    public void SleepInSeconds(long seconds){
        try {
            Thread.sleep(seconds*1000L);
        } catch (InterruptedException ignored) {}
    }

    //22. hoverToElement
    public void hoverOverElement(By locator){
        actions.moveToElement(getElement(locator)).perform();
    }

    //23. hoverToElement (params)
    public void hoverOverElement(String pattern, String... params){
        actions.moveToElement(getDynamicElement(pattern,params)).perform();
    }

    //24. rightClickOnElement
    public void rightClickOnElement(By locator){
        actions.contextClick(getElement(locator)).perform();
    }

    //25. rightClickOnElement (params)
    public void rightClickOnElement(String pattern, String... params){
        actions.contextClick(getDynamicElement(pattern,params)).perform();
    }

    //26. doubleClickOnElement
    public void doubleClickOnElement(By locator){
        actions.doubleClick(getElement(locator)).perform();
    }

    //27. doubleClickOnElement (params)
    public void doubleClickOnElement(String pattern, String... params){
        actions.doubleClick(getDynamicElement(pattern,params)).perform();
    }

    //28. dragAndDropElement
    public void dragAndDropElement(By source, By target){
        actions.dragAndDrop(getElement(source),getElement(target)).perform();
    }

    //29. pressKeyToElement
    public void pressKeyToElement(By locator, Keys key){
        getElement(locator).sendKeys(key);
    }

    //30. pressKeyToElement (params)
    public void pressKeyToElement(String pattern, Keys key, String... params){
        getDynamicElement(pattern,params).sendKeys(key);
    }

    //31. getTextElement
    public String getTextElement(By locator){
        return getElement(locator).getText();
    }

    //32. getTextElement (params)
    public String getTextElement(String pattern, String... params){
        return getDynamicElement(pattern,params).getText();
    }

    //33. getElementAttributeValue
    public String getElementAttributeValue(By locator, String attribute){
        return getElement(locator).getAttribute(attribute);
    }

    //34. getElementAttributeValue (params)
    public String getElementAttributeValue(String pattern,String attribute, String... params){
        return getDynamicElement(pattern,params).getAttribute(attribute);
    }

    //35. getListElementSize
    public int getListElementSize(By locator){
        return getElements(locator).size();
    }

    //36. getListElementSize (params)
    public int getListElementSize(String pattern, String... params){
        return getElements(pattern,params).size();
    }

    //37. isDisplayElement
    public boolean isDisplayElement(By locator){
        try{
            return getElement(locator).isDisplayed();
        }catch (Exception e ){
            return false;
        }
    }

    //38. isDisplayElement (params)
    public boolean isDisplayElement(String pattern, String... params){
        try{
            return getDynamicElement(pattern,params).isDisplayed();
        }catch (Exception e ){
            return false;
        }
    }

    //39. isDisplayElements
    public boolean isDisplayElements(By locator){
        List<WebElement> list = getElements(locator);
        return !list.isEmpty() && list.stream().allMatch(WebElement::isDisplayed);
    }

    //40. isDisplayElements (params)
    public boolean isDisplayElements(String pattern, String... params){
        List<WebElement> list = getElements(pattern,params);
        return !list.isEmpty() && list.stream().allMatch(WebElement::isDisplayed);
    }

    //41. getPageUrl
    public  void getPageUrl(String url){
        driver.get(url);
    }

    //42. getPageTitle
    public String  getPageTitle(){
        return driver.getTitle();
    }

    //43. getPageSourceCode
    public String getPageSourceCode(){
       return driver.getPageSource();
    }

    //44. getCurrentUrl
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    //45. backToPage
    public void backToPage(){
        driver.navigate().back();
    }

    //46. forwardToPage
    public void forwardToPage(){
        driver.navigate().forward();
    }

    //47. refreshPage
    public void refreshPage(){
        driver.navigate().refresh();
    }

    //48. waitForAlertPresence
    public Alert waitForAlertPresence(){
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    //49. acceptAlert
    public void acceptAlert(){
        waitForAlertPresence().accept();
    }

    //50. cancelAlert
    public void  cancelAlert(){
        waitForAlertPresence().dismiss();
    }

    //51. getTextAlert
    public String getTextAlert(){
        return waitForAlertPresence().getText();
    }

    //52. enterTextToAlert
    public void enterTextToAlert(String text){
        waitForAlertPresence().sendKeys(text);
    }

    //53. switchWindowByID
    public void switchWindowByID(String parentID){
        Set<String> ID = driver.getWindowHandles();
        for(String id : ID){
            if(!id.equals(parentID)){
                driver.switchTo().window(id);
                break;
            }
        }
    }
    //54. switchWindowByTitle
    public void switchWindowByTitle(String expectedTitle){
        for(String id : driver.getWindowHandles()){
            driver.switchTo().window(id);
            if(driver.getTitle().equals(expectedTitle)){
                return;
            }
        }
    }

    //55. closeAllWindowsWithoutParent
    public void closeAllWindowsWithoutParent(String parentID){
        for(String id : driver.getWindowHandles()){
            if(!id.equals(parentID)){
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    //56. selectItemInDefaultDropdown
    public void selectItemInDefaultDropdown(By locator, String text){
        new Select(getElement(locator)).selectByVisibleText(text);
    }

    //57. selectItemInDefaultDropdown (params)
    public void selectItemInDefaultDropdown(String pattern, String text, String... params){
        new Select(getDynamicElement(pattern,text)).selectByVisibleText(text);
    }

    //58. getFirstSelectedTextItem
    public String getFirstSelectedTextItem(By locator){
        return new Select(getElement(locator)).getFirstSelectedOption().getText();
    }

    //59. getFirstSelectedTextItem (params)
    public String getFirstSelectedTextItem(String pattern, String... params){
        return new Select(getDynamicElement(pattern,params)).getFirstSelectedOption().getText();
    }

    //60. isDropdownMultiple
    public boolean isDropdownMultiple(By locator){
        return new Select(getElement(locator)).isMultiple();
    }

    //61. isDropdownMultiple (params)
    public boolean isDropdownMultiple(String pattern, String... params){
        return new Select(getDynamicElement(pattern,params)).isMultiple();
    }

    //62. checkToCheckboxOrRadio
    public void checkToCheckboxOrRadio(By locator){
        WebElement e = getElement(locator);
        if(!e.isSelected()){
            e.click();
        }
    }

    //63. checkToCheckboxOrRadio (params)
    public void checkToCheckboxOrRadio(String pattern, String... params){
        WebElement e = getDynamicElement(pattern,params);
        if(!e.isSelected()){
            e.click();
        }
    }

    //64. unCheckToCheckbox
    public void unCheckToCheckbox(By locator){
        WebElement e = getElement(locator);
        if(e.isSelected()){
            e.click();
        }
    }

    //65. unCheckToCheckbox (params)
    public void unCheckToCheckbox(String pattern, String... params){
        WebElement e = getDynamicElement(pattern,params);
        if(!e.isSelected()){
            e.click();
        }
    }

    //66. setImplicitTime
    public void setImplicitTime(long seconds){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    //67. switchToFrame
    public void switchToFrame(By locator){
        driver.switchTo().frame(getElement(locator));
    }

    //68. switchToDefaultContent
    public void switchToDefaultContent(){
        driver.switchTo().defaultContent();
    }

    //69.ScrollInToView
    public void scrollIntoView(By locator) {
        WebElement el = getElement(locator);
        try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block:'center', inline:'center'});", el
            );
        } catch (JavascriptException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
        }
    }

    //70. clickReliable
    public void clickReliable(By locator) {
        try {
            waitForElementClickable(locator);
            scrollIntoView(locator);
            clickToElement(locator);
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(locator));
        }
    }

    //71. waitUrlContains
    public void waitUrlContains(String fragment) {
        wait.until(ExpectedConditions.urlContains(fragment));
    }

    //72. waitVisibleAny
    public void waitVisibleAny(By... locators) {
        wait.until(d -> {
            for (By by : locators) {
                try {
                    List<WebElement> found = d.findElements(by);
                    if (!found.isEmpty() && found.get(0).isDisplayed()) return true;
                } catch (Exception ignore) {}
            }
            return false;
        });
    }
    //73. BasePage_Method_List.java
    public void dismissStickyOverlaysIfAny() {
        try {
            String js =
                    "var ids=['fixedban','adplus-anchor'];" +
                            "ids.forEach(function(id){var el=document.getElementById(id); if(el){el.remove();}});" +
                            "var els=document.querySelectorAll('[style*=\"position: fixed\"], .fc-consent-root');" + // chốt thêm fixed/consent
                            "els.forEach(function(e){try{e.remove();}catch(ex){}});";
            ((JavascriptExecutor) driver).executeScript(js);
        } catch (Exception ignore) {}
    }

    //74. BasePage_Method_List.java
    public void clickSmart(By locator) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                waitForElementClickable(locator);
                scrollIntoView(locator);
                try {
                    // di chuột tới tâm phần tử để tránh bị bar che
                    new Actions(driver).moveToElement(getElement(locator)).pause(Duration.ofMillis(100)).perform();
                } catch (Exception ignore) {}

                clickToElement(locator); // click chuẩn
                return; // thành công -> thoát
            } catch (org.openqa.selenium.ElementClickInterceptedException e) {
                // bị che -> dọn overlay rồi thử lại
                dismissStickyOverlaysIfAny();

                // thử click JS như “bùa thoát hiểm”
                try {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(locator));
                    return;
                } catch (Exception ignore) {}

                attempts++;
                if (attempts >= 3) throw e; // hết retry -> ném lại
            } catch (Exception e) {
                // lỗi khác: thử JS 1 lần
                try {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(locator));
                    return;
                } catch (Exception ignore) {}
                throw e;
            }
        }
    }
}
