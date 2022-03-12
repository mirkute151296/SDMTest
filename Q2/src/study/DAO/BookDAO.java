package study.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import study.entity.Book;

public class BookDAO {
	
	public static Connection makeConnection() throws ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String jdbc_url = "jdbc:mysql://localhost:3306/db1";
		String uname = "root";
		String pass = "root";
		
		Connection con =DriverManager.getConnection(jdbc_url,uname,pass);
		System.out.println("Connection Established Successfully ");

	    return con;
	}
	
	
	public void addBook(String name, String isbn, int price, String author) 
	{
		
		Connection con;
		try {
			con = makeConnection();
			String sql = "insert into book values (default,?,?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, isbn);
			pstmt.setString(3,author);
			pstmt.setInt(4,price);
			
			pstmt.execute();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public Book searchBook(String bname) throws SQLException
	{
		Connection con;
		Book book = new Book();
		try {
			con = makeConnection();
			String sql = "select * from book where book_name = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, bname);
			
			ResultSet rs =   pstmt.executeQuery();	
			
			while(rs.next())
			{
				String name = rs.getString("book_name");
				String isbn = rs.getString("isbn");
				String author = rs.getString("author");
				int price = rs.getInt("price");
				
				book.author = author;
				book.isbn = isbn;
				book.name= name;
				book.price = price;
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
		return book;
	}
}
