package TronaldDump.RestAssured;
import Selenium_Config.SeleniumDriverConfig;
import Selenium_Config.SeleniumProperties;
import TronaldDump.TronaldSite;
import com.jayway.restassured.path.json.JsonPath;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
public class ApiTest {


    private SeleniumDriverConfig properties;
    private TronaldSite site;

    JsonPath searchResponse;
    private String[] searchArray = {"Resign","Sue","Ivanka", "Wall", "Great again"};

    @Before
    public void setUp(){
        baseURI = "https://api.tronalddump.io";
        basePath = "/search/quote?query=";
        properties = new SeleniumDriverConfig("chrome");
        site = new TronaldSite(properties.getDriver());
    }

    @Test
    public void getRandomMeme(){
        for(int i = 0; i < 5; i++) {
            site.randomMeme();
        }
        site.getDriver().quit();
    }

//    @Test
//    public void testSearch(){
//        for (String s : searchArray) {
//            when().
//            get(s).then().statusCode(200).
//        }
//
//    }
}