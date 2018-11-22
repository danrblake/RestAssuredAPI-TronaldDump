package TronaldDump;
import TronaldDump.Pages.HomePage;
import org.openqa.selenium.WebDriver;
public class TronaldSite {

        private WebDriver driver;
        private String[] searchArray = {"Resign","Sue","Ivanka", "Wall", "Great again"};
        private HomePage homePage;

    public TronaldSite(WebDriver driver){
        this.driver = driver;
        homePage = new HomePage(driver);
    }

    public void search(){
        for(int i = 0; i < searchArray.length; i++){
            homePage.enterSearch(searchArray[i]);
        }
    }
}
