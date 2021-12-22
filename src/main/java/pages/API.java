package pages;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.ConfigProvider;
import java.util.HashMap;

import static io.restassured.RestAssured.get;

public class API {

    ConfigProvider config;

    public HashMap getAPIDetails()
    {
        HashMap<String,String> apiCityDetails = new HashMap<String, String>();
        Response resp = RestAssured.given().
                        queryParam("q",config.getKeyValue("city")).
                        queryParam("units",config.getKeyValue("units")).
                        queryParam("appid",config.getKeyValue("key")).
                        contentType("application/json").get(config.getKeyValue("BaseURI"));
        //resp.body().prettyPrint();
        JsonPath extractor = resp.jsonPath();
        apiCityDetails.put("temp",extractor.getString("list[0].main.temp"));
        apiCityDetails.put("feels_like",extractor.getString("list[0].main.feels_like"));
        apiCityDetails.put("humidity",extractor.getString("list[0].main.humidity"));
        apiCityDetails.put("pressure",extractor.getString("list[0].main.pressure"));
        return apiCityDetails;
    }
}
