import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

//Вопросы о важном на главной странице
public class QuestionAboutImportant extends BaseClass {
    //Вопрос 1 Сколько это стоит? И как оплатить?
    public static final By question1 = By.id("accordion__heading-0");
    //Вопрос 2 Хочу сразу несколько самокатов! Так можно?
    public static final By question2 = By.id("accordion__heading-1");
    //Вопрос 3 Как рассчитывается время аренды?
    public static final By question3 = By.id("accordion__heading-2");
    //Вопрос 4 Можно ли заказать самокат прямо на сегодня?
    public static final By question4 = By.id("accordion__heading-3");
    //Вопрос 5 Можно ли продлить заказ или вернуть самокат раньше?
    public static final By question5 = By.id("accordion__heading-4");
    //Вопрос 6 Вы привозите зарядку вместе с самокатом?
    public static final By question6 = By.id("accordion__heading-5");
    //Вопрос 7 Можно ли отменить заказ?
    public static final By question7 = By.id("accordion__heading-6");
    //Вопрос 8 Я жизу за МКАДом, привезёте?
    public static final By question8 = By.id("accordion__heading-7");

    //Ответ на вопрос 1
    public static final By answer1 = By.xpath("//div[@id='accordion__panel-0']/p");
    //Ответ на вопрос 2
    public static final By answer2 = By.xpath("//div[@id='accordion__panel-1']/p");
    //Ответ на вопрос 3
    public static final By answer3 = By.xpath("//div[@id='accordion__panel-2']/p");
    //Ответ на вопрос 4
    public static final By answer4 = By.xpath("//div[@id='accordion__panel-3']/p");
    //Ответ на вопрос 5
    public static final By answer5 = By.xpath("//div[@id='accordion__panel-4']/p");
    //Ответ на вопрос 6
    public static final By answer6 = By.xpath("//div[@id='accordion__panel-5']/p");
    //Ответ на вопрос 7
    public static final By answer7 = By.xpath("//div[@id='accordion__panel-6']/p");
    //Ответ на вопрос 8
    public static final By answer8 = By.xpath("//div[@id='accordion__panel-7']/p");

    //Текст ответа на вопрос 1
    public static final String expected1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    //Текст ответа на вопрос 2
    public static final String expected2 = "Пока что у нас так: один заказ — один самокат. " +
            "Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    //Текст ответа на вопрос 3
    public static final String expected3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. " +
            "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат " +
            "8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    //Текст ответа на вопрос 4
    public static final String expected4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    //Текст ответа на вопрос 5
    public static final String expected5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    //Текст ответа на вопрос 6
    public static final String expected6 = "Самокат приезжает к вам с полной зарядкой. " +
            "Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    //Текст ответа на вопрос 7
    public static final String expected7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    //Текст ответа на вопрос 8
    public static final String expected8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    public QuestionAboutImportant(WebDriver driver){
        super(driver);
    }

    //клик на вопрос о важном
    public void clickOnQuestion(By question) {
        WebElement element = driver.findElement(question);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(question).click();
    }

    //проверка ответа на вопрос
    public void checkQuestion(By answer, String expected){
        waitForVisibilityElement(answer);
        String actual = driver.findElement(answer).getText();
        Assert.assertEquals("Текст ответа на вопрос корректен", expected, actual);

    }

}
