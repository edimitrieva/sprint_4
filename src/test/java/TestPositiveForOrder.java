import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static constants.Constants.URL;

@RunWith(Parameterized.class)
public class TestPositiveForOrder extends BaseTest{

    private String name;
    private String lastName;
    private String address;
    private String numberPhone;

    public TestPositiveForOrder(String name, String lastName, String address, String numberPhone){
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.numberPhone = numberPhone;
    }

    @Parameterized.Parameters
    public static Object[][] getUserData(){
        return new Object[][]{
                {"Андрей", "Иванов", "Спортивная, 8", "89274568734"},
                {"Алена", "Звягинцева", "Рублевка, 17", "+79210983208"}
        };
    }

    @Test
    public void checkQuestions() {

        MainPage objMainPage = new MainPage(driver);
       driver.get(URL);

        objMainPage.clickOrder();

        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.inputUserData(name, lastName, address, numberPhone);
        objOrderPage.inputDeliveryData();

       objOrderPage.checkTextOrderDone();


    }

}
