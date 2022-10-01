import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.StringStartsWith.startsWith;

public class MainPage extends BaseClass {
    private By buttonOrder = By.xpath("//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
    private By title = By.className("Home_Header__iJKdX");

    public MainPage(WebDriver driver){
        super(driver);
    }


    public void clickOrder (){
        WebElement element = driver.findElement(buttonOrder);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public void checkTitleManePage(){
        waitForVisibilityElement(title);
        String actual = driver.findElement(title).getText();
        MatcherAssert.assertThat(actual, startsWith("Самокат"));
        MatcherAssert.assertThat(actual, containsString("на пару дней"));
    }

}
