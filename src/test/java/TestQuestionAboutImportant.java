import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

import static constants.Constants.URL;

//Проверка блока Вопросы о важном на главной странице. Параметры находятся в классе ConstantsQuestionAboutImportant
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
                {QuestionAboutImportant.question1, QuestionAboutImportant.answer1, QuestionAboutImportant.expected1},
                {QuestionAboutImportant.question2, QuestionAboutImportant.answer2, QuestionAboutImportant.expected2},
                {QuestionAboutImportant.question3, QuestionAboutImportant.answer3, QuestionAboutImportant.expected3},
                {QuestionAboutImportant.question4, QuestionAboutImportant.answer4, QuestionAboutImportant.expected4},
                {QuestionAboutImportant.question5, QuestionAboutImportant.answer5, QuestionAboutImportant.expected5},
                {QuestionAboutImportant.question6, QuestionAboutImportant.answer6, QuestionAboutImportant.expected6},
                {QuestionAboutImportant.question7, QuestionAboutImportant.answer7, QuestionAboutImportant.expected7},
                {QuestionAboutImportant.question8, QuestionAboutImportant.answer8, QuestionAboutImportant.expected8},
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
