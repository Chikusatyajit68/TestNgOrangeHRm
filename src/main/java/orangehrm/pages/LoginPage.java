package orangehrm.pages;

import orangehrm.utils.Browser;
import orangehrm.utils.ReadLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class LoginPage {
    private static WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(String locator) throws IOException {
        ReadLocator obj = new ReadLocator("LOCATORS", "ORG");
        String locatorvalue = obj.getlocator(locator);
        By l = By.xpath(locatorvalue);
        WebElement element = driver.findElement(l);
        return element;
    }
    public void SETTEXT(WebElement element, String data)
    {
        element.sendKeys(data);
    }

    public void setTextinUserName() throws IOException {
        WebElement username =this. getElement("UNL");
        SETTEXT(username,"Admin");
    }

    public void setTextinPassword() throws IOException {
        WebElement password =this. getElement("PWL");
        SETTEXT(password,"admin123");
    }

    public void clickOnLoginBtn() throws IOException {
        WebElement loginBtn = this.getElement("LGNBTNL");
        loginBtn.click();
    }


}
