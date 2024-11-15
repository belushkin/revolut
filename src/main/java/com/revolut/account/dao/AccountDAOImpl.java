package com.revolut.account.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.revolut.account.domain.Account;
import com.revolut.account.exceptions.AccountNotFoundException;

public class AccountDAOImpl extends BaseDaoImpl<Account, Integer> implements AccountDAO {
    public AccountDAOImpl(ConnectionSource connectionSource) throws SQLException {
      super(connectionSource, Account.class);
      TableUtils.createTableIfNotExists(connectionSource, Account.class);
    }
  
    @Override
    public Collection<Account> getAccounts() {
      Collection<Account> accounts = new ArrayList<>();
      super.forEach(accounts::add);
      return accounts;
    }
  
    @Override
    public Account getAccount(int id) throws AccountNotFoundException {
      try {
        Account account = super.queryForId(id);
        if (account == null) {
          throw new AccountNotFoundException(String.format("Account with ID %s not found", id));
        }
        return account;
      } catch (SQLException e) {
        throw new RuntimeException(e.getCause());
      }
    }
  
    @Override
    public Account createAccount(Account account) {
      try {
        super.create(account);
      } catch (SQLException e) {
        throw new RuntimeException(e.getCause());
      }
      return account;
    }
  
    @Override
    public void updateAccounts(Account... accounts) {
      TransactionManager tx = new TransactionManager(super.getConnectionSource());
      try {
        TransactionManager.callInTransaction("accounts", super.getConnectionSource(), () -> {
          for (Account account: accounts) {
             AccountDAOImpl.super.update(account);
          }
          return tx;
        });
      } catch (SQLException e) {
        throw new RuntimeException(e.getCause());
      }
    }
  }
