import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import static org.hamcrest.core.StringStartsWith.startsWith;

//Страница заказа
public class OrderPage extends BaseClass {

    //Поле ввода Имя пользователя
    private By userName = By.xpath("//div[@class='Order_Form__17u6u']/div[1]/input");
    //Ошибка под полем Имя пользователя
    private By errorUserName = By.xpath("//div[@class='Order_Form__17u6u']/div[1]/div");
    //Поле ввода Фамилия
    private By userLastName = By.xpath("//div[@class='Order_Form__17u6u']/div[2]/input");
    //Ошибка под полем ввода Фамилия
    private By errorUserLastName = By.xpath("//div[@class='Order_Form__17u6u']/div[2]/div");
    //Поле ввода Адрес
    private By userAddress = By.xpath("//div[@class='Order_Form__17u6u']/div[3]/input");
    //Ошибка под полем ввода Адрес
    private By errorUserAddress = By.xpath("//div[@class='Order_Form__17u6u']/div[3]/div");
    //Поле ввода Номер телефона
    private By userNumberPhone = By.xpath("//div[@class='Order_Form__17u6u']/div[5]/input");
    //Ошибка под полем Номер телефона
    private By errorNumberPhone = By.xpath("//div[@class='Order_Form__17u6u']/div[5]/div");
    //Поле ввода Метро
    private By userMetro = By.className("select-search__input");
    //Ошибка под полем Метро
    private By errorUserMetro = By.className("Order_MetroError__1BtZb");
    //Кнопка Далее
    private By next = By.cssSelector("div.Order_NextButton__1_rCA > button");
    //Поле ввода Когда привезти самокат
    private By dataDelivery = By.xpath("//div[@class='Order_Form__17u6u']/div[1]//input");
    //Поле ввода Срок аренды
    private By rentalPeriod = By.className("Dropdown-control");
    //Чекбокс цвет Черный
    private By colorBlack = By.id("black");
    //Чекбокс цвет Серый
    private By colorGrey = By.id("grey");
    //Кнопка Заказать
    private By buttonOrder = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    //Кнопка Да
    private By buttonYes = By.xpath("//div[@class='Order_Modal__YZ-d3']//button[text()='Да']");
    //Заголовок Заказ оформлен
    private By orderDone = By.className("Order_ModalHeader__3FDaJ");
    //Кнопка Просмотреть статус
    private By buttonWatchStatus = By.cssSelector("div.Order_NextButton__1_rCA > button");



    public OrderPage(WebDriver driver){
        super(driver);
    }

    //Клик по кнопке Далее
    public void clickButtonNext(){
        waitForVisibilityElement(next);
        driver.findElement(next).click();
    }

    //Ввод данных на первой странице регистрации
    public void inputUserData(String name, String lastName, String address, String numberPhone){
        waitForVisibilityElement(userName);
        driver.findElement(userName).sendKeys(name);
        driver.findElement(userLastName).sendKeys(lastName);
        driver.findElement(userAddress).sendKeys(address);
        driver.findElement(userNumberPhone).sendKeys(numberPhone);
        driver.findElement(userMetro).click();
        driver.findElement(userMetro).sendKeys(Keys.DOWN);
        driver.findElement(userMetro).sendKeys(Keys.ENTER);

        clickButtonNext();

    }

    //Выбор даты в календаре +2 дня от текущей даты
    public void chooseData (int plusDay){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String date = LocalDate.now().plusDays(plusDay).format(formatter);
        driver.findElement(dataDelivery).sendKeys(date);
        driver.findElement(dataDelivery).sendKeys(Keys.ENTER);
    }

    //Случайный выбор Срока аренды
    public void chooseRandomRentalPeriod(){
        driver.findElement(rentalPeriod).click();
        Random random = new Random();
        int numberRentalPeriod = random.nextInt(6)+1;
        String xpathForOptionRentalPeriod = String.format("//div[@class='Dropdown-menu']/div[%d]", numberRentalPeriod);
        driver.findElement(By.xpath(xpathForOptionRentalPeriod)).click();
    }

    //Случайный выбор цвета самоката
    public void chooseRandomColor(){
        Random random = new Random();
        int numberColor = random.nextInt(100);
        if(numberColor%2==0)
            driver.findElement(colorBlack).click();
        else
            driver.findElement(colorGrey).click();
    }

    //Ввод данных на второй странице регистрации
    public void inputDeliveryData(){
        waitForVisibilityElement(dataDelivery);
        chooseData(2);
        chooseRandomRentalPeriod();
        chooseRandomColor();

        driver.findElement(buttonOrder).click();

        driver.findElement(buttonYes).click();

    }

    //Проверка, что заказ Оформлен
    public void checkTextOrderDone(){
        waitForVisibilityElement(orderDone);
        String actual = driver.findElement(orderDone).getText();
        System.out.println(actual);
        Assert.assertTrue(driver.findElement(buttonWatchStatus).isDisplayed());
        MatcherAssert.assertThat(actual, startsWith("Заказ оформлен"));
    }

    //Проверка ошибки под полем Имя
    public void checkErrorName(){
        driver.findElement(errorUserName).isDisplayed();
        String errorText = driver.findElement(errorUserName).getText();
        Assert.assertEquals("Ошибка Введите корректное имя отображается", "Введите корректное имя", errorText);
    }

    //Проверка ошибки под полем Фамилия
    public void checkErrorLastName(){
        driver.findElement(errorUserLastName).isDisplayed();
        String errorText = driver.findElement(errorUserLastName).getText();
        Assert.assertEquals("Ошибка Введите корректную фамилию отображается", "Введите корректную фамилию", errorText);
    }

    //Проверка ошибки под полем Адрес
    public void checkErrorAddress(){
        driver.findElement(errorUserAddress).isDisplayed();
        String errorText = driver.findElement(errorUserAddress).getText();
        Assert.assertEquals("Ошибка Введите корректный адрес отображается", "Введите корректный адрес", errorText);
    }

    //Проверка ошибки под полем Номер телефона
    public void checkErrorNumberPhone(){
        driver.findElement(errorNumberPhone).isDisplayed();
        String errorText = driver.findElement(errorNumberPhone).getText();
        Assert.assertEquals("Ошибка Введите корректный номер отображается", "Введите корректный номер", errorText);
    }

    //Проверка ошибки под полем Метро
    public void checkErrorMetro(){
        driver.findElement(errorUserMetro).isDisplayed();
        String errorText = driver.findElement(errorUserMetro).getText();
        Assert.assertEquals("Ошибка Выберите станцию отображается", "Выберите станцию", errorText);
    }
}
