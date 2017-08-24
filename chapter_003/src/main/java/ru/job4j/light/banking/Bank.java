package ru.job4j.light.banking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class Bank.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 23.08.2017
 */
public class Bank {
    /**
     * Bank accounts. Keep pairs User-Accounts.
     */
    private final Map<User, List<Account>> accounts = new HashMap<>();

    /**
     * Add user.
     *
     * @param user User.
     */
    public void addUser(User user) {
        if (!this.accounts.containsKey(user)) {
            this.accounts.put(user, new ArrayList<>());
        }
    }

    /**
     * Delete user.
     *
     * @param user User to delete
     */
    public void deleteUser(User user) {
        if (this.accounts.containsKey(user)) {
            this.accounts.remove(user);
        }
    }

    /**
     * Add account to user.
     *
     * @param user    Bank user.
     * @param account User account.
     */
    public void addAccountToUser(User user, Account account) {
        if (this.accounts.containsKey(user)) {
            if (!this.accounts.get(user).contains(account)) {
                this.accounts.get(user).add(account);
            }
        }
    }

    /**
     * Delete user account.
     *
     * @param user    User.
     * @param account User account.
     */
    public void deleteAccountFromUser(User user, Account account) {
        if (this.accounts.containsKey(user)) {
            if (this.accounts.get(user).contains(account)) {
                this.accounts.get(user).remove(account);
            }
        }
    }

    /**
     * Get user accounts.
     *
     * @param user User.
     * @return User accounts.
     */
    public List<Account> getUserAccounts(User user) {
        List<Account> userAccounts = null;
        if (this.accounts.containsKey(user)) {
            userAccounts = this.accounts.get(user);
        }
        return userAccounts;
    }

    /**
     * Transfer money from one user to another.
     *
     * @param srcUser    Transfer sourc user.
     * @param srcAccount Transfer source account.
     * @param dstUser    User Transfer destination user.
     * @param dstAccount User Transfer destination user account.
     * @param amount     Amount of money in transfer.
     * @return True if money were transferred successfully, false otherwise.
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {
        boolean result = false;
        if (this.accounts.containsKey(srcUser) && this.accounts.containsKey(dstUser)) {
            List<Account> srcAccounts = this.getUserAccounts(srcUser);
            List<Account> dstAccounts = this.getUserAccounts(dstUser);
            if (srcAccounts.contains(srcAccount) && dstAccounts.contains(dstAccount)) {
                amount = ((int) (amount * 100d)) / 100d;
                srcAccount = srcAccounts.get(srcAccounts.indexOf(srcAccount));
                dstAccount = dstAccounts.get(dstAccounts.indexOf(dstAccount));
                if (srcAccount.getValue() > amount) {
                    srcAccount.setValue(srcAccount.getValue() - amount);
                    dstAccount.setValue(dstAccount.getValue() + amount);
                }
            }
        }
        return result;
    }
}
