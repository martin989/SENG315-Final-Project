package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.json.JSONArray;
import org.json.JSONObject;

public class Book {

	int ID;
	String image;
	String name;
	String format;
	String author;
	String isbn;
	String category;
	Double price;
	
	public Book() {

	}

	public JSONArray listCategories() {
		MSSQLConnection mssqlConnection = new MSSQLConnection();
		String sqlString = "SELECT DISTINCT [Category] " + "FROM " + mssqlConnection.getDatabase() + ".dbo.Books WITH (NOLOCK)";

		SQLQuery sqlQuery = new SQLQuery();
		sqlQuery.setSqlString(sqlString);

		return sqlQuery.lstQuery();

	}
	
	public JSONArray listBooksByCategory() {
		MSSQLConnection mssqlConnection = new MSSQLConnection();
		String sqlString = "SELECT * " + "FROM " + mssqlConnection.getDatabase() + ".dbo.Books WITH (NOLOCK) " +
				"WHERE Category = '" + category + "'";
		SQLQuery sqlQuery = new SQLQuery();
		sqlQuery.setSqlString(sqlString);
		return sqlQuery.lstQuery();

	}
	
	public JSONObject getBook() {

		MSSQLConnection mssqlConnection = new MSSQLConnection();
		String sqlString = "SELECT * " + "FROM " + mssqlConnection.getDatabase() + ".dbo.Books WITH (NOLOCK) "
				+ "WHERE ID = " + ID + " ";

		SQLQuery sqlQuery = new SQLQuery();
		sqlQuery.setSqlString(sqlString);

		return sqlQuery.getQuery();

	}
	
	
	public String updateBook() {
		String message = "Book updated";

		try {

			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();

			String update = "UPDATE " + mssqlConnection.getDatabase() + ".dbo.books SET "
					+ "name=IsNull(NullIf(?,''),name),"
					+ "price=IsNull(? ,price) " +
					"WHERE ID=" + ID + "";

			PreparedStatement ps = connection.prepareStatement(update);

			ps.setString(1, name);
			ps.setDouble(2, price);
			
			ps.executeUpdate();

			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return message;
	}
	
	public String deleteBook() {

		String message = "Book deleted";

		try {
			
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			
			String delete = "DELETE FROM " + mssqlConnection.getDatabase() + ".dbo.books " + "WHERE ID="
					+ ID + "";

			PreparedStatement ps = connection.prepareStatement(delete);
			ps.executeUpdate();
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return message;

	}

	public String addBook() {

		String message = "Book Created";
		
		try {

			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();

			String add = "INSERT " + mssqlConnection.getDatabase() + ".dbo.books "
					+ "(name, image, format, author, isbn, category, price) VALUES (?,?,?,?,?,?,?)";

			PreparedStatement ps = connection.prepareStatement(add);

			ps.setString(1, name);
			ps.setString(2, image);
			ps.setString(3, format);
			ps.setString(4, author);
			ps.setString(5, isbn);
			ps.setString(6, category);
			ps.setFloat(7, price.floatValue());
			ps.executeUpdate();

			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return message;

	}
	
	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * @param format the format to set
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	
	//Getters and Setters
	
}
