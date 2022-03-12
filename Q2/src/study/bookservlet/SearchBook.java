package study.bookservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.DAO.BookDAO;
import study.entity.Book;


@WebServlet("/getBook")
public class SearchBook extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		
		BookDAO dao = new BookDAO();
		
		try {
			Book book = dao.searchBook(name);
			
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html");
			pw.append("<html><body>");
			pw.append("<p>"+book.name+"<p>");
			pw.append("<p>"+book.price+"<p>");
			pw.append("<p>"+book.isbn+"<p>");
			pw.append("<p>"+book.author+"<p>");
			pw.append("</body></html>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
}
