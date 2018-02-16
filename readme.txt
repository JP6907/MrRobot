2016.08.25 20：52
	实现调用图灵接口自动回复
	实现一条命令对应多条回复
	
2016.08.26
	一张表Message改成两张表 Command 和 Command_Content后
	删除功能的实现
	
	删除单条：
	传入参数：指令commandId   ，contentId 内容Id
	1.先删除Command_Content表中指定ID的数据
		delete from command_content where ID = #{_parameter}
	2.查找 Command_Content表中 command_id 为 commandId的数据
		 select * from command_content where COMMAND_ID = #{_parameter} 
	3.若查找到的数据为 0 条，则说明 commandId指令对应的内容为空，即可删除 Command表中 commandId的数据
		delete from COMMAND where ID = #{_parameter} 
	
	删除多条：
	
	/***********************
	目前只删除Command_Content表中数据
	***********************/
	
	传入参数： List<contentId>
	1.直接删除列表中包含的数据
		<delete id="deleteBatch" parameterType="java.util.List">
      		delete from command_content where ID in (
      			<foreach collection="list" item="item" separator=",">
      	   		 #{item}
      			</foreach>
      			)
  		</delete>
  		
2016.08.26
	一.添加 新增命令页面 和 修改命令页面
	
	新增命令页面：
	传入参数： command description content
	1.查询 command 表中是否已经存在 command，若存在，直接获取 command的ID
	<select id="selectCommand" parameterType="String" resultMap="CommandResult">
      select ID C_ID,NAME,DESCRIPTION from command where NAME = #{_parameter} 
  	</select>
  	注意选择的属性要与 结果集resultMap中的属性名对应        C_ID
	2.若不存在command ，则先调用insert插入到command表中，返回主键值 command的ID
	  再利用返回的 ID 和命令的返回内容 调用insert到command_content表中
	  设置useGeneratedKeys="true" keyProperty="id" 属性，使插入后返回插入的主键值
	  
	<!-- 返回主键值 keyProperty 中的值应该与Bean中名字相同，而不是数据库中的名字-->
	
  	<insert id="addCommand" parameterType="com.jp.bean.Command" 
  			useGeneratedKeys="true" keyProperty="id">
      insert into command (NAME, DESCRIPTION) values(#{name}, #{description})
  	</insert>
  	3.插入内容到 command_content 表中
  	
2016.08.26
  	新增命令页面：
  	修改包括 命令描述 和 命令回复内容
  	命令描述在 command 表中修改  命令回复内容在 command_content 表中修改
  	传入参数： commandId, contentId, oldDescription, newDescription, oldContent, new Content
  	/*******************
  	从主界面跳转到 修改页面 传过来的参数有  description content 和 contentId commandId
  	从修改页面跳转到 FixCommandServlet 时，表单元素中不包含 commandId，所以 commandId contentId 只能通过 session 传送
  	而 command description content 通过 request 传送
  	
  	解决： session 保存原来的值 request 保存修改后的值
  	*******************/
  		update command set DESCRIPTION = #{description} where id = #{id};

2016.08.27
	添加后台管理系统登陆过滤 		
  		
2016.08.27 16:06
	添加统一错误页面
	添加退出登陆
  		