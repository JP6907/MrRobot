package com.jp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jp.bean.Command;
import com.jp.bean.Message;
import com.jp.servive.QueryService;
import com.jp.util.JDBCHelper;

/**
 * 列表页面初始化控制
 * @author Administrator
 *
 */
@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
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
		//从页面获取值
		String command = request.getParameter("command");
		String description = request.getParameter("description");
		//向页面传值
		request.setAttribute("command", command);
		request.setAttribute("description", description);
		//查询获取Message信息列表
		List<Command> commandList = QueryService.queryCommandList(command, description);
		
		//System.out.println(commandList.size());
		request.setAttribute("commandlist", commandList);
		//跳转到 list.jsp页面
		request.getRequestDispatcher("/jsp/back/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
