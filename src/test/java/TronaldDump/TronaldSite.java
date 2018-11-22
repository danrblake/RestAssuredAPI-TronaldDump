package TronaldDump;
import TronaldDump.Pages.HomePage;
import TronaldDump.Pages.RandomMeme;
import org.openqa.selenium.WebDriver;
public class TronaldSite {

        private WebDriver driver;
        private String[] searchArray = {"Resign","Sue","Ivanka", "Wall", "Great again"};
        private HomePage homePage;
        private RandomMeme meme;

    public TronaldSite(WebDriver driver){
        this.driver = driver;
        homePage = new HomePage(driver);
        meme = new RandomMeme(driver);
    }

    public void search(){
        for(int i = 0; i < searchArray.length; i++){
            homePage.enterSearch(searchArray[i]);
        }
    }

    public void randomMeme(){
        meme.getRandomMeme();
    }
    public WebDriver getDriver(){
        return driver;
    }
}
