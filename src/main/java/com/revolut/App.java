package com.revolut;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.revolut.account.controller.AccountController;
import com.revolut.config.MainModule;

public class App 
{
    public static void main( String[] args )
    {
    Injector injector = Guice.createInjector(new MainModule());

    AccountController accountController = injector.getInstance(AccountController.class);
    accountController.configureRoutes();
    }
}
