import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static constants.Constants.URL;

//Тест проверки создания заказа. Проверяется 2 кнопки Заказать в зависимости от numberButton
@RunWith(Parameterized.class)
public class TestPositiveForOrder extends BaseTest{

    private String name;
    private String lastName;
    private String address;
    private String numberPhone;
    //numberButton = 1, кнопка в заголовке
    //numberButton = 0, кнопка внизу страницы
    private int numberButton;

    public TestPositiveForOrder(String name, String lastName, String address, String numberPhone, int numberButton){
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.numberPhone = numberPhone;
        this.numberButton = numberButton;
    }

    @Parameterized.Parameters
    public static Object[][] getUserData(){
        return new Object[][]{
                {"Андрей", "Иванов", "Спортивная, 8", "89274568734", 1},
                {"Алена", "Звягинцева", "Рублевка, 17", "+79210983208", 0}
        };
    }

    @Test
    public void checkQuestions() {

       driver.get(URL);

       if(numberButton==1){
           Header objHeader = new Header(driver);
           objHeader.clickOrderInTitle();
       }else {
           MainPage objMainPage = new MainPage(driver);
           objMainPage.clickOrder();
       }
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.inputUserData(name, lastName, address, numberPhone);
        objOrderPage.inputDeliveryData();

       objOrderPage.checkTextOrderDone();


    }

}
