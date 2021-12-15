package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class GenericUtils {

    private static ConfigProvider config;
    static WebDriver driver;
    static Logger log = getLocalLogger("GenericUtils");

    public static WebDriver startBrowser() {
        try {
            System.setProperty("webdriver.chrome.driver", config.getKeyValue("chromeDriverEXEPath"));
            ChromeOptions options = new ChromeOptions();
            //options.addArguments("--headless");
            options.addArguments("--start-maximized");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--disable-popup-blocking");

            driver = new ChromeDriver(options);
            driver.get(config.getKeyValue("AppURL"));
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

            } catch (Exception e) {
                e.printStackTrace();
        }
        return driver;
        }
    public static void clickWebElement(WebElement ele, String eleName)
    {
        try{
            ele.click();
            log.info("WebElement clicked : " + eleName);
            Thread.sleep(3000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void inputIntoTextBox(WebElement ele, String textInput, String eleName) {
        try {
            ele.sendKeys(textInput);
            log.info("Text inputted in : " + eleName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Logger getLocalLogger(String loggerName)
    {
        Logger log = Logger.getLogger(loggerName);
        return log;
    }

    public static boolean myWait(WebDriver driver, WebElement ele)
    {
        boolean flag = false;
        try {
            Wait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.visibilityOf(ele));
            flag = true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }
}
