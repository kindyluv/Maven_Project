package africa.semicolon.BankingApplication.services;

import africa.semicolon.BankingApplication.data.models.AccountType;
import africa.semicolon.BankingApplication.dtos.requests.CreateAccountRequests;
import org.junit.jupiter.api.*;

import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.*;

import java.util.Locale;

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
        //given
        String name = bankService.createBank("GTCO");
        CreateAccountRequests createAccountRequests = new CreateAccountRequests();
        createAccountRequests.setAccountType(AccountType.CURRENT);
        createAccountRequests.setBankId(name);
        createAccountRequests.setFirstName("Agba");
        createAccountRequests.setLastName("Mon_shur");
//        bankService.createBank("GTCO");
        //when
        String accountNumber = bankService.createAccount(createAccountRequests);
        //assert
        assertEquals("0100000001", accountNumber);
    }

    @Test
    void testThatBankCanCreateTwoAccountInBank1_accNumberShouldBe02(){
        //given
        String name = bankService.createBank("GTCO");
        String name_2 = bankService.createBank("First Bank");

        CreateAccountRequests agba = new CreateAccountRequests();
        agba.setAccountType(AccountType.CURRENT);
        agba.setBankId(name);
        agba.setFirstName("Agba");
        agba.setLastName("Mon_shur");
        String accountNumber = bankService.createAccount(agba);

        CreateAccountRequests john = new CreateAccountRequests();
        john.setAccountType(AccountType.CURRENT);
        john.setBankId(name_2);
        john.setFirstName("Ajohnne");
        john.setLastName("Sleeping_Logic");
        String accountNumber2 = bankService.createAccount(john);
        //assert
        assertEquals("0100000001", accountNumber);
        assertEquals("0200000001", accountNumber2);
    }

    @Test
    void testThatBankCanCreateTwoAccountInBank1_AndBank2_accNumberShouldBe01(){
        //given
        String name = bankService.createBank("GTCO");
        String name_2 = bankService.createBank("First Bank");

        CreateAccountRequests first = new CreateAccountRequests();
        first.setAccountType(AccountType.CURRENT);
        first.setBankId(name);
        first.setFirstName("Agba");
        first.setLastName("Mon_shur");
//        bankService.createBank("GTCO");
        String accountNumber = bankService.createAccount(first);

        //when

        CreateAccountRequests second = new CreateAccountRequests();
        second.setAccountType(AccountType.CURRENT);
        second.setBankId(name);
        second.setFirstName("Ajohnne");
        second.setLastName("Sleeping_Logic");
//        bankService.createBank("First Bank");
        String accountNumber2 = bankService.createAccount(second);

        CreateAccountRequests third = new CreateAccountRequests();
        third.setAccountType(AccountType.CURRENT);
        third.setBankId(name_2);
        third.setFirstName("Ajohnne");
        third.setLastName("Sleeping_Logic");

        String accountNumber3 = bankService.createAccount(third);
        //assert
        assertEquals("0100000001", accountNumber);
        assertEquals("0100000002", accountNumber2);
        assertEquals("0200000001", accountNumber3);
    }
//
//    @Test
//    void whenAccountIsCreated_CustomerIsCreatedToo(){
//        String name = bankService.createBank("GTCO");
//
//        CreateAccountRequests agba = new CreateAccountRequests();
//        agba.setAccountType(AccountType.KIDDIES);
//        agba.setBankId(name);
//        agba.setFirstName("Agba");
//        agba.setLastName("Mon_shur");
//
//        String agbaMonsure = bankService.createAccount(agba);
//        CustomerService customerService = new CustomerServiceImpl();
//        assertEquals(1, customerService.findAll().size());
//    }
}