package com.meizhuangge.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 4643397857282755816L;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("txtUserName");
		// String userPwd = request.getParameter("txtUserPwd");

		String value = "Welcome to your arrival：" + userName + ".";
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<script>");
		out.print("alert('" + value + "');");
		out.print("location='index.jsp';");
		out.print("</script>");

		String remPwd = request.getParameter("ckbRemPwd");
		//on
		if (remPwd != null) {
			Cookie ckUserName = new Cookie("currentUserName", userName);
			ckUserName.setMaxAge(100000);
			response.addCookie(ckUserName);
		}
		// response.sendRedirect("index.jsp");
	}
}
