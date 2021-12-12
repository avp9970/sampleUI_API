package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GenericUtils {

    private static ConfigProvider config;
    static WebDriver driver;

    public static WebDriver startBrowser() {
        try {
            System.setProperty("webdriver.chrome.driver", config.getKeyValue("chromeDriverEXEPath"));
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--start-maximized");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--disable-popup-blocking");

            driver = new ChromeDriver(options);
            driver.get(config.getKeyValue("AppURL"));
            Thread.sleep(3000);

            } catch (Exception e) {
                e.printStackTrace();
        }
        return driver;
        }
}
