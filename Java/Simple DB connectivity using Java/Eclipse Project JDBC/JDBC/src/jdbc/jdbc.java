package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class jdbc {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/animeorganiser";

	// scanner for user input and input data
	static Scanner inputInt = new Scanner(System.in);
	static Scanner inputString = new Scanner(System.in);
	static boolean exit = false;
	static int userChoice;

	// Database credentials
	static final String USER = "root";
	static final String PASS = "";

	public static void main(String[] args) {
		Statement stmt = null;
		ResultSet rs = null;
		String sql;

		System.out.println("Starting app");
		System.out.println("Attempting connection to Database...");
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
			System.out.println("Database connected!");

			while (exit == false) {
				System.out.println("1) Select from anime or user comments");
				System.out.println("2) Insert an anime");
				System.out.println("3) Update an anime by id");
				System.out.println("4) Delete user comment by id");
				System.out.println("5) Exit");
				System.out.println("Enter Your Choice:");
				userChoice = inputInt.nextInt();

				if (userChoice == 1) {
					boolean select = true;
					while (select == true) {
						System.out.println("1) Select anime with studio");
						System.out.println("2) Select comments and ratings");
						System.out.println("3) go back to main menu");
						System.out.println("Enter Your Choice:");
						userChoice = inputInt.nextInt();

						if (userChoice == 1) {
							System.out.println("Creating statement...");
							// prepares a statement
							stmt = conn.createStatement();
							sql = "SELECT Anime_name, Anime_id, Episode_count, Genre, Studio_name   FROM anime,studio WHERE studio.Studio_id = anime.Studio_id ";
							System.out.println("Execting Query...");
							rs = stmt.executeQuery(sql);
							System.out.println("Printing Resuts...");
							// displays data
							while (rs.next()) {
								System.out.println("ANIME NAME: " + rs.getString("Anime_name"));
								System.out.print("ANIME ID: " + rs.getInt("Anime_id"));
								System.out.print(", EPISODE COUNT: " + rs.getInt("Episode_count"));
								System.out.println(", GENRE: " + rs.getString("Genre"));
								System.out.println("STUDIO NAME: " + rs.getString("Studio_name"));
								System.out.println();
							}
						} else if (userChoice == 2) {
							System.out.println("Creating statement...");
							// prepares a statement
							stmt = conn.createStatement();
							sql = "SELECT users.User_id,Anime_id,User_name,User_rating,Anime_comments FROM user_watched_anime,users WHERE user_watched_anime.User_id = users.User_id ";
							System.out.println("Execting Query...");
							rs = stmt.executeQuery(sql);
							System.out.println("Printing Resuts...");
							// displays data
							while (rs.next()) {
								System.out.print("USER ID: " + rs.getInt("User_id"));
								System.out.println(", ANIME ID: " + rs.getInt("Anime_id"));
								System.out.print(", USERNAME: " + rs.getString("User_name"));
								System.out.println(", RATING: " + rs.getInt("User_rating"));
								System.out.println(", COMMENT: " + rs.getString("Anime_comments"));
								System.out.println();
							}
						} else if (userChoice == 3) {
							select = false;
						}
					}
				} else if (userChoice == 2) {
					System.out.print("Enter Studio id:");
					int id = inputInt.nextInt();
					System.out.print("Enter Anime Name:");
					String name = inputString.nextLine();
					System.out.print("Enter Anime Description:");
					String desc = inputString.nextLine();
					System.out.print("Enter Epidode Count:");
					int eps = inputInt.nextInt();
					System.out.print("Enter Anime Genre:");
					String genre = inputString.nextLine();
					System.out.print("Enter Release Date (YYYY/MM/DD):");
					String rdate = inputString.nextLine();
					System.out.print("Enter Completion Date (YYYY/MM/DD):");
					String cdate = inputString.nextLine();

					System.out.println("Creating statement...");
					String insert = "INSERT INTO anime (Anime_id, Studio_id,Anime_name,Anime_Description,Episode_count,Genre,Anime_release_date,Anime_completion_date) "
							+ "VALUES (NULL, ?, ?, ?, ?,?, ?, ?)";
					PreparedStatement ps = conn.prepareStatement(insert);
					ps.setInt(1, id);
					ps.setString(2, name);
					ps.setString(3, desc);
					ps.setInt(4, eps);
					ps.setString(5, genre);
					ps.setString(6, rdate);
					ps.setString(7, cdate);
					System.out.println("Execting Query...");
					int count = ps.executeUpdate();

					if (count == 1) {
						System.out.println("Insert sucessful");
						System.out.println();
					}
				} else if (userChoice == 3) {
					System.out.print("Enter Anime id of anime you want to update:");
					int Anime_id = inputInt.nextInt();
					System.out.print("Enter Studio id:");
					int id = inputInt.nextInt();
					System.out.print("Enter Anime Name:");
					String name = inputString.nextLine();
					System.out.print("Enter Anime Description:");
					String desc = inputString.nextLine();
					System.out.print("Enter Epidode Count:");
					int eps = inputInt.nextInt();
					System.out.print("Enter Anime Genre:");
					String genre = inputString.nextLine();
					System.out.print("Enter Release Date (YYYY/MM/DD):");
					String rdate = inputString.nextLine();
					System.out.print("Enter Completion Date (YYYY/MM/DD):");
					String cdate = inputString.nextLine();

					System.out.println("Creating statement...");
					String update = "UPDATE anime SET Studio_id = ?," + 
					" Anime_name = ?, "
							+ "Anime_Description = ?,"
									 + "`Episode_count` = ?, "
							+ "`Genre` = ?, "
									 + "`Anime_release_date` = ?, "
							+ "`Anime_completion_date` = ?" 
									 + "WHERE Anime_id = ?";
					PreparedStatement ps = conn.prepareStatement(update);
					ps.setInt(1, id);
					ps.setString(2, name);
					ps.setString(3, desc);
					ps.setInt(4, eps);
					ps.setString(5, genre);
					ps.setString(6, rdate);
					ps.setString(7, cdate);
					ps.setInt(8, Anime_id);
					System.out.println("Execting Query...");
					int count = ps.executeUpdate();
					
					if (count == 1) {
						System.out.println("Insert sucessful");
						System.out.println();
					}
					
				} else if (userChoice == 4) {
					System.out.print("Enter Anime id of comment/rating you want to delete:");
					int Anime_id = inputInt.nextInt();
					System.out.print("Enter User id of comment/rating you want to delete:");
					int User_id = inputInt.nextInt();

					System.out.println("Creating statement...");
					String delete = "DELETE FROM user_watched_anime " + "WHERE User_id=? " + "AND Anime_id=?";
					PreparedStatement ps = conn.prepareStatement(delete);
					ps.setInt(1, User_id);
					ps.setInt(2, Anime_id);
					System.out.println("Execting Query...");
					int count = ps.executeUpdate();

					if (count == 1) {
						System.out.println("Insert sucessful");
						System.out.println();
					}

				} else if (userChoice == 5) {
					conn.close();
					stmt.close();
					rs.close();
					exit = true;
				}
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed");
			for (Throwable t : e) {
				t.printStackTrace();
			}
			main(args);
		}
	}
}
/*
 * System.out.println("Creating statement..."); //prepares a statement stmt =
 * conn.createStatement(); sql =
 * "INSERT INTO anime (Anime_id, Studio_id,Anime_name,Anime_Description,Episode_count,Genre,Anime_release_date,Anime_completion_date) VALUES (NULL, '"
 * +id+"', '"+name+"', '"+desc+"', '"+eps+"', '"+genre+"', '"+rdate+"', '"
 * +cdate+"')"; System.out.println("Execting Query..."); int result =
 * stmt.executeUpdate(sql); if (result == 1){ System.out.println(
 * "Insert sucessful");
 */

/*
 * System.out.println("Creating statement..."); //prepares a statement stmt =
 * conn.createStatement(); sql = "UPDATE anime SET Studio_id = '"+id+
 * "', Anime_name = '"+name+"', Anime_Description = '"+desc+
 * "', `Episode_count` = '"+eps+"', `Genre` = '"+genre+
 * "', `Anime_release_date` = '"+rdate+"', `Anime_completion_date` = '"+cdate+
 * "' WHERE Anime_id = "+Anime_id+""; System.out.println("Execting Query...");
 * int result = stmt.executeUpdate(sql); if (result == 1){ System.out.println(
 * "Insert sucessful");
 */

/*
 * sql = "DELETE FROM user_watched_anime WHERE User_id='"+User_id+
 * "' AND Anime_id='"+Anime_id+"'"; System.out.println("Execting Query..."); int
 * result = stmt.executeUpdate(sql); if (result == 1){ System.out.println(
 * "Insert sucessful"); } System.out.println();
 */
