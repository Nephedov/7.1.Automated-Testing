package ru.netology;

import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.DataHelper.*;

public class PageObjectTest {

    @Test
    void validTransferTest() {
        var authInfo = DataHelper.getAuthInfo();
        var verificationCode = DataHelper.getVerificationCode();
        var firstCardInfo = getFirstCardInfo();
        var secondCardInfo = getSecondCardInfo();

        var loginPage = open("http://localhost:9999", LoginPage.class);
        var verificationPage = loginPage.validLogIn(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);


        var firstCardBalance = dashboardPage.getCardBalance(firstCardInfo);
        var secondCardBalance = dashboardPage.getCardBalance(secondCardInfo);

        var amount = generateValidAmount(firstCardBalance);

        var expectedBalanceFirstCard = firstCardBalance - amount;
        var expectedBalanceSecondCard = secondCardBalance + amount;

        var transferPage = dashboardPage.selectCardToTransfer(secondCardInfo);
        dashboardPage = transferPage.makeValidTransfer(String.valueOf(amount), firstCardInfo);

        var actualBalanceFirstCard = dashboardPage.getCardBalance(firstCardInfo);
        var actualBalanceSecondCard = dashboardPage.getCardBalance(secondCardInfo);

        assertEquals(expectedBalanceFirstCard, actualBalanceFirstCard);
        assertEquals(expectedBalanceSecondCard, actualBalanceSecondCard);
    }

    @Test
    void errorMessageIfAmountMoreBalance() {
        var authInfo = DataHelper.getAuthInfo();
        var verificationCode = DataHelper.getVerificationCode();
        var firstCardInfo = getFirstCardInfo();
        var secondCardInfo = getSecondCardInfo();


        var loginPage = open("http://localhost:9999", LoginPage.class);
        var verificationPage = loginPage.validLogIn(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);

        var firstCardBalance = dashboardPage.getCardBalance(firstCardInfo);
        var secondCardBalance = dashboardPage.getCardBalance(secondCardInfo);

        var amount = generateInvalidAmount(secondCardBalance);
        var transferPage = dashboardPage.selectCardToTransfer(firstCardInfo);
        transferPage.makeTransfer(String.valueOf(amount), secondCardInfo);
        transferPage.findErrorMessage("На Вашем счету недостаточно средств для выполнения перевода.");

        var actualBalanceFirstCard = dashboardPage.getCardBalance(firstCardInfo);
        var actualBalanceSecondCard = dashboardPage.getCardBalance(secondCardInfo);

        assertEquals(firstCardBalance, actualBalanceFirstCard);
        assertEquals(secondCardBalance, actualBalanceSecondCard);

    }


}
