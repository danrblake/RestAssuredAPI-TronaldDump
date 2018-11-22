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
    private By firstResult = By.xpath("//*[@id=\"content\"]/section/blockquote/p");
    private By firstResult1 = By.xpath("//*[@id=\"content\"]/section/blockquote[1]/p");

    public SearchPage(WebDriver driver, String query){
        this.driver = driver;
        this.searchURL = "https://www.tronalddump.io/search?query=" + query;
    }

    public void goToSearchPage(){
        driver.navigate().to(searchURL);
    }
    public String getFirstResult(){

        String result;
        try {
            result = driver.findElement(firstResult).getText();
        } catch (NullPointerException e) {
            result = driver.findElement(firstResult1).getText();
        }
        return result;
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
