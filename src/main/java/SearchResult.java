import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Страница результатов поиска по заказам
public class SearchResult extends BaseClass {
    //Изображение Not Found
    private By imageNotFount = By.cssSelector("div.Track_NotFound__6oaoY > img");

    public SearchResult(WebDriver driver){
        super(driver);
    }

    //Проверка отображения изображения по заказам
    public void checkImageNotFound(){
        waitForVisibilityElement(imageNotFount);
        WebElement imgNotFound =
                driver.findElement(imageNotFount);
        Assert.assertTrue("Expected Image Not Found to be shown", imgNotFound.isDisplayed());
    }
}
