2016.08.25 20��52
	ʵ�ֵ���ͼ��ӿ��Զ��ظ�
	ʵ��һ�������Ӧ�����ظ�
	
2016.08.26
	һ�ű�Message�ĳ����ű� Command �� Command_Content��
	ɾ�����ܵ�ʵ��
	
	ɾ��������
	���������ָ��commandId   ��contentId ����Id
	1.��ɾ��Command_Content����ָ��ID������
		delete from command_content where ID = #{_parameter}
	2.���� Command_Content���� command_id Ϊ commandId������
		 select * from command_content where COMMAND_ID = #{_parameter} 
	3.�����ҵ�������Ϊ 0 ������˵�� commandIdָ���Ӧ������Ϊ�գ�����ɾ�� Command���� commandId������
		delete from COMMAND where ID = #{_parameter} 
	
	ɾ��������
	
	/***********************
	Ŀǰֻɾ��Command_Content��������
	***********************/
	
	��������� List<contentId>
	1.ֱ��ɾ���б��а���������
		<delete id="deleteBatch" parameterType="java.util.List">
      		delete from command_content where ID in (
      			<foreach collection="list" item="item" separator=",">
      	   		 #{item}
      			</foreach>
      			)
  		</delete>
  		
2016.08.26
	һ.��� ��������ҳ�� �� �޸�����ҳ��
	
	��������ҳ�棺
	��������� command description content
	1.��ѯ command �����Ƿ��Ѿ����� command�������ڣ�ֱ�ӻ�ȡ command��ID
	<select id="selectCommand" parameterType="String" resultMap="CommandResult">
      select ID C_ID,NAME,DESCRIPTION from command where NAME = #{_parameter} 
  	</select>
  	ע��ѡ�������Ҫ�� �����resultMap�е���������Ӧ        C_ID
	2.��������command �����ȵ���insert���뵽command���У���������ֵ command��ID
	  �����÷��ص� ID ������ķ������� ����insert��command_content����
	  ����useGeneratedKeys="true" keyProperty="id" ���ԣ�ʹ����󷵻ز��������ֵ
	  
	<!-- ��������ֵ keyProperty �е�ֵӦ����Bean��������ͬ�����������ݿ��е�����-->
	
  	<insert id="addCommand" parameterType="com.jp.bean.Command" 
  			useGeneratedKeys="true" keyProperty="id">
      insert into command (NAME, DESCRIPTION) values(#{name}, #{description})
  	</insert>
  	3.�������ݵ� command_content ����
  	
2016.08.26
  	��������ҳ�棺
  	�޸İ��� �������� �� ����ظ�����
  	���������� command �����޸�  ����ظ������� command_content �����޸�
  	��������� commandId, contentId, oldDescription, newDescription, oldContent, new Content
  	/*******************
  	����������ת�� �޸�ҳ�� �������Ĳ�����  description content �� contentId commandId
  	���޸�ҳ����ת�� FixCommandServlet ʱ����Ԫ���в����� commandId������ commandId contentId ֻ��ͨ�� session ����
  	�� command description content ͨ�� request ����
  	
  	����� session ����ԭ����ֵ request �����޸ĺ��ֵ
  	*******************/
  		update command set DESCRIPTION = #{description} where id = #{id};

2016.08.27
	��Ӻ�̨����ϵͳ��½���� 		
  		
2016.08.27 16:06
	���ͳһ����ҳ��
	����˳���½
  		