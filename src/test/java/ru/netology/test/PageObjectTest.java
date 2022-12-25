package ru.netology.test;

import org.junit.jupiter.api.*;
import ru.netology.page.*;

import static com.codeborne.selenide.Selenide.*;

public class PageObjectTest {
    @BeforeEach
    void setUp() {
        open("http://localhost:9999/");
    }

    @Test
    void transactionFromFirstToSecondCardTest() {
        int amount = 600;
        new LoginPage().validLogIn().validVerify();

        int expectedBalanceFirstCardAfterTransaction = new DashboardPage().getFirstCardBalance() - amount;
        int expectedBalanceSecondCardAfterTransaction = new DashboardPage().getSecondCardBalance() + amount;

        new TransactionPage().fromFirstToSecondCardValidTransaction(amount);

        Assertions.assertEquals(expectedBalanceFirstCardAfterTransaction, new DashboardPage().getFirstCardBalance());
        Assertions.assertEquals(expectedBalanceSecondCardAfterTransaction, new DashboardPage().getSecondCardBalance());
    }

    @Test
    void transactionFromSecondToFirstCardTest() {
        int amount = 600;
        new LoginPage().validLogIn().validVerify();

        int expectedBalanceFirstCardAfterTransaction = new DashboardPage().getFirstCardBalance() + amount;
        int expectedBalanceSecondCardAfterTransaction = new DashboardPage().getSecondCardBalance() - amount;

        new TransactionPage().fromSecondToFirstCardValidTransaction(amount);

        Assertions.assertEquals(expectedBalanceFirstCardAfterTransaction, new DashboardPage().getFirstCardBalance());
        Assertions.assertEquals(expectedBalanceSecondCardAfterTransaction, new DashboardPage().getSecondCardBalance());
    }

//    @Test
//    void invalidTransactionFromFirstToSecondCardTest() {
//        new LoginPage().validLogIn().validVerify();
//
//        int amount = new DashboardPage().getFirstCardBalance() * 2;
//
//        new TransactionPage().fromFirstToSecondCardInvalidTransaction(amount);
//    }

    @Test
    void invalidLoginTest() {
        new LoginPage().invalidLogIn();
    }

    @Test
    void invalidVerifyTest() {
        new LoginPage().validLogIn().invalidVerify();
    }
}
