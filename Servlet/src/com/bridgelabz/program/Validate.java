package com.bridgelabz.program;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Validate
 */
//@WebServlet("/Validate")
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    /*public Validate() {
        super();
        // TODO Auto-generated constructor stub
    }*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 

			/**
			 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
			 */
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				String firstname = request.getParameter("firstname");
				String lastname = request.getParameter("lastname");
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String month = request.getParameter("month");
				String day = request.getParameter("day");
				String year = request.getParameter("year");
				String gender = request.getParameter("gender");
				String number = request.getParameter("mobilenumber");
				String currentemail = request.getParameter("currentemail");
				String location = request.getParameter("location");
				
				System.out.println(request.getParameter("firstname"));
				try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection object =  DriverManager.getConnection("jdbc:mysql://localhost:3306/gmailPage","root","shezan95");
				PreparedStatement pst =  object.prepareStatement("insert into signup_details(firstname,lastname,username,password,month,day,year,gender,mobilenumber,currentemail,location) values(?,?,?,?,?,?,?,?,?,?,?)");
				pst.setString(1, firstname);
				pst.setString(2, lastname);
				pst.setString(3, username);
				pst.setString(4, password);
				pst.setString(5, month);
				pst.setString(6, day);
				pst.setString(7, year);
				pst.setString(8, gender);
				pst.setString(9, number);
				pst.setString(10, currentemail);
				pst.setString(11, location);

				out.print(lastname);
				out.print(username);
				out.print(password);
				out.print(month);
				out.print(day);
				out.print(year);
				int i=pst.executeUpdate();
				if(i>0){
					System.out.println("entered successfully");

				}
				else{
					System.out.println("failed");
				}
			
			}catch(Exception e){
				e.printStackTrace();
			}
			}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
/	 */
	protected void doget(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
