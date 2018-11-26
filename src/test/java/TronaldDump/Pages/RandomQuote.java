package TronaldDump.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class RandomQuote {

    private WebDriver driver;
    private String URL;
    private By getQuoteInfo = By.tagName("pre");
    private String quote;

    public RandomQuote(WebDriver driver){
        this.driver = driver;
        this.URL = "https://api.tronalddump.io/random/quote";
         }

     public void getRandomQuote(){
        driver.navigate().to(URL);
     }
     public void checkQuoteExists(){
        this.quote = driver.findElement(getQuoteInfo).getText();
     }
     public String getQuote(){
        checkQuoteExists();
        return quote;
     }
}
