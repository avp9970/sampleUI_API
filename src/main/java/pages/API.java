package pages;

import io.restassured.RestAssured;
import utils.ConfigProvider;

import java.util.HashMap;

public class API {

    ConfigProvider config;

    public HashMap getAPIDetails()
    {
        HashMap<Integer,String> apiCityDetails = new HashMap<Integer, String>();
        RestAssured.baseURI = config.getKeyValue("BaseURI");





        return apiCityDetails;
    }

}
