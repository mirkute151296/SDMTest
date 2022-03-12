package study.bookservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.DAO.BookDAO;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String p = request.getParameter("price");
		int price = Integer.parseInt(p);
		String author = request.getParameter("author");
		String isbn = request.getParameter("isbn");
		
		BookDAO dao = new BookDAO();
		dao.addBook(name, isbn, price, author);
	}
}
