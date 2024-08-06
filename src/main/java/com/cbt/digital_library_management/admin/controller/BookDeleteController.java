package com.cbt.digital_library_management.admin.controller;

import java.io.IOException;

import com.cbt.digital_library_management.admin.dao.BookDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/deleteBook")
public class BookDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		boolean b=new BookDao().deleteBookByIdDao(id);
		
		if(b) {
			
			resp.sendRedirect("home-writer.jsp");
		}
	}
}
