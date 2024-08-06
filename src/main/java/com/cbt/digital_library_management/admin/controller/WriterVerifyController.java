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

@WebServlet(value = "/verifyController")
public class WriterVerifyController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession();
		
		Writersdao dao = new Writersdao();
		
		String email = req.getParameter("email");

		System.out.println(email);
		
		if(httpSession.getAttribute("adminSession")!=null) {
			Writers writer=dao.fetchWriterByEmailDao(email);
			
			if(writer.getVerify().equalsIgnoreCase("yes")) {
				dao.updateStatusToNoDao(email);
			}else {
				dao.updateStatusToYesDao(email);
			}
			resp.sendRedirect("admin-home.jsp");
		}else {
			req.setAttribute("msg","please login with admin and perform task...");
			req.getRequestDispatcher("admin-login.jsp").forward(req, resp);
		}
		
	}
}
