<%--
  Created by IntelliJ IDEA.
  User: Rainey
  Date: 2017/12/1
  Time: 17:36
  springMVC数据传输测试
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>秒杀列表页</title>

</head>
<body>Hello World!!
</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
	//$.ajax({
	/* 	type: 'post',
	 url:'baseType.do',
	 dataType:'json', 
	 data:{"age":1510,"name":"jiaoshen",
	 "address":{
	 "add": "beijing",
	 "code":"10086"
	 }
	 }
	
	 })
	 */
	var users = JSON.stringify([ {
		name : "wabiaozai1",
		pwd : "123"
	}, {
		name : "wabiaozai2",
		pwd : "123"
	} ]);

	$.ajax({
		type : "post",
		url : "wabiaozai",
		data : users,
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		success : function(response, ifo) {
			alert("success");
		}
	})
</script>
</html>