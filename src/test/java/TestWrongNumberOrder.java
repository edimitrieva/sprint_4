import org.junit.Test;

import static constants.Constants.URL;

public class TestWrongNumberOrder  extends BaseTest{

    @Test
    public void checkQuestions(){

        Header objHeader = new Header(driver);
        driver.get(URL);

        objHeader.clickStateOrder("1234");

        SearchResult objSearchResult = new SearchResult(driver);
        objSearchResult.checkImageNotFound();

    }
}
