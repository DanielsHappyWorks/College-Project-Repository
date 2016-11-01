package jdbc;

import java.sql.*;
import java.util.Scanner;

public class db {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/animeorganiser";

	// scanner for user input
	Scanner input = new Scanner(System.in);

	// Database credentials
	static final String USER = "root";
	static final String PASS = "";
	
	public static void main(String[] args) {
		db theApp = new db();
		theApp.start();
	}

	public void start() {
		// starts the db connection
		Connection conn = startConnection();
		// asks user to select a type of statement
		System.out.println("Please Select the type of statement you want to use:");
		// runs app until user exits
		mainMenu(conn);
	}

	public Connection startConnection() {
		Connection conn = null;
		System.out.println("Starting app");
		System.out.println("Attempting connection to Database...");
		try (Connection conn1 = DriverManager.getConnection(DB_URL, USER, PASS)) {
			System.out.println("Database connected!");
			return conn1;
		} catch (SQLException e) {
			System.out.println("Connection Failed");
			for (Throwable t : e) {
				t.printStackTrace();
			}
		}
		return conn;
	}
	
	public void mainMenu(Connection conn){
		//declares all variables
		boolean exit = false;
		int userChoice;
		
		while (exit == false) {
			// displays all types of statements
			userChoice = mainMenuText();

			if (userChoice == 1) {
				select(conn);
			} else if (userChoice == 2) {
				insert(conn);
			} else if (userChoice == 3) {
				update(conn);
			} else if (userChoice == 4) {
				delete(conn);
			} else if (userChoice == 5) {
				exit(conn);
			}
		}
	}
		
	public int mainMenuText() {
		System.out.println("1) Select all from anime or user comments");
		System.out.println("2) Insert a comment and rating");
		System.out.println("3) Update user comment by id");
		System.out.println("4) Delete user comment by id");
		System.out.println("5) Exit");
		System.out.println("Enter Your Choice:");
		return input.nextInt();
	}


	private void select(Connection conn) {
		Statement stmt = null;
		ResultSet rs;
		String sql;
		int userChoice;
		boolean selecting = true;
		
		System.out.println("1) Select all anime with studio");
		System.out.println("2) Select all comments and ratings");
		System.out.println("3) go back to main menu");
		System.out.println("Enter Your Choice:");
		userChoice = input.nextInt();
		
		while(selecting){
			if (userChoice == 1) {
			} else if (userChoice == 2) {
				System.out.println("Creating statement...");
			      try {
			    	  //prepares a statement
					stmt = conn.createStatement();
					sql = "SELECT User_id,User_name,User_rating,Anime_comment FROM user_watched_anime,users WHERE user_watched_anime.User_id = users.User_id ";
					rs = stmt.executeQuery(sql);
					//displays data
					while(rs.next()){
					System.out.print("User ID: " + rs.getInt("User_id"));
			         System.out.print(", Username: " + rs.getString("User_name"));
			         System.out.println(", Password: " + rs.getInt("User_rating"));
			         System.out.print(", Username: " + rs.getString("Anime_comment"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (userChoice == 3) {
				start();
			}
		}
	}

	private void insert(Connection conn) {
		// TODO Auto-generated method stub

	}

	private void update(Connection conn) {
		// TODO Auto-generated method stub

	}

	private void delete(Connection conn) {
		// TODO Auto-generated method stub

	}

	private void exit(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}