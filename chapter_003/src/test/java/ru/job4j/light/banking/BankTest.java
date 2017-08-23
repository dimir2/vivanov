package ru.job4j.light.banking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class BankTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 24.08.2017
 */
public class BankTest {

    /**
     * Add user test.
     */
    @Test
    public void whenAddUserThanAddItsAccountThenBankHasIt() {
        Bank bank = new Bank();
        User sergey = new User("sergey", "555-1");
        bank.addUser(sergey);
        List<Account> expected = new ArrayList<>();
        assertThat(bank.getUserAccounts(sergey), is(expected));
    }

    /**
     * Delete user test.
     */
    @Test
    public void whenDeleteUserThenBankHasNoAccounts() {
        Bank bank = new Bank();
        User anna = new User("anna", "555-2");
        bank.addUser(anna);
        bank.deleteUser(anna);
        assertThat(bank.getUserAccounts(anna), is(nullValue()));
    }

    /**
     * Add account to user.
     */
    @Test
    public void whenAddAccountToUserThenBankKnowsAboutIt() {
        Bank bank = new Bank();
        User sergey = new User("sergey", "555-1");
        bank.addUser(sergey);
        bank.addAccountToUser(sergey, new Account("555-1", 1000d));
        bank.addAccountToUser(sergey, new Account("555-2", 200d));
        List<Account> expected = new ArrayList<>(Arrays.asList(new Account("555-1"), new Account("555-2")));
        assertThat(bank.getUserAccounts(sergey), is(expected));
    }

    /**
     * Delete user account.
     */
    @Test
    public void whenDeleteUserAccountThenBankKnowAboutIt() {
        Bank bank = new Bank();
        User sergey = new User("sergey", "555-1");
        bank.addUser(sergey);
        bank.addAccountToUser(sergey, new Account("555-1", 1000d));
        bank.addAccountToUser(sergey, new Account("555-2", 200d));
        bank.deleteAccountFromUser(sergey, new Account("555-1"));
        List<Account> expected = new ArrayList<>(Arrays.asList(new Account("555-2")));
        assertThat(bank.getUserAccounts(sergey), is(expected));
    }

    /**
     * Get user accounts.
     */
    @Test
    public void whenUserHasAccountsThenBankKnowsAboutIt() {
        Bank bank = new Bank();
        User sergey = new User("sergey", "555-1");
        bank.addUser(sergey);
        bank.addAccountToUser(sergey, new Account("555-1", 1000d));
        bank.addAccountToUser(sergey, new Account("555-2", 200d));
        bank.deleteAccountFromUser(sergey, new Account("555-1"));
        bank.deleteAccountFromUser(sergey, new Account("555-2"));
        List<Account> expected = new ArrayList<>();
        assertThat(bank.getUserAccounts(sergey), is(expected));
    }

    /**
     * Transfer money from one user to another.
     */
    @Test
    public void whenTransferMoneyFromAnotherThenItIsDone() {
        Bank bank = new Bank();
        User sergey = new User("sergey", "555-1");
        User anna = new User("anna", "222-1");
        bank.addUser(sergey);
        bank.addUser(anna);
        bank.addAccountToUser(sergey, new Account("555-1", 1000d));
        bank.addAccountToUser(anna, new Account("222-1", 200d));
        double amount = 99.99d;
        double annaMoney = bank.getUserAccounts(anna).get(0).getValue();
        double expected = annaMoney + amount;
        bank.transferMoney(sergey, new Account("555-1"), anna, new Account("222-1"), amount);
        assertThat(bank.getUserAccounts(anna).get(0).getValue(), is(expected));
    }
}