package com.infiflex.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		request.getParameter("action");
		String action = request.getParameter("action");
		String name = request.getParameter("value");
		if (action.equals("update")) {

			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
			Query query = new Query("Customer");
			query.addFilter("name", FilterOperator.EQUAL, name);
			PreparedQuery pq = datastore.prepare(query);

			Entity e = pq.asSingleEntity();
			request.setAttribute("nameList", e);
			ServletContext servletContext = request.getServletContext();
			RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/update.jsp");

			dispatcher.forward(request, response);
		}
		if (action.equals("updatedata")) {
			name = request.getParameter("name");
			String uname = request.getParameter("uname");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			String phno = request.getParameter("phno");
			String age = request.getParameter("age");
			String originalName = request.getParameter("originalName");

			//Key customerKey = KeyFactory.createKey("Customer", name);

			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

			Query query = new Query("Customer");
			query.addFilter("name", FilterOperator.EQUAL, originalName);
			PreparedQuery pq = datastore.prepare(query);
			Entity customer = pq.asSingleEntity();
			
			customer.setProperty("name", name);
			customer.setProperty("email", email);
			customer.setProperty("uname", uname);
			customer.setProperty("address", address);
			customer.setProperty("phno", phno);
			customer.setProperty("age", age);

			Date date = new Date();
			customer.setProperty("date", date);

			datastore.put(customer);
			System.out.println("data added");

			query = new Query("Customer").addSort("date", Query.SortDirection.DESCENDING);
			List<Entity> customers = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(10));
			// Session s = request.getSession(true);
			request.setAttribute("customerList", customers);

			System.out.println("Attribute set");
			ServletContext servletContext = request.getServletContext();
			RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/list.jsp");

			dispatcher.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		doRequest(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		doRequest(request, response);
	}

}
