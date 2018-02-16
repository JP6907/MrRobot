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
		<form action="<%=basePath%>list.action" id="mainForm" method="post">
			<div class="right">
				<div class="current">当前位置：<a href="javascript:void(0)" style="color:#6E6E6E;">指令管理</a> &gt; 指令列表     <a href="<%=basePath%>loginOut.action" style="float:right;">退出</a></div>
				<div class="rightCont">
					<p class="g_title fix">内容列表 <a class="btn03" href="<%=basePath %>jsp/back/addCommand.jsp">新 增</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn03" href="javascript:deleteBatch('<%=basePath%>');">删 除</a></p>
					<table class="tab1">
						<tbody>
							<tr>
								<td width="90" align="right">指令名称：</td>
								<td>
									<%
										String command = (String)request.getParameter("command");
										String description = (String)request.getParameter("description");
										if(command==null){
											command = "";
										}if(description==null){
											description= "";
										}
									%>
									<input name="command" type="text" class="allInput" value="<%=command%>" placeholder="指令名称..."/>
								</td>
								<td width="90" align="right">描述：</td>
								<td>
									<input name="description" type="text" class="allInput" value="<%=description%>" placeholder="指令描述..."/>
								</td>
	                            <td width="85" align="right"><input type="submit" class="tabSub" value="查 询" /></td>
	       					</tr>
						</tbody>
					</table>
					<div class="zixun fix">
						<table class="tab2" width="100%">
							<tbody>
								<tr>
								    <th><input type="checkbox" id="all" onclick="#"/></th>
								    <th>序号</th>
								    <th>指令编号</th>
								    <th>指令名称</th>
								    <th>描述</th>
								    <th>内容</th>
								    <th>操作</th>
								</tr>
								<%
									ArrayList<Command> commandList = (ArrayList<Command>)request.getAttribute("commandlist");
									int index = 0;
									for(Command comm:commandList){
										//获取回复列表
										List<Command_Content> contentList = comm.getContentList();
										for(Command_Content commandContent : contentList){
								%>
								<tr	
										<% if(index++%2!=0){
											%>
											style="background-color:#ECF6EE;"
											<% 
										}
									%>
								>
									<td><input type="checkbox" name="id" value="<%=commandContent.getId()%>"/></td>
									<td><%=index %></td>
									<td><%=comm.getId() %></td>
									<td><%=comm.getName() %></td>
									<td><%=comm.getDescription() %></td>
									<td><%=commandContent.getContent() %></td>
									<td>
										<a href="jsp/back/fixCommand.jsp?command=<%=comm.getName()%>&description=<%=comm.getDescription()%>&content=<%=commandContent.getContent()%>&contentId=<%=commandContent.getId()%>&commandId=<%=comm.getId()%>">修改</a>&nbsp;&nbsp;&nbsp;
										<a href="DeleteOne.action?contentId=<%=commandContent.getId()%>&commandId=<%=comm.getId()%>">删除</a>
									</td>
								</tr>
								<%
										}
									}
								%>
							</tbody>
						</table>
						<div class='page fix'>
							共 <b>1</b> 条
							<a href='###' class='first'>首页</a>
							<a href='###' class='pre'>上一页</a>
							当前第<span>1/1</span>页
							<a href='###' class='next'>下一页</a>
							<a href='###' class='last'>末页</a>
							跳至&nbsp;<input type='text' value='1' class='allInput w28' />&nbsp;页&nbsp;
							<a href='###' class='go'>GO</a>
						</div>
					</div>
				</div>
			</div>
	    </form>
	</body>
</html>