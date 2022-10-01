import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class QuestionAboutImportant extends BaseClass {

    public QuestionAboutImportant(WebDriver driver){
        super(driver);
    }

    public void clickOnQuestion(By question) {
        WebElement element = driver.findElement(question);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(question).click();
    }

    public void checkQuestion(By answer, String expected){
        waitForVisibilityElement(answer);
        String actual = driver.findElement(answer).getText();
        Assert.assertEquals("Текст ответа на вопрос корректен", expected, actual);

    }

}
