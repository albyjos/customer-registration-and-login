package com.techpalle.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.DataAccess;
import com.techpalle.model.Customer;
import com.techpalle.util.SuccessPage;

@WebServlet("/")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String path =request.getServletPath();
		
		switch(path) 
		{
		 case "/LogCustomer":
			validateCustomer(request,response);
		 case "/regCustomer":
				insertCustomer(request, response);
		 case "/reg":
		    	getRegistrationPage(request, response);
		 case "/log":
		    	getLogInPage(request, response);
		 default:
				getStartUpPage(request,response);
				break;
		}
	}

	private void validateCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		//Read the email and password from jsp page
		String e=request.getParameter("tbEmailLog");
		String p=request.getParameter("tbPassLog");
		
		//call the method present in DAO
		boolean res = DataAccess.validateCustomer(e, p);
		
		//condition and redirect user to destination page(success)
		if(res)
		{
			try 
			{
				RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
				//store the SuccessPage class data inside 

				SuccessPage sp= new SuccessPage();
				request.setAttribute("SuccessDetails", sp);
				
				rd.forward(request, response);
			} 
			catch (ServletException e1) 
			{
				e1.printStackTrace();
			} catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}
		else
		{
			getLogInPage(request, response);
		}
				
		
	}

	private void insertCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		// Read the data from jsp page
		String n = request.getParameter("tbName");
		String e = request.getParameter("tbEmail");
		long m = Long.parseLong(request.getParameter("tbMobile"));
		String p = request.getParameter("tbPassword");
		String s = request.getParameter("ddlStates");
		
		//store that data in customer object
		Customer c = new Customer(n, e, m, p, s);
		
		//call insetCustomer method present in dao by passing above object
		DataAccess.insertCustomer(c);
		
		//Redirect user to login page
		try 
		{
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e1) 
		{
			e1.printStackTrace();
		} catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		
	}

	private void getRegistrationPage(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			RequestDispatcher rd = request.getRequestDispatcher("Registration.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException | IOException e) 
		{
			e.printStackTrace();
		}
		
	}

	private void getLogInPage(HttpServletRequest request, HttpServletResponse response) 
	{

		try 
		{
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException | IOException e) 
		{
			e.printStackTrace();
		}
	}

	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			RequestDispatcher rd = request.getRequestDispatcher("customer_management.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException | IOException e) 
		{
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

