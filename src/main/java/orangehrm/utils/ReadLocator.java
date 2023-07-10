package orangehrm.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadLocator {
 public   FileInputStream inputStream;
 public Properties properties;
 public ReadLocator(String folder,String file) throws IOException {
     String filepath=".//"+folder+"//"+file+".properties";
      inputStream=new FileInputStream(filepath);
      properties=new Properties();
      properties.load(inputStream);
 }
 public String getlocator (String locator)
 {
   return   properties.getProperty(locator);
 }



}
