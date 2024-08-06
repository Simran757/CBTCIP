package com.cbt.digital_library_management.admin.controller;

import java.io.IOException;

import com.cbt.digital_library_management.admin.dao.Writersdao;
import com.cbt.digital_library_management.dto.Writers;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet (value="/writerLogin")
public class WriterLoginController extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session=req.getSession();
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	
	
	
	Writers writer2=new Writersdao().fetchWriterByEmailDao(email);
	if(writer2!=null) {
		if(writer2.getVerify().equalsIgnoreCase("yes")) {
		if(password.equals(writer2.getPassword())) {
			session.setAttribute("writerSession", email);
			req.getRequestDispatcher("home-writer.jsp").forward(req, resp);
		}else {
			req.setAttribute("msg", "wrong password");
			req.getRequestDispatcher("writer-login.jsp").forward(req, resp);
		}
		}else {
			req.setAttribute("msg", "You are not verified! Contact with admin!!!");
			req.getRequestDispatcher("writer-login.jsp").forward(req, resp);
		}
	}
	else {
		req.setAttribute("msg", " login Failed ");
		req.getRequestDispatcher("writer-login.jsp").forward(req, resp);
	}
}
}
