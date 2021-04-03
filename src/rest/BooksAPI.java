package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import service.BookService;


@Path("/books")
public class BooksAPI {
	
	@GET
	@Path("/listByCategory/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public String listBooksByCategory(@PathParam("id") String categoryName) {
		
		JSONArray books = BookService.listBooksByCategory(categoryName);		
		return books.toString();
		
	}
	
	@GET
	@Path("/listCategories/")
	@Produces("application/json")
	@Consumes("application/json")
	public String listCategories() {
		JSONArray books = BookService.listCategories();
		return books.toString();
		
	}
	
	@GET
	@Path("/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public String getBook(@PathParam("id") Integer id) {	
		JSONObject book = BookService.getBook(id);	
		return book.toString();
		
	}
	
	@PUT
	@Produces("application/json")
	@Consumes("application/json")
	public String updateBook(String inputParms) {
		try {
			JSONObject result = BookService.updateBook(new JSONObject(inputParms));

			return result.toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "updateBookAPI Failed";
		}
	}
	
	@DELETE
	@Produces("application/json")
	@Consumes("application/json")
	public String deleteBook(String inputParms) {
		System.out.println(inputParms);
		try {
			JSONObject result = BookService.deleteBook(new JSONObject(inputParms));
			
			return result.toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "deleteCategoryAPI Failed";
		}
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public String addBook(String inputParms) {
		try {
			JSONObject result = BookService.addBook(new JSONObject(inputParms));
			
			return result.toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "addCategoryAPI Failed";
		}
	}
}
