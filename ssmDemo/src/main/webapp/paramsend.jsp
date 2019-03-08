<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
</head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<body>
    你是茂利
	<!--    <form id="from1" action="/ssmDemo/improtExcel"  method="post"  enctype="multipart/form-data" >     -->
	<!--         <input type="file" id="uploadFile" name="uploadFile"/> -->
	<!--         <input type=button onclick='importEmp()' value=上传> -->
	<!-- </from>        -->

	<script src="<%=path%>/resources/script/test2.js"></script>
</body>
</html>