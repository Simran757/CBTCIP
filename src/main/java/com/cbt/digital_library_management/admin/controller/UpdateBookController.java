package com.cbt.digital_library_management.admin.controller;

import java.io.IOException;
import java.io.InputStream;

import com.cbt.digital_library_management.admin.dao.BookDao;
import com.cbt.digital_library_management.dto.Books;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet(value = "/bookUpdate")
@MultipartConfig(fileSizeThreshold=1024*1024,maxFileSize=1024*1024*5,maxRequestSize=1024*1024*5*5)
public class UpdateBookController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		
		double price = Double.parseDouble(req.getParameter("price"));
		
		Part part = req.getPart("image");
		
		Books book=null;
		
		System.out.println(part);
		
		if(part!=null) {
			InputStream inputStream = part.getInputStream();
			book=new Books(id, name,  price, inputStream.readAllBytes());
		}else {
			book=new Books(id, name,  price, null);
		}

		Books book1=new BookDao().updateBookByIdDao(book);
		
		req.getRequestDispatcher("home-writer.jsp").forward(req, resp);
	}
}
