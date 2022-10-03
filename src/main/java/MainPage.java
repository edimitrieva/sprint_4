import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static constants.Constants.URL;
import static constants.Constants.URL_DZEN;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.StringStartsWith.startsWith;

//Главная страница
public class MainPage extends BaseClass {
    //Кнопка Заказать внизу страницы
    private By buttonOrder = By.xpath("//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
    //Заголовок
    private By title = By.className("Home_Header__iJKdX");

    public MainPage(WebDriver driver){
        super(driver);
    }

    //Клик на кнопку Заказать внизу страницы, прокрутка до нее
    public void clickOrder (){
        WebElement element = driver.findElement(buttonOrder);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    //Проверка, что находимся на главной странице и на ней есть название Самокат
    public void checkTitleMainPage(){
        waitForVisibilityElement(title);
        String actual = driver.findElement(title).getText();
        String url = driver.getCurrentUrl();
        MatcherAssert.assertThat(url, startsWith(URL));
        MatcherAssert.assertThat(actual, startsWith("Самокат"));
        MatcherAssert.assertThat(actual, containsString("на пару дней"));

    }

}
