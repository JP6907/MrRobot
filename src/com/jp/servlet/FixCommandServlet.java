package com.jp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jp.servive.MaintainService;

/**
 * �޸�ָ��
 * @author Administrator
 *
 */
@WebServlet("/FixCommandServlet")
public class FixCommandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FixCommandServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//���ñ����ʽ
		request.setCharacterEncoding("utf-8");
		//��ȡ�޸ĺ��ֵ
		String newDescription = request.getParameter("description");
		String newContent = request.getParameter("content");
		//��ȡ�޸�ǰ��ֵ
		String contentId = (String) request.getSession().getAttribute("contentId");
		String commandId = (String) request.getSession().getAttribute("commandId");
		String oldDescription = (String) request.getSession().getAttribute("description");
		String oldContent = (String) request.getSession().getAttribute("content");
		
		MaintainService maintainService = new MaintainService();
		//�޸�
		maintainService.fixCommand(commandId, contentId, 
				oldDescription, newDescription, oldContent, newContent);
		//ҳ����ת
		response.sendRedirect(request.getContextPath() + "/list.action");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
