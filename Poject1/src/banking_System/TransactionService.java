package banking_System;

import java.sql.*;

public class TransactionService {

	// Deposit Money
	public void deposit(int id, double amount) {

		try {

			Connection con = DBConnection.getConnection();

			String sql =
			"UPDATE accounts SET balance = balance + ? WHERE id = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setDouble(1, amount);
			ps.setInt(2, id);

			int rows = ps.executeUpdate();

			if (rows > 0) {

				System.out.println("Amount Deposited Successfully");

				// Insert Transaction Record
				String transactionSql =
				"INSERT INTO transactions(account_id, transaction_type, amount) VALUES(?,?,?)";

				PreparedStatement tps =
				con.prepareStatement(transactionSql);

				tps.setInt(1, id);
				tps.setString(2, "Deposited");
				tps.setDouble(3, amount);

				tps.executeUpdate();

				tps.close();

			} else {

				System.out.println("Account Not Found");
			}

			ps.close();
			con.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	// Withdraw Money
	public void withdraw(int id, double amount) {

		try {

			Connection con = DBConnection.getConnection();

			String checkSql =
			"SELECT balance FROM accounts WHERE id = ?";

			PreparedStatement checkPs =
			con.prepareStatement(checkSql);

			checkPs.setInt(1, id);

			ResultSet rs = checkPs.executeQuery();

			if (rs.next()) {

				double balance = rs.getDouble("balance");

				if (balance >= amount) {

					String sql =
					"UPDATE accounts SET balance = balance - ? WHERE id = ?";

					PreparedStatement ps =
					con.prepareStatement(sql);

					ps.setDouble(1, amount);
					ps.setInt(2, id);

					ps.executeUpdate();

					System.out.println("Withdrawal Successful");

					// Insert Transaction Record
					String transactionSql =
					"INSERT INTO transactions(account_id, transaction_type, amount) VALUES(?,?,?)";

					PreparedStatement tps =
					con.prepareStatement(transactionSql);

					tps.setInt(1, id);
					tps.setString(2, "Withdrawn");
					tps.setDouble(3, amount);

					tps.executeUpdate();

					tps.close();
					ps.close();

				} else {

					System.out.println("Insufficient Balance");
				}

			} else {

				System.out.println("Account Not Found");
			}

			rs.close();
			checkPs.close();
			con.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	// Check Balance
	public void checkBalance(int id) {

		try {

			Connection con = DBConnection.getConnection();

			String sql =
			"SELECT * FROM accounts WHERE id = ?";

			PreparedStatement ps =
			con.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				System.out.println("Account ID : " + rs.getInt("id"));
				System.out.println("Account Holder : " + rs.getString("name"));
				System.out.println("Current Balance : " + rs.getDouble("balance"));

			} else {

				System.out.println("Account Not Found");
			}

			rs.close();
			ps.close();
			con.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	// Customer Transaction Details
	public void customerTransactionDetails(int id) {

	    try {

	        Connection con = DBConnection.getConnection();

	        String sql =
	        "SELECT * FROM transactions WHERE account_id = ?";

	        PreparedStatement ps =
	        con.prepareStatement(sql);

	        ps.setInt(1, id);

	        ResultSet rs = ps.executeQuery();

	        boolean found = false;

	        System.out.println(
	        "\nACC_ID\tTYPE\t\tAMOUNT\t\tDATE & TIME");

	        while (rs.next()) {

	            found = true;

	            int accId = rs.getInt("account_id");

	            String type =
	            rs.getString("transaction_type");

	            double amount =
	            rs.getDouble("amount");

	            Timestamp dateTime =
	            rs.getTimestamp("transaction_date");

	            System.out.println(
	                    accId + "\t"
	                    + type + "\t\t"
	                    + amount + "\t\t"
	                    + dateTime);
	        }

	        if (!found) {

	            System.out.println("No Transaction Found");
	        }

	        rs.close();
	        ps.close();
	        con.close();

	    } catch (Exception e) {

	        e.printStackTrace();
	    }
	}
}