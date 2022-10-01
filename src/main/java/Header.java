import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

import static constants.Constants.URL_DZEN;
import static org.hamcrest.core.StringStartsWith.startsWith;

public class Header extends BaseClass {
    private By logoScooter = By.className("Header_LogoScooter__3lsAR");
    private By logoYandex = By.className("Header_LogoYandex__3TSOI");
    private By dzen = By.className("dzen-top-controls-desktop__topControls-14");
    private By buttonStateOrder = By.className("Header_Link__1TAG7");
    private By inputNumberOrder = By.cssSelector("div.Input_InputContainer__3NykH > input");
    private By buttonGo = By.cssSelector("div.Header_SearchInput__3YRIQ > button");
    private By buttonOrderTitle = By.cssSelector("div.Header_Nav__AGCXC > button.Button_Button__ra12g");

    public Header(WebDriver driver){
        super(driver);
    }

    public void clickOrderInTitle (){
        driver.findElement(buttonOrderTitle).click();
    }

    public void clickLogoScooter(){
        driver.findElement(logoScooter).click();
    }

    public void switchNewTab(){
        String currentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> i = allWindows.iterator();
        while(i.hasNext()){
            String childWindow = i.next();
            if(!childWindow.equalsIgnoreCase(currentWindow)){
                driver.switchTo().window(childWindow);
            }
        }
    }

    public void clickLogoYandex(){
        driver.findElement(logoYandex).click();
        switchNewTab();
        waitForVisibilityElement(dzen);
        String url = driver.getCurrentUrl();
        MatcherAssert.assertThat(url, startsWith(URL_DZEN));
    }

    public void clickStateOrder(String numberOrder){
        driver.findElement(buttonStateOrder).click();
        waitForVisibilityElement(inputNumberOrder);
        driver.findElement(inputNumberOrder).sendKeys(numberOrder);
        driver.findElement(buttonGo).click();
    }


}
