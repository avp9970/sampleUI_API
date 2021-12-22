package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigProvider;
import utils.GenericUtils;

import java.util.HashMap;
import java.util.Map;

public class UI {

        GenericUtils utils;
        ConfigProvider config;

        @FindBy(xpath = "//input[@name='query']") WebElement cityInputBox;
        @FindBy(xpath = "(//*[contains(text(),'More Details')])[1]") WebElement moreDetailsLink;
        @FindBy(id="dismiss-button") WebElement adPopUp_dismiss_button;
        @FindBy(xpath = "//*[@class='display-temp']") WebElement temp;
        @FindBy(xpath = "(//*[@class='current-weather-extra']/div)[1]") WebElement realFeel;
        @FindBy(xpath = "(//*[@class='detail-item spaced-content'])[3]/div[2]") WebElement humidity;
        @FindBy(xpath = "(//*[@class='detail-item spaced-content'])[6]/div[2]") WebElement pressure;

        public HashMap UIWeatherDetails(WebDriver driver)
        {
                PageFactory.initElements(driver, this);
                HashMap<String, String> uiCityDetails = new HashMap<String, String>();
                utils.inputIntoTextBox(cityInputBox, config.getKeyValue("city"), "City Input Box");
                cityInputBox.sendKeys(Keys.ENTER);
                utils.clickWebElement(moreDetailsLink, "MoreDetails Link");

                uiCityDetails.put("temp",temp.getText());
                uiCityDetails.put("feels_like",realFeel.getText());
                uiCityDetails.put("humidity",humidity.getText());
                uiCityDetails.put("pressure",pressure.getText());
                driver.close();
                return uiCityDetails;
        }

}
