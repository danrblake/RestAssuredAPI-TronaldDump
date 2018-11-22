package TronaldDump.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage {

    private WebDriver driver;
    private String homePageURL = "https://www.tronalddump.io/";
    private By searchSubmit = By.xpath("//*[@id=\"content\"]/section[2]/form/input[2]");
    private By searchBox = By.xpath("//*[@id=\"content\"]/section[2]/form/input[1]");
    private String lastSearchRequest;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void goToHomePage(){
        driver.navigate().to(homePageURL);
    }
    public void enterSearch(String searchData){
        driver.findElement(searchBox).sendKeys(searchData);
        driver.findElement(searchSubmit).click();
        lastSearchRequest = searchData;
    }
    public String getLastSearchRequest(){
        return lastSearchRequest;
    }

}
