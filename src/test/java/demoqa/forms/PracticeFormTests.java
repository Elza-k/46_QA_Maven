package demoqa.forms;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.PracticeFormPage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver).getForm().hideAds();
        new SidePage(app.driver).selectPracticeForm().hideAds();
    }
    @Test
    public void practiceFormTest() {
        new PracticeFormPage(app.driver)
                .enterPersonalData("John","Smith", "email@gmail.com", "1234567890")
               .selectGender("Male")
              .chooseDateAsString("04 May 2000")
              // .chooseDate("6","November","2000")
                .enterSubject(new String[]{"Chemistry", "Physics"})
                .chooseHobbies(new String[]{"Sports", "Music"})
                .uploadPicture("C:/Users/elzar/Pictures/Camera Roll/album.jpg")
               .enterCurrentAddress("Theresienstrasse,Passau,Germany")
               .enterState("Haryana")
               .enterCity("Karnal")
                .submitForm()
                .verifySuccessRegistration("Thanks for submitting the form")
       ;
    }
    @Test
    @Parameters({"firstName", "lastName", "email", "phone"})
    public void practiceFormParametersTest(String firstName, String lastName, String email, String phone) {
        new PracticeFormPage(app.driver)
                .enterPersonalData(firstName, lastName, email, phone)
                .selectGender("Male")
                .chooseDateAsString("04 May 2000")
                // .chooseDate("6","November","2000")
                .enterSubject(new String[]{"Chemistry", "Physics"})
                .chooseHobbies(new String[]{"Sports", "Music"})
                .uploadPicture("C:/Users/elzar/Pictures/Camera Roll/album.jpg")
                .enterCurrentAddress("Theresienstrasse,Passau,Germany")
                .enterState("Haryana")
                .enterCity("Karnal")
                .submitForm()
                .verifySuccessRegistration("Thanks for submitting the form")
        ;
    }

}
