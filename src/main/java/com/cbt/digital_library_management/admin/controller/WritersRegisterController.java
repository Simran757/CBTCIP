package com.cbt.digital_library_management.admin.controller;

import java.io.IOException;

import com.cbt.digital_library_management.admin.dao.Writersdao;
import com.cbt.digital_library_management.dto.Writers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(value="/writerRegister")
public class WritersRegisterController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		long phone=Long.parseLong(req.getParameter("phone"));
		Writers writer1=new Writers(email,  name, password, phone);
		
		Writers writer2=new Writersdao().saveWriterDao(writer1);
		if(writer2!=null) {
			req.setAttribute("msg", "Registerd!");
			req.getRequestDispatcher("writer-login.jsp").forward(req, resp);
		}
		else {
			req.setAttribute("msg", " notRegisterd!");
			req.getRequestDispatcher("register-writer.jsp").forward(req, resp);
		}
	}

}
