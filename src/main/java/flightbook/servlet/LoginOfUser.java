package flightbook.servlet;
import java.io.IOException; 
import java.sql.SQLException; 
import java.util.HashMap; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession; 
import database.ConnectionUtil; 
/** 
 * Servlet implementation class LoginOfUser 
 */ 
@WebServlet("/LoginOfUser") 
public class LoginOfUser extends HttpServlet { 
 private static final long serialVersionUID = 1L; 
 /** 
 * @see HttpServlet#HttpServlet() 
 */ 
 public LoginOfUser() { 
 super(); 
 // TODO Auto-generated constructor stub 
 } 
/** 
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) 
 */ 
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
ServletException, IOException { 
 // TODO Auto-generated method stub 
 String email=request.getParameter("email"); 
 String password=request.getParameter("password"); 
 try { 
 ConnectionUtil dao=new ConnectionUtil(); 
 HashMap<String,String> user=dao.checkUser(email,password); 
 HttpSession session=request.getSession(); 
 if(user!=null) { 
 session.setAttribute("user", user); 
 response.sendRedirect("Home.jsp"); 
 } 
 else { 
 session.setAttribute("message", "Invalid Details"); 
 response.sendRedirect("UserPage.jsp"); 
 } 
 } catch (ClassNotFoundException | SQLException e) { 
 // TODO Auto-generated catch block 
 e.printStackTrace(); 
 } 
} 
} 