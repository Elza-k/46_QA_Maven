package demoqa.book_store;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.LoginPage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    //User: ImyaUsera
    //Password: Qwery12345!
    @BeforeMethod
    public void preconditions() {
        new HomePage(app.driver).getBookStore().hideAds();//первый шаг зайдет на бук сторе
        new SidePage(app.driver).selectLogin().hideAds();//второй шаг зайдет на логин линк
    }

    @Test
    public void loginPositiveTest() {
        new LoginPage(app.driver)
                .enterPersonalData("ImyaUsera", "Qwery12345!")
                .clickOnLoginButton()
                .verifyUserName("ImyaUsera");// вместо ассерта
    }
}
