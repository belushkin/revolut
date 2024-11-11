package com.revolut.sparkapp;

// import java.util.Objects;

// import spark.Spark;

public class SparkApp {

	// private static volatile SparkApp sparkApp = null;

	// private SparkApp() {

	// }


    public SparkApp registerControllers() {
		// // User controller API registrations
		// UserController.getInstance().registerGetAllUserAPI().registerGetUserByIdAPI()
		// 		.registerPostCreateUserAPI().registerDeleteUserAPI().registerUpdateUserAPI()
		// 		.registerCheckUserAPI();

		// // Account controller API registrations
		// AccountController.getInstance().registerGetAllAccountAPI().registerGetAccountByIdAPI()
		// 		.registerPostCreateAccountAPI().registerDeleteAccountAPI()
		// 		.registerUpdateAccountAPI().registerCheckAccountAPI().registerWithdrawAPI()
		// 		.registerDepositAPI().registerAmountAPI();
		// // Transaction controller API registrations
		// TransactionController.getInstance().registerTransactionAPI();
		return this;
	}

    // public SparkApp setPort(int port) {
	// 	port(port);
	// 	return this;
	// }

	// /**
	//  * @return {@link SparkApp}
	//  */
	// public SparkApp stop() {
	// 	Spark.stop();
	// 	return this;
	// }

	// // Double check locking singleton pattern
	// public static SparkApp getInstance() {
	// 	if (Objects.isNull(sparkApp)) {
	// 		synchronized (SparkApp.class) {
	// 			if (Objects.isNull(sparkApp)) {
	// 				sparkApp = new SparkApp();
	// 			}
	// 		}
	// 	}
	// 	return sparkApp;
	// }
}
