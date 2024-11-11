package com.revolut.account.dao;

import java.util.Collection;

import com.revolut.account.domain.Account;
import com.revolut.account.exceptions.AccountNotFoundException;

public interface AccountDAO {
  Collection<Account> getAccounts();

  Account getAccount(int id) throws AccountNotFoundException;

  Account createAccount(Account account);

  void updateAccounts(Account... accounts);
}
