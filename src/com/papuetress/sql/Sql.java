package com.papuetress.sql;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Sql {

	public static JFrame frame;
	String dbName = "test";
	String url = "jdbc:mysql://localhost:3306/" + dbName ;
	String user = "";
	String password = "";
	Connection myConn = null;
	Statement myStmt = null;

	void sqlCheck1() {
		boolean bool = true;
		while (bool) {
			String fullName = JOptionPane.showInputDialog(frame,
					"Insert your Full Name");
			if (fullName == null) {
				bool = false;
				break;
			}
			if (fullName.equals("")) {
				continue;
			}
			String yourEmail = JOptionPane.showInputDialog(frame,
					"Insert Email Address");
			if (yourEmail == null) {
				bool = false;
				break;
			}
			if (yourEmail.equals("")) {
				continue;
			} else {

				String emp = "insert into user "; // user is the name of the
													// table
				String req = " (FullName, Email)"; // table names from SQL
				String val = " values ( '";
				String space = "' , '";
				String fnl = "')";
				String ghi = "'";
				String key = "select Email from user where Email like ";
				String q = key + ghi + yourEmail + ghi;

				try {
					// 1. Get a connection to database
					myConn = DriverManager.getConnection(url, user, password);

					// 2. Create a statement
					myStmt = myConn.createStatement();
					// 3. Get ResultSet
					ResultSet rs2 = myStmt.executeQuery(q);
					Audio start = new Audio();
					if (!rs2.isBeforeFirst()) {
						/*
						 * here if the result is empty means the email i was
						 * trying to search was not in database and it will be
						 * inserted now "fullName" && "yourEmail" are the inputs
						 */
						String sql = emp + req + val + fullName + space
								+ yourEmail + fnl;
						myStmt.executeUpdate(sql);

						start.audioCheck(0);
						JOptionPane.showMessageDialog(frame,
								"Not in database, Inserted now");
						bool = false;
					} else {
						start.audioCheck(1);
						JOptionPane.showMessageDialog(frame,
								"Allready in database");
						bool = false;
					}

				} catch (Exception exc) {
					exc.printStackTrace();
				}
			}
		}
	}

	void sqlCheck2() {

		boolean bool = true;
		while (bool) {

			String yourEmail = JOptionPane.showInputDialog(frame,
					"Insert Email Address");
			if (yourEmail == null) {
				bool = false;
				break;
			}
			if (yourEmail.equals("")) {
				continue;
			} else {
				

			String ghi = "'";
			String key = "select Email from user where Email like ";
			String q = key + ghi + yourEmail + ghi;

			try {
				// 1. Get a connection to database
				myConn = DriverManager.getConnection(url, user, password);

				// 2. Create a statement
				myStmt = myConn.createStatement();
				// 3. Get ResultSet
				ResultSet rs2 = myStmt.executeQuery(q);
				Audio start = new Audio();
				if (!rs2.isBeforeFirst()) {
					start.audioCheck(4);
					JOptionPane.showMessageDialog(frame,
							"There is no such data ");
					bool = false;
				} else {

					while (rs2.next()) {

						// will display the found values
						String text = rs2.getString("Email");
						String textf = "The email " + text
								+ " was found in database";
						start.audioCheck(2);
						JOptionPane.showMessageDialog(frame, textf);

					}
					bool = false;
					break;
				}

			} catch (Exception exc) {
				exc.printStackTrace();
			}

			}
		}
	}

	void sqlCheck3() {

		boolean bool = true;
		while (bool) {

			String tableName = JOptionPane.showInputDialog(frame,
					"Enter Table Name, DEV ONLY !");
			if (tableName == null) {
				bool = false;
				break;
			}
			if (tableName.equals("")) {
				continue;
			} else {
				

			String key = "select * from " + tableName;
			String q = key;

			try {
				// 1. Get a connection to database
				myConn = DriverManager.getConnection(url, user, password);

				// 2. Create a statement
				myStmt = myConn.createStatement();
				// 3. Get ResultSet
				ResultSet rs2 = myStmt.executeQuery(q);
				Audio start = new Audio();
				if (!rs2.isBeforeFirst()) {
					start.audioCheck(4);
					JOptionPane.showMessageDialog(frame, "Table is emplty ");
					bool = false;
					break;
				} else {

					while (rs2.next()) {

						// will display the found values
						String nume = rs2.getString(2);
						String email = rs2.getString(3);
						String textFinal = "Numele " + nume + ", email : "
								+ email;
						BufferedWriter writer = null;

						try {
							writer = new BufferedWriter(new FileWriter(
									"res/sql.txt",
									true));
							writer.write(textFinal);

						} catch (IOException e2) {
						} finally {
							try {
								if (writer != null)
									writer.close();
							} catch (IOException e2) {
							}
						}

					}
					start.audioCheck(3);
					JOptionPane
							.showMessageDialog(frame,
									"Data was saved in -D:/Workplace/Sql-Database/res/sql.txt");
					bool = false;
					break;
				}

			} catch (Exception exc) {
				exc.printStackTrace();
			}

			}
		}
	}
}
