package TronaldDump;
import TronaldDump.Pages.HomePage;
import TronaldDump.Pages.RandomMeme;
import TronaldDump.Pages.RandomQuote;
import TronaldDump.Pages.SearchPage;
import org.openqa.selenium.WebDriver;
public class TronaldSite {

        private WebDriver driver;
        private String[] searchArray = {"Resign","Sue","Ivanka", "Wall", "Great again"};
        private HomePage homePage;
        private RandomMeme meme;
        private SearchPage searchPage;
        private RandomQuote quote;

    public TronaldSite(WebDriver driver){
        this.driver = driver;
        homePage = new HomePage(driver);
        meme = new RandomMeme(driver);
        quote = new RandomQuote(driver);

    }

    public String firstSearchResult(String query){
        homePage.goToHomePage();
        homePage.enterSearch(query);
        searchPage = new SearchPage(driver,homePage.getLastSearchRequest());
        searchPage.goToSearchPage();
        return searchPage.getFirstResult();
    }

    public void randomMeme(){
        meme.getRandomMeme();
    }
    public void randomQuote(){quote.getRandomQuote();}
    public String checkQuote(){return quote.getQuote();}
    public WebDriver getDriver(){
        return driver;
    }
}
