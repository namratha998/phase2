package flightbook.servlet;

import java.io.IOException; 
import java.sql.SQLException; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession; 
import database.ConnectionUtil; 
/** 
 * Servlet implementation class LoginOfAdmin 
 */ 
@WebServlet("/LoginOfAdmin") 
public class LoginOfAdmin extends HttpServlet { 
 private static final long serialVersionUID = 1L; 
 /** 
 * @see HttpServlet#HttpServlet() 
 */ 
 public LoginOfAdmin() { 
 super(); 
 // TODO Auto-generated constructor stub 
 } 
 /** 
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) 
 */ 
 protected void doPost(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException { 
 // TODO Auto-generated method stub 
 String email=request.getParameter("email"); 
 String password=request.getParameter("password"); 
 try { 
 ConnectionUtil dao=new ConnectionUtil(); 
 if(dao.checkAdmin(email,password)) { 
 response.sendRedirect("AdminHome.jsp"); 
 } 
 else { 
 HttpSession session=request.getSession(); 
 session.setAttribute("message", "Invalid Details"); 
 response.sendRedirect("AdminPage.jsp"); 
 } 
 } catch (ClassNotFoundException | SQLException e) { 
 // TODO Auto-generated catch block 
 e.printStackTrace(); 
 } 
 }
}