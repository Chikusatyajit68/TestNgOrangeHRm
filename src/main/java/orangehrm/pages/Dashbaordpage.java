package orangehrm.pages;

import orangehrm.utils.ReadLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Dashbaordpage {
  private WebDriver driver;
  public  Dashbaordpage(WebDriver driver)
  {
      this.driver=driver;
  }
  public WebElement getElement(String locator) throws IOException {
      ReadLocator readLocator=new ReadLocator("LOCATORS","ORG");
      String locatorValue=   readLocator.getlocator(locator);
      By L= By.xpath(locatorValue);
       WebElement element=  driver.findElement(L);
       return element;
  }
  public boolean isdashBoardvisible() throws IOException {
    WebElement dashboardpage      = getElement("DBL");

      return dashboardpage.isDisplayed();
  }
  public void clickonAdmin() throws IOException {
   WebElement admin  = this.getElement("ADML");
   admin.click();
  }
  public  boolean  isuserManagementvisible() throws IOException {
      WebElement usermanagement=this.getElement("UML");
     return usermanagement.isDisplayed();
  }
  public void clickonAdd() throws IOException {
     WebElement add =this.getElement("ADDL");
     add.click();
  }
  public  boolean   isadminPageVisible() throws IOException {
   WebElement adminpage  = this.getElement("ADMINL");
     return   adminpage.isDisplayed();
  }
  public String GetText(WebElement element)
  {
    return   element.getText();
  }
  public String getAttribute(WebElement element) throws IOException {

return     element.getAttribute("innerHTML");
  }
  public void clickOnSave() throws IOException {

      WebElement  save = this.getElement("SAVEBTNL");

      save.click();

  }


}
