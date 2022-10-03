import org.junit.Test;

import static constants.Constants.URL;

//Дополнительное задание. Проверка логотипов
public class TestLogo extends BaseTest {

    //Клик по логотипу Скутер - открывается главная страница
    @Test
    public void checkLogoScooter(){
        MainPage objMainPage = new MainPage(driver);
        Header objHeader = new Header(driver);
        driver.get(URL+"track?t=werwe");

        objHeader.clickLogoScooter();
        objMainPage.checkTitleMainPage();
    }

    //Клик по логотипу Яндекс - открывается главная страница
    @Test
    public void checkLogoYandex(){
        Header objHeader = new Header(driver);
        driver.get(URL);

        objHeader.clickLogoYandex();
    }


}
