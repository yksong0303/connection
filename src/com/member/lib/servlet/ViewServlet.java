package com.member.lib.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PREFIX ="/WEB-INF";
	private static final String SUFFIX =".jsp";
	//http://localhost/views/book/book_insert
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// uri => /views/book/book_insert
		String uri = request.getRequestURI();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(PREFIX + uri + SUFFIX);
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
