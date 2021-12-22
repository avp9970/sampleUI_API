import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.API;
import pages.UI;
import utils.GenericUtils;

import java.util.HashMap;

public class ComparerTest {

    GenericUtils utils;
    HashMap<String,String> uiCityDetails = new HashMap<String, String>();
    HashMap<String,String> apiCityDetails = new HashMap<String, String>();

    @Test(priority = 1)
    public void getAPIWeatherDetails()
    {
        API api = new API();
        apiCityDetails = api.getAPIDetails();
    }
    @Test(priority = 2)
    public void getUIWeatherDetails()
    {
        WebDriver driver = utils.startBrowser();
        UI ui = new UI();
        uiCityDetails = ui.UIWeatherDetails(driver);
    }
    @Test(priority = 3)
    public void compareUIandAPI()
    {
        System.out.println("Details from UI Source = " + apiCityDetails);
        System.out.println("Details from UI Source = " + uiCityDetails);
    }
}
