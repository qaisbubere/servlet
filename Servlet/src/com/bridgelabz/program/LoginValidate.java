package com.bridgelabz.program;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class LoginValidate
 */
//@WebServlet("/LoginValidate")
public class LoginValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginValidate() {
        super();
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dbusername;
		int found=0;
		String msg="Invalid UserName";
		//response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		String username = request.getParameter("email");

		System.out.println(request.getParameter("username"));
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection object =  DriverManager.getConnection("jdbc:mysql://localhost:3306/gmailPage","root","shezan95");
			PreparedStatement pp = object.prepareStatement("select firstname from signup_details where username ='"+username+"'");
			ResultSet r = pp.executeQuery();
			PreparedStatement pst =  object.prepareStatement("select username from signup_details");
			ResultSet rs =  pst.executeQuery();
			
			if(r.next()){
				String fname = r.getString("firstname");
				request.setAttribute("firstname", fname);
			}
		
			HttpSession session = request.getSession();
			request.setAttribute("email", username);
			
			
			while(rs.next()){
			dbusername = rs.getString("username");
			if(dbusername.equals(username)){
				RequestDispatcher rd=request.getRequestDispatcher("gmailPasswordPage.jsp");  
		        rd.forward(request, response);
			}
			else{
				found++;
			}
			}
			if(found>0){
				response.getWriter().print("{success:invalid}");
			}		
			
		}
		catch(Exception e){
			
		}

		//doGet(request, response);
	}

}
