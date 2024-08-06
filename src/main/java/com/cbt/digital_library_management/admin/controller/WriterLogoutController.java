package com.cbt.digital_library_management.admin.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet(value = "/logoutWriter")
public class WriterLogoutController extends HttpServlet  {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession();
		
		if(httpSession.getAttribute("writerSession")!=null) {
			
			httpSession.invalidate();
			
			req.getRequestDispatcher("writer-login.jsp").forward(req, resp);
		}
	}
}
