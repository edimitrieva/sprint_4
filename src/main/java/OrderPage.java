import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import static org.hamcrest.core.StringStartsWith.startsWith;

public class OrderPage extends BaseClass {

    private By userName = By.xpath("//div[@class='Order_Form__17u6u']/div[1]/input");
    private By errorUserName = By.xpath("//div[@class='Order_Form__17u6u']/div[1]/div");
    private By userLastName = By.xpath("//div[@class='Order_Form__17u6u']/div[2]/input");
    private By errorUserLastName = By.xpath("//div[@class='Order_Form__17u6u']/div[2]/div");
    private By userAddress = By.xpath("//div[@class='Order_Form__17u6u']/div[3]/input");
    private By errorUserAddress = By.xpath("//div[@class='Order_Form__17u6u']/div[3]/div");
    private By userNumberPhone = By.xpath("//div[@class='Order_Form__17u6u']/div[5]/input");
    private By errorNumberPhone = By.xpath("//div[@class='Order_Form__17u6u']/div[5]/div");
    private By userMetro = By.className("select-search__input");
    private By errorUserMetro = By.className("Order_MetroError__1BtZb");
    private By next = By.cssSelector("div.Order_NextButton__1_rCA > button");
    private By dataDelivery = By.xpath("//div[@class='Order_Form__17u6u']/div[1]//input");
    private By rentalPeriod = By.className("Dropdown-control");
    private By colorBlack = By.id("black");
    private By colorGrey = By.id("grey");
    private By buttonOrder = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private By buttonYes = By.xpath("//div[@class='Order_Modal__YZ-d3']//button[text()='Да']");
    private By orderDone = By.className("Order_ModalHeader__3FDaJ");



    public OrderPage(WebDriver driver){
        super(driver);
    }

    public void clickButtonNext(){
        waitForVisibilityElement(next);
        driver.findElement(next).click();
    }

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

    public void chooseData (int plusDay){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String date = LocalDate.now().plusDays(plusDay).format(formatter);
        driver.findElement(dataDelivery).sendKeys(date);
        driver.findElement(dataDelivery).sendKeys(Keys.ENTER);
    }

    public void chooseRandomRentalPeriod(){
        driver.findElement(rentalPeriod).click();
        Random random = new Random();
        int numberRentalPeriod = random.nextInt(6)+1;
        String xpathForOptionRentalPeriod = String.format("//div[@class='Dropdown-menu']/div[%d]", numberRentalPeriod);
        driver.findElement(By.xpath(xpathForOptionRentalPeriod)).click();
    }

    public void chooseRandomColor(){
        Random random = new Random();
        int numberColor = random.nextInt(100);
        if(numberColor%2==0)
            driver.findElement(colorBlack).click();
        else
            driver.findElement(colorGrey).click();
    }


    public void inputDeliveryData(){
        waitForVisibilityElement(dataDelivery);
        chooseData(2);
        chooseRandomRentalPeriod();
        chooseRandomColor();

        driver.findElement(buttonOrder).click();

        driver.findElement(buttonYes).click();

    }

    public void checkTextOrderDone(){
        waitForVisibilityElement(orderDone);
        String actual = driver.findElement(orderDone).getText();
        System.out.println(actual);
        MatcherAssert.assertThat(actual, startsWith("Заказ оформлен"));
    }

    public void checkErrorName(){
        driver.findElement(errorUserName).isDisplayed();
        String errorText = driver.findElement(errorUserName).getText();
        Assert.assertEquals("Ошибка Введите корректное имя отображается", "Введите корректное имя", errorText);
    }

    public void checkErrorLastName(){
        driver.findElement(errorUserLastName).isDisplayed();
        String errorText = driver.findElement(errorUserLastName).getText();
        Assert.assertEquals("Ошибка Введите корректную фамилию отображается", "Введите корректную фамилию", errorText);
    }

    public void checkErrorAddress(){
        driver.findElement(errorUserAddress).isDisplayed();
        String errorText = driver.findElement(errorUserAddress).getText();
        Assert.assertEquals("Ошибка Введите корректный адрес отображается", "Введите корректный адрес", errorText);
    }

    public void checkNumberPhone(){
        driver.findElement(errorNumberPhone).isDisplayed();
        String errorText = driver.findElement(errorNumberPhone).getText();
        Assert.assertEquals("Ошибка Введите корректный номер отображается", "Введите корректный номер", errorText);
    }

    public void checkMetro(){
        driver.findElement(errorUserMetro).isDisplayed();
        String errorText = driver.findElement(errorUserMetro).getText();
        Assert.assertEquals("Ошибка Выберите станцию отображается", "Выберите станцию", errorText);
    }
}
