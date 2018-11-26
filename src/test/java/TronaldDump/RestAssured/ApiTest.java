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
        properties = new SeleniumDriverConfig("chrome");
        site = new TronaldSite(properties.getDriver());
        port = 443;
    }

    @Test
    public void getRandomMeme(){
        for(int i = 0; i < 5; i++) {
            site.randomMeme();
        }
        site.getDriver().quit();
    }

    @Test
    public void testSearch(){
        baseURI = "https://api.tronalddump.io";
        basePath = "/search/quote?query=";
        String[] quotes = new String[5];
        for (int i = 0; i < searchArray.length; i++) {
            quotes[i] = site.firstSearchResult(searchArray[i]);
            given()
                    .header("accept"," application/hal+json")
                    .get(searchArray[i])
                    .then()
                    .body("total", equalTo(quotes[i]));
        }
    }
    @Test
    public void testRandomQuote(){
        site.randomQuote();
        Assert.assertNotNull(site.checkQuote());
        System.out.println(site.checkQuote());
    }
    @Test
    public void testQuoteSearchWithID(){
        baseURI = "https://api.tronalddump.io";
        basePath = "/quote/";
        String id = "Js5AQrOsQxmjLrq5F_Os2w";
        given()
                .header("accept", "application/hal+json")
                .get(id)
                .then()
                .body("quote_id", equalTo(id));

    }
    @Test
    public void testListOfTags(){
        baseURI = "https://api.tronalddump.io";
        basePath = "/tag";
        given()
                .header("accept", "application/hal+json")
                .then().statusCode(412)
                .body("count", equalTo(20));
    }
    @Test
    public void testGetTag(){
        String tag = "Money";
        baseURI = "https://api.tronalddump.io";
        basePath = "/tag/";
        given()
                .header("accept", "application/hal+json")
                .get(tag).then().statusCode(200)
                .body("_embedded.tags[0].tags[0]", equalTo(tag));
    }
}
