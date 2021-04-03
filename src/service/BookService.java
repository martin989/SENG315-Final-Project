package service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.Book;

public class BookService {
	
	public static JSONArray listBooksByCategory(String categoryName) {
		JSONArray books = new JSONArray();
		Book book = new Book();
		book.setCategory(categoryName);
		books = book.listBooksByCategory();
		return books;
	}
	
	public static JSONArray listCategories() {
		JSONArray books = new JSONArray();
		Book book = new Book();
		books = book.listCategories();
		return books;
	}
	
	public static JSONObject getBook(int id) {
		JSONObject bookJO = new JSONObject();
		Book book = new Book();
		book.setID(id);
		bookJO = book.getBook();
		return bookJO;
	}
	
	public static JSONObject updateBook(JSONObject inputParms) {

		String message = "";

		JSONObject result = new JSONObject();

		try {
			String name = inputParms.getString("bookName");
			Double price = inputParms.getDouble("bookPrice");
			int id = inputParms.getInt("bookID");
			
			Book book = new Book();
			book.setName(name);
			book.setID(id);
			book.setPrice(price);
			message = book.updateBook();

			result.put("message", message);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	
	public static JSONObject deleteBook(JSONObject inputParms) {

		String message = "";

		JSONObject result = new JSONObject();

		try {

			Book book = new Book();
			int id = inputParms.getInt("bookID");
			book.setID(id);
			message = book.deleteBook();

			result.put("message", message);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	
	public static JSONObject addBook(JSONObject inputParms) {

		String message = "";

		JSONObject result = new JSONObject();

		try {
			
			String image = inputParms.getString("bookImage");
			String name = inputParms.getString("bookName");
			String format = inputParms.getString("bookFormat");
			String author = inputParms.getString("bookAuthor");
			String isbn = inputParms.getString("bookISBN");
			String category = inputParms.getString("bookCategory");
			double price = inputParms.getDouble("bookPrice");
			 
			Book book = new Book();
			book.setAuthor(author);
			book.setCategory(category);
			book.setFormat(format);
			book.setImage(image);
			book.setIsbn(isbn);
			book.setName(name);
			book.setPrice(price);
			
			message = book.addBook();

			result.put("message", message);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
}
