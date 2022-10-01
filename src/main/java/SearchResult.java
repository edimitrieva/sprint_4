import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResult extends BaseClass {
    private By imageNotFount = By.cssSelector("div.Track_NotFound__6oaoY > img");

    public SearchResult(WebDriver driver){
        super(driver);
    }

    public void checkImageNotFound(){
        waitForVisibilityElement(imageNotFount);
        WebElement imgNotFound =
                driver.findElement(imageNotFount);
        Assert.assertTrue("Expected Image Not Found to be shown", imgNotFound.isDisplayed());
    }
}
