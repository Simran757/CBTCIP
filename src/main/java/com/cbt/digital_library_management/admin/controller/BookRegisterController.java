package com.cbt.digital_library_management.admin.controller;

import java.io.IOException;
import java.io.InputStream;

import com.cbt.digital_library_management.admin.dao.BookDao;
import com.cbt.digital_library_management.admin.dao.Writersdao;
import com.cbt.digital_library_management.dto.Books;
import com.cbt.digital_library_management.dto.Writers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet(value = "/bookRegister")
@MultipartConfig(maxFileSize = 1024*1024*5,maxRequestSize = 1024*1024*5)
public class BookRegisterController extends HttpServlet{

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session=req.getSession();
	String name=req.getParameter("name");

	double price=Double.parseDouble(req.getParameter("price"));
	Part part=req.getPart("image");
	InputStream inputstream=part.getInputStream();
	String email=(String)session.getAttribute("writerSession");
	if(email!=null) {
		Writers writer=new Writersdao().fetchWriterByEmailDao(email);
	Books book=new Books(name,  price, inputstream.readAllBytes(), writer);
	Books book2=new BookDao().saveBooksDao(book);
	if(book2!=null) {
	req.setAttribute("msg", "Book registered");
	req.getRequestDispatcher("book-register.jsp").forward(req, resp);
	}else {
		req.setAttribute("msg", "Book not registered");
		req.getRequestDispatcher("book-register.jsp").forward(req, resp);
	}
	}else {
		req.setAttribute("msg", "Please login with writer details");
		req.getRequestDispatcher("writer-login.jsp").forward(req, resp);
	}
}
}
