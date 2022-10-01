import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

import static constants.Constants.URL;
import static constants.ConstantsQuestionAboutImportant.*;

@RunWith(Parameterized.class)
public class TestQuestionAboutImportant extends BaseTest{

    private static By question;
    private static By answer;
    private static String expected;

    public TestQuestionAboutImportant(By question, By answer, String expected){
        this.question = question;
        this.answer = answer;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getQuestionAndAnswer(){
        return new Object[][]{
                {question1, answer1, expected1},
                {question2, answer2, expected2},
                {question3, answer3, expected3},
                {question4, answer4, expected4},
                {question5, answer5, expected5},
                {question6, answer6, expected6},
                {question7, answer7, expected7},
                {question8, answer8, expected8},
        };
    }

    @Test
    public void checkQuestions(){
        QuestionAboutImportant objQuestion = new QuestionAboutImportant(driver);
        driver.get(URL);
        objQuestion.clickOnQuestion(question);
        objQuestion.checkQuestion(answer,expected);
    }

}
