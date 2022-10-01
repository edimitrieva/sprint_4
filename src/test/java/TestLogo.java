import org.junit.Test;

import static constants.Constants.URL;

public class TestLogo extends BaseTest {

    @Test
    public void checkLogoScooter(){
        MainPage objMainPage = new MainPage(driver);
        Header objHeader = new Header(driver);
        driver.get(URL+"track?t=werwe");

        objHeader.clickLogoScooter();
        objMainPage.checkTitleManePage();
    }

    @Test
    public void checkLogoYandex(){
        Header objHeader = new Header(driver);
        driver.get(URL);

        objHeader.clickLogoYandex();
    }


}
