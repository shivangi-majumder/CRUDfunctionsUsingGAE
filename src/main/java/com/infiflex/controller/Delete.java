package com.infiflex.controller;

import java.io.IOException;
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
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");
		if (action.equals("delete")) {
			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
			System.out.println("running");
			String name = request.getParameter("value");
			Query query = new Query("Customer");
			query.addFilter("name", FilterOperator.EQUAL, name);
			PreparedQuery pq = datastore.prepare(query);
			Entity customer = pq.asSingleEntity();
	
			datastore.delete(customer.getKey());
			query = new Query("Customer").addSort("date", Query.SortDirection.DESCENDING);
			List<Entity> customers = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(10));
			//Session s = request.getSession(true);
			request.setAttribute("customerList", customers);
			ServletContext servletContext = request.getServletContext();
			RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/list.jsp");
			
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

}
