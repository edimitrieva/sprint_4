import org.junit.Test;

import static constants.Constants.URL;

//Дополнительное задание. Проверка отображения ошибок в каждом поле
public class TestNegativeForOrder extends BaseTest{

    //Проверка отображения ошибки под полем Имя
    @Test
   public void checkErrorName(){
        OrderPage objOrderPage = new OrderPage(driver);
        driver.get(URL);
        Header objHeader = new Header(driver);
        objHeader.clickOrderInTitle();
        objOrderPage.inputUserData("", "Иванов", "Спортивная", "89342345432");
        objOrderPage.clickButtonNext();
        objOrderPage.checkErrorName();
    }

    //Проверка отображения ошибки под полем Фамилия
    @Test
    public void checkErrorLastName(){
        OrderPage objOrderPage = new OrderPage(driver);
        driver.get(URL);
        Header objHeader = new Header(driver);
        objHeader.clickOrderInTitle();
        objOrderPage.inputUserData("Иван", "", "Спортивная", "89342345432");
        objOrderPage.clickButtonNext();
        objOrderPage.checkErrorLastName();
    }

    //Проверка отображения ошибки под полем Адрес
    @Test
    public void checkErrorAddress(){
        OrderPage objOrderPage = new OrderPage(driver);
        driver.get(URL);
        Header objHeader = new Header(driver);
        objHeader.clickOrderInTitle();
        objOrderPage.inputUserData("Иван", "Иванов", "4", "89342345432");
        objOrderPage.clickButtonNext();
        objOrderPage.checkErrorAddress();
    }

    //Проверка отображения ошибки под полем Номер телефона
    @Test
    public void checkErrorNumberPhone(){
        OrderPage objOrderPage = new OrderPage(driver);
        driver.get(URL);
        Header objHeader = new Header(driver);
        objHeader.clickOrderInTitle();
        objOrderPage.inputUserData("Иван", "Иванов", "Иванчекова, 12", "89");
        objOrderPage.clickButtonNext();
        objOrderPage.checkErrorNumberPhone();
    }

    //Проверка отображения ошибки под полем Метро
    @Test
    public void checkErrorMetro(){
        OrderPage objOrderPage = new OrderPage(driver);
        driver.get(URL);
        Header objHeader = new Header(driver);
        objHeader.clickOrderInTitle();
        objOrderPage.clickButtonNext();
        objOrderPage.checkErrorMetro();
    }

    //Проверка отображения ошибки под всеми полями, если нажата кнопка Далее, но данные в поля не введены
    @Test
    public void checkErrorAllErrorDisplayed(){
        OrderPage objOrderPage = new OrderPage(driver);
        driver.get(URL);
        Header objHeader = new Header(driver);
        objHeader.clickOrderInTitle();
        objOrderPage.clickButtonNext();
        objOrderPage.checkErrorName();
        objOrderPage.checkErrorLastName();
        objOrderPage.checkErrorAddress();
        objOrderPage.checkErrorMetro();
        objOrderPage.checkErrorNumberPhone();
    }


}
