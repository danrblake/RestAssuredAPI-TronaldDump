package TronaldDump.Pages;
import org.openqa.selenium.WebDriver;
public class RandomMeme {
    private WebDriver driver;

    public RandomMeme(WebDriver driver){
        this.driver = driver;
    }

    public void getRandomMeme() {
        driver.navigate().to("https://api.tronalddump.io/random/meme");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
