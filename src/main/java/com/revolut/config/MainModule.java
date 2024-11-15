package com.revolut.config;

import java.sql.SQLException;

import com.google.gson.Gson;
import com.google.inject.AbstractModule;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.revolut.account.dao.AccountDAO;
import com.revolut.account.dao.AccountDAOImpl;
import com.revolut.account.service.AccountService;
import com.revolut.account.service.AccountServiceImpl;

public class MainModule extends AbstractModule {
    @Override
    protected void configure() {
      bind(AccountService.class).to(AccountServiceImpl.class);
      try {
        bind(AccountDAO.class).toInstance(new AccountDAOImpl(new JdbcPooledConnectionSource("jdbc:h2:mem:myDb")));
        bind(Gson.class).toInstance(new Gson());
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }