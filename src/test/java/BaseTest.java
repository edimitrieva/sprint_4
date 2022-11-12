import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

//Базовый класс настройки браузера
public class BaseTest {
    WebDriver driver;

    @Before
    public void StartBrowser(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);

         /*
        //Настройки для запуска теста в FF
        System.setProperty("webdriver-gecko.driver", "C:\\WebDriver\\bin\\geckodriver.exe");
        driver = new FirefoxDriver();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
 */


    }

    @After
    public void teardown(){
        driver.quit();
    }
}
