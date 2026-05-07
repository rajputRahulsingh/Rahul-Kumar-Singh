package banking_System;
import java.util.Scanner;

import banking_System.LoginService;

public class Main {
	  public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
     System.out.print("👤 Username: ");
     String username = sc.nextLine();
     System.out.print("🔒 Password: ");
     String password = sc.nextLine();

     if (!LoginService.login(username, password)) {
         System.out.println("❌ Login failed. Exiting...");
         return;
     }
     
     AccountService as = new AccountService();
     TransactionService ts = new TransactionService();
     while (true) {

			System.out.println("\n🏦 Banking Management System");
			System.out.println("1. Create Account");
			System.out.println("2. Deposit Money");
			System.out.println("3. Withdraw Money");
			System.out.println("4. Check Balance");
			System.out.println("5. View All Customers");
			System.out.println("6. Customer Transaction Details");
			System.out.println("7. Exit");

			System.out.print("Choose Option: ");
            
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:

				System.out.print("Enter Account Holder Name: ");
				String name = sc.nextLine();

				System.out.print("Enter Initial Balance: ");
				double balance = sc.nextDouble();

				as.createAccount(name, balance);

				break;

			case 2:

				System.out.print("Enter Account ID: ");
				int did = sc.nextInt();

				System.out.print("Enter Deposit Amount: ");
				double damount = sc.nextDouble();

				ts.deposit(did, damount);

				break;

			case 3:

				System.out.print("Enter Account ID: ");
				int wid = sc.nextInt();

				System.out.print("Enter Withdraw Amount: ");
				double wamount = sc.nextDouble();

				ts.withdraw(wid, wamount);

				break;

			case 4:

				System.out.print("Enter Account ID: ");
				int bid = sc.nextInt();

				ts.checkBalance(bid);

				break;

			case 5:

				as.viewAllCustomers();

				break;
			case 6:

				System.out.print("Enter Account ID : ");
				int tid = sc.nextInt();

				ts.customerTransactionDetails(tid);

				break;

			case 7:

				System.out.println("Thank You");
				break;

			default:

				System.out.println("Invalid Choice");
			}
		}
     
     
     
     
	  }
}
