package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GenericUtils;

public class UIWeather {

        GenericUtils utils;
        WebDriver localDriver;

        public UIWeather()
        {
            localDriver = utils.startBrowser();
            PageFactory.initElements(localDriver,this);
        }

        @FindBy(xpath = "//input[@name='query']") WebElement cityInputBox;
        @FindBy(xpath = "(//*[contains(text(),'More Details')])[1]") WebElement moreDetailsLink;

}
