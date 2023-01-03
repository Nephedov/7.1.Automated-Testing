package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    @FindBy(css = "[data-test-id='login'] input")
    private SelenideElement loginField;
    @FindBy(css = "[data-test-id='password'] input")
    private SelenideElement passwordField;
    @FindBy(css = "[data-test-id='action-login']")
    private SelenideElement loginButton;

    public VerificationPage validLogIn(DataHelper.AuthInfo info) {
        logIn(info.getLogin(), info.getPassword());
        return page(VerificationPage.class);
    }

    public void logIn(String login, String password) {
        loginField.setValue(login);
        passwordField.setValue(password);
        loginButton.click();
    }

}
