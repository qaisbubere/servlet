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

import com.mysql.jdbc.Messages;

/**
 * Servlet implementation class PasswordValidate
 */
//@WebServlet("/PasswordValidate")
public class PasswordValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordValidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession ss = request.getSession();
		String username = (String)ss.getAttribute("email");
		String password = (String)request.getParameter("password");
		out.print(username);
		out.println(password);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection object =  DriverManager.getConnection("jdbc:mysql://localhost:3306/gmailPage","root","shezan95");
			/*PreparedStatement pst =  object.prepareStatement("select password from signup_details where username = '"+username+"'");*/
			PreparedStatement pst =  object.prepareStatement("select username,password from signup_details");
			ResultSet rs =  pst.executeQuery();
			
			while(rs.next()){
				String pass = rs.getString("password");
				String user = rs.getString("username");
				if(pass.equals(password) && user.equals(username))
				{
					RequestDispatcher rd=request.getRequestDispatcher("welcome.html");  
			        rd.forward(request, response);
				}
			}
		}
		catch(Exception e){
			
		}
	}

}
