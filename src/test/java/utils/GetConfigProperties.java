package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

 public class GetConfigProperties {

     public Properties readConfigFile(){

         Properties property = new Properties();

         String currentUsersWorkingDir = System.getProperty("user.dir");
         System.out.println("Dir is " + currentUsersWorkingDir);

         FileInputStream inputStream;
         try {
             inputStream = new FileInputStream
                     (currentUsersWorkingDir + "/src/test/resources/config.properties");

             property.load(inputStream);

             System.out.println("url is: " + property.getProperty("url"));
             System.out.println("browser is: " + property.getProperty("browser"));

         }
         catch (Exception e) {
             e.printStackTrace();
         }

         return property;
     }

     public WebDriver getDriver() {

         String currentUsersWorkingDir = System.getProperty("user.dir");
         System.out.println("Dir is " + currentUsersWorkingDir);

         try {
             Properties property = readConfigFile();
             String browser = property.getProperty("browser");


             if (browser.equalsIgnoreCase("firefox")) {
                 return new FirefoxDriver();
             } else if (browser.equalsIgnoreCase("chrome")) {

                 System.setProperty("webdriver.chrome.driver", currentUsersWorkingDir + "/src/test/resources/chromedriver");
                 return new ChromeDriver();
             }
         } catch (Exception e) {
             System.out.println(" there was an error reading the config file");
             e.printStackTrace();
         }

         System.setProperty("webdriver.chrome.driver", currentUsersWorkingDir + "/src/test/resources/chromedriver");
         return new ChromeDriver();

     }

     public String getUrl() throws IOException {

         Properties property;
         String url = "";
         try {
             property = readConfigFile();
              url = property.getProperty("url");

         } catch (Exception e) {
             System.out.println("unable to get properties from file");
         }

         return url;
     }
 }