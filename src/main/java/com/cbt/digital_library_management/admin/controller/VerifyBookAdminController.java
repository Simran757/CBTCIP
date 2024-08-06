package com.cbt.digital_library_management.admin.controller;

import java.io.IOException;

import com.cbt.digital_library_management.admin.dao.BookDao;
import com.cbt.digital_library_management.dto.Books;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet (value="/verifyBookAdmin")
public class VerifyBookAdminController extends HttpServlet{
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	BookDao dao=  new BookDao();
	Books book=dao.fetchBookByIdDao(id);
	
	if(book!=null) {
		if(book.getVerifyStatus().equalsIgnoreCase("no")) {
			book.setVerifyStatus("yes");
			dao.verifyBookByAdminDao(book);
		}
	}
	
	req.getRequestDispatcher("admin-home.jsp").forward(req, resp);
}
}
