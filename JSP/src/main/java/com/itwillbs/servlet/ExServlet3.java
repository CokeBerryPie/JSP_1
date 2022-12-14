package com.itwillbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// web.xml  매핑과 @WebServlet 매핑이 동일할 경우 에러 발생
// => 매핑이 다른경우 사용가능(권장X)

//@WebServlet("/ex4")
public class ExServlet3 extends HttpServlet {
    int cnt;
	// http://localhost:8088/JSP/test.ex3
	// http://localhost:8088/JSP/아이티윌.ex3

	@Override
	public void init() throws ServletException {
		System.out.println(" 서블릿 최초 생성할때 실행! ");
		cnt = 0;
		System.out.println(" 서블릿 객체를 초기화! cnt = "+cnt);
	}
	// doGET() 오바라이딩 + web.xml 매핑  (/ex3)
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ExServlet3_doGet() 호출");
		System.out.println("cnt : "+(++cnt));
		
		//response.getWriter().append("cnt :" +(cnt));
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println(" <html> ");
		out.println(" <head></head> ");
		out.println(" <body> ");
		out.println(" <h1> cnt : "+cnt+"</h1> ");		
		out.println(" </body> ");
		out.println(" </html> ");
		
		out.close();
		
	}

	@Override
	public void destroy() {
		System.out.println(" 서블릿 소멸될때 실행!! ");
	}

	
	

}
