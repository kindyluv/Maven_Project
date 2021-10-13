package africa.semicolon.BankingApplication.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankServiceImplTest {
    BankService bankService;

    @BeforeEach
    void setUp() {
        bankService = new BankServiceImpl();
    }

    @AfterEach
    void tearDown() {
        bankService = null;
    }

    @Test
    void createBank() {
        //when
        String bankId = bankService.createBank("GTCO");
        //assert
        assertEquals("01", bankId);
    }

    @Test
    void createTwoBanks_secondBankId_willBe02() {
        //when
        String gtCoId = bankService.createBank("GTCO");
        String firstBankId = bankService.createBank("First Bank");
        //assert
        assertEquals("01", gtCoId);
        assertEquals("02", firstBankId);
    }

    @Test
    void createTwoBanks_repositoryShouldHave2Banks() {
        //when
        String gtCoId = bankService.createBank("GTCO");
        String firstBankId = bankService.createBank("First Bank");
        //assert
        assertEquals("01", gtCoId);
        assertEquals("02", firstBankId);
        assertEquals(2,bankService.findAllBanks().size());
    }

    @Test
    void testThatBankCanCreateAccountForCustomers(){
        String gtCoId = bankService.createBank("GTCO");
        //when
        String accountNumber = bankService.createAccount("01","Agba", "Monusr");
        //assert
        assertEquals("0100000001", accountNumber);
    }

    @Test
    void testThatBankCanCreateTwoAccountInBank1_accNumberShouldBe02(){
        String gtCoId = bankService.createBank("GTCO");
        //when
        String accountNumber = bankService.createAccount("01","Agba", "Monusr");
        String accountNumber2 = bankService.createAccount("01","Ajohnne", "sleepingLogic");
        //assert
        assertEquals("0100000001", accountNumber);
        assertEquals("0100000002", accountNumber2);
    }

    @Test
    void testThatBankCanCreateTwoAccountInBank1_AndBank2_accNumberShouldBe01(){
        String gtCoId = bankService.createBank("GTCO");
        String firstBankId = bankService.createBank("First Bank");
        //when
        String accountNumber = bankService.createAccount("01","Agba", "Monusr");
        String accountNumber2 = bankService.createAccount("01","Ajohnne", "sleepingLogic");
        String accountNumber3 = bankService.createAccount("02","Jerry", "sleepingJerry");
        //assert
        assertEquals("0100000001", accountNumber);
        assertEquals("0100000002", accountNumber2);
        assertEquals("0200000001", accountNumber3);
    }
}