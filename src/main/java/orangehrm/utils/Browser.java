package orangehrm.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
   private static   WebDriver driver;
   public Browser(WebDriver driver)
   {
       this.driver=driver;
   }
   public static WebDriver LaunchBrowser()
   {
       driver=new EdgeDriver();
       return driver;
   }
       public static  void openUrl( )
       {
           driver.get("https://opensource-demo.orangehrmlive.com/");
       }
       public static    void closeBrowser()
       {
           driver.close();
       }



}
