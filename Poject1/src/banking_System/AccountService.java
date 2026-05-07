package banking_System;

import java.sql.*;

public class AccountService {

	// Create Account
	public void createAccount(String name, double balance) {

		try {

			Connection con = DBConnection.getConnection();

			String sql =
			"INSERT INTO accounts(name, balance) VALUES(?, ?)";

			PreparedStatement ps =
			con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setString(1, name);
			ps.setDouble(2, balance);

			int rows = ps.executeUpdate();

			if (rows > 0) {

				ResultSet rs = ps.getGeneratedKeys();

				if (rs.next()) {

					int accountId = rs.getInt(1);

					System.out.println("\nAccount Created Successfully");
					System.out.println("Account ID : " + accountId);
					System.out.println("Account Holder : " + name);
					System.out.println("Current Balance : " + balance);
				}

				rs.close();

			} else {

				System.out.println("Account Creation Failed");
			}

			ps.close();
			con.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	
	public void viewAllCustomers() {

		try {

			Connection con = DBConnection.getConnection();

			String sql = "SELECT * FROM accounts";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			System.out.println("\nID\tNAME\t\tBALANCE");

			while (rs.next()) {

				System.out.println(
						rs.getInt("id") + "\t"
						+ rs.getString("name") + "\t\t"
						+ rs.getDouble("balance"));
			}

			rs.close();
			ps.close();
			con.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}