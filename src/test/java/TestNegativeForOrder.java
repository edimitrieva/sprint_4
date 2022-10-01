import org.junit.Test;

import static constants.Constants.URL;

public class TestNegativeForOrder extends BaseTest{

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

    @Test
    public void checkErrorNumberPhone(){
        OrderPage objOrderPage = new OrderPage(driver);
        driver.get(URL);
        Header objHeader = new Header(driver);
        objHeader.clickOrderInTitle();
        objOrderPage.inputUserData("Иван", "Иванов", "Иванчекова, 12", "89");
        objOrderPage.clickButtonNext();
        objOrderPage.checkNumberPhone();
    }

    @Test
    public void checkErrorMetro(){
        OrderPage objOrderPage = new OrderPage(driver);
        driver.get(URL);
        Header objHeader = new Header(driver);
        objHeader.clickOrderInTitle();
        objOrderPage.clickButtonNext();
        objOrderPage.checkMetro();
    }

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
        objOrderPage.checkMetro();
        objOrderPage.checkNumberPhone();
    }


}
