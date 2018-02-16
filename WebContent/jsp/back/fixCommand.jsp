<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.jp.bean.Command,com.jp.bean.Command_Content,java.util.ArrayList,java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
		<title>小鹏后台管理系统</title>
		<link href="<%=basePath %>resource/css/all.css" rel="stylesheet" type="text/css" />
		<script src="<%=basePath%>resource/js/common/jquery-1.8.0.min.js"></script>
		<script src="<%=basePath%>resource/js/back/list.js"></script>
	</head>
	<body style="background: #e1e9eb;">
		<form action="<%=basePath%>list.action" id="fixCommandForm" method="post">
			<div class="right">
				<div class="current">当前位置：<a href="javascript:void(0)" style="color:#6E6E6E;">指令管理</a> &gt; 指令修改</div>
				<div class="rightCont">
					<p class="g_title fix">修改指令 <a class="btn03" href="<%=basePath %>list.action">返回</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn03" href="javascript:fixCommand('<%=basePath%>');">保存</a></p>
					<table class="tab1">
						<tbody>
									<%
										String command = request.getParameter("command");
										String description = request.getParameter("description");
										String content = request.getParameter("content");
										String contentId = request.getParameter("contentId");
										String commandId = request.getParameter("commandId");
										//session中保存原来的值
										request.getSession().setAttribute("contentId", contentId);
										request.getSession().setAttribute("commandId", commandId);
										request.getSession().setAttribute("description", description);
										request.getSession().setAttribute("content", content);
										if(command==null){
											command = "";
										}if(description==null){
											description= "";
										}if(content==null){
											content="";
										}
									%>
							<tr>
								<td align="right">指令名称：</td>
								<td>
									<input name="command" type="text" style="width:180px;" class="allInput" value="<%=command%>" readonly="readonly" />
								</td>
							</tr>
							<tr>
								<td align="right">指令描述：</td>
								<td>
									<input name="description" type="text" style="width:180px;" class="allInput" value="<%=description%>"/>
								</td>
	       					</tr>
	       					<tr>
								<td align="right">指令内容：</td>
								<td>
									<textarea name="content" cols = "50" rows = "5" style="resize:none;font-size:20px"><%=content%></textarea>
								</td>
	       					</tr>
						</tbody>
					</table>
				</div>
			</div>
	    </form>
	</body>
</html>