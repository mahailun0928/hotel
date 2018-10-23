package com.mhl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baidu.ueditor.ActionEnter;

@WebServlet("/ueditor")
public class UEditorController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		String action = request.getParameter("action");
		ServletContext context = request.getServletContext();
		String rootPath = context.getRealPath( "/" );
		String str = new ActionEnter( request, rootPath ).exec();
		if( action!=null && (action.equals("listfile") || action.equals("listimage") ) ){  
	        rootPath = rootPath.replace("\\", "/");  
	        str = str.replaceAll(rootPath, "/");  
	    }
		PrintWriter out = response.getWriter();
		out.write(str);
		out.flush();
		out.close();
	}
}

