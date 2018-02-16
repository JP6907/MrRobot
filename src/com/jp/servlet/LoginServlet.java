package com.jp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jp.servive.UserService;

/**
 * 登陆界面控制
 * @author Administrator
 *
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置编码格式
		request.setCharacterEncoding("utf-8");
		//获取页面值
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		//登陆
		UserService userService = new UserService();
		//如果登陆信息正确
		if(userService.managerLogin(userName, passWord)){
			request.getSession().setAttribute("loginSign", "true");
			response.sendRedirect(request.getContextPath() + "/list.action");
		}else{
			request.getRequestDispatcher("/jsp/login/loginFail.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
