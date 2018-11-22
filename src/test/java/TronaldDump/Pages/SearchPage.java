package TronaldDump.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
public class SearchPage {

    private WebDriver driver;
    private String searchURL;
    private By searchResults = By.tagName("blockquote");

    public SearchPage(WebDriver driver,String query){
        this.searchURL = "https://www.tronalddump.io/search?query=" + query;
        this.driver = driver;
    }

    public String[] getResults(){
        List result = driver.findElements(searchResults);
        String[] quotes = new String[driver.findElements(searchResults).size()];
        for(int i = 0; i < quotes.length; i++){
            quotes[i] = result.get(i).toString();
        }
        return quotes;
    }
}
