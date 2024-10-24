package demoqa;

import demoqa.core.TestBase;
import demoqa.pages.TicketServiseRegistrationPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TicketServiceRegistrWithParametersTest extends TestBase {
    @BeforeMethod
    public void precondition() {
        // Переходим на сайт регистрации перед каждым тестом
        app.driver.get("https://ticket-service-69443.firebaseapp.com/registration");
    }

    @Test
    @Parameters({"name", "surName", "email", "password", "phone"})
    public void ticketServiceRegistrationPositiveTest(String name, String surName,String email, String password, String phone) {

        new TicketServiseRegistrationPage(app.driver)
                .enterRegistrationData(name, surName, System.currentTimeMillis()+email, password, password, phone)
                .asseptProtectionPolicy()
                .submitForm()
                .verifySuccessRegistration("Registration successful");

    }

}
//John, Smith, testexample@gmail.com, Qwerty123, Qwerty123, 1234567890)