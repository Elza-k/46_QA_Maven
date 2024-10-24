package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;

public class TicketServiseRegistrationPage extends BasePage {

    public TicketServiseRegistrationPage(WebDriver driver) {
        super(driver);
    }

    // Находим необходимые элементы
    @FindBy(xpath = "//input[@placeholder='Name*']")
    WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Surname*']")
    WebElement surName;

    @FindBy(xpath = "//input[@placeholder='Email*']")
    WebElement emailInput;

    @FindBy(xpath = "//input[@placeholder='Password*']")
    WebElement passwordInput;

    @FindBy(xpath = "//input[@placeholder='Confirm password*']")
    WebElement confirmPasswordInput;

    @FindBy(xpath = "//input[@placeholder='Phone number*']")
    WebElement phoneNumberInput;

    @FindBy(css = "label.label-for-checkbox[for='c1']") // Поле соглашения с политикой
    WebElement dataProtectionCheckbox;

    @FindBy(className = "form-btn") // Кнопка регистрации
    WebElement submitButton;

    @FindBy(id = "example-modal-sizes-title-lg") // Окно успешной регистрации
    WebElement registrationSuccessText;

    public TicketServiseRegistrationPage enterRegistrationData(String name, String surname, String email, String password, String confirmPassword, String phoneNumber) {
        type(firstName, name);
        type(surName, surname);
        type(emailInput, email);
        type(passwordInput, password);
        type(confirmPasswordInput, confirmPassword);
        type(phoneNumberInput, phoneNumber);
        return this;
    }

    public TicketServiseRegistrationPage asseptProtectionPolicy() {
        click(dataProtectionCheckbox);
        return this;
    }

    public TicketServiseRegistrationPage submitForm() {
        click(submitButton);
        return this;
    }

    // Метод для проверки успешной регистрации
    public TicketServiseRegistrationPage verifySuccessRegistration(String expectedText) {
        shouldHaveText(registrationSuccessText, expectedText, 5000);
        return this;
    }

}




