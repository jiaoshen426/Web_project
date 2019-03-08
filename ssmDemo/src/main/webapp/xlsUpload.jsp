<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form id="from1" action="/ssmDemo/improtExcel"  method="post"  enctype="multipart/form-data" >    
        <input type="file" id="uploadFile" name="uploadFile"/>
        <input type=button onclick='importEmp()' value=上传>
</from>       
  
<script type="text/javascript">    
//Excel文件导入到数据库中       
function importEmp(){      
    //检验导入的文件是否为Excel文件       
    var uploadFile = document.getElementById("uploadFile").value;      
    if(uploadFile == null || uploadFile == ''){      
        alert("请选择要上传的Excel文件");      
        return;      
    }else{      
        var fileExtend = uploadFile.substring(uploadFile.lastIndexOf('.')).toLowerCase();       
        if(fileExtend == '.xls'){      
        }else{      
            alert("文件格式需为'.xls'格式");      
            return;      
        }      
    }      
    //提交表单       
    document.getElementById("from1").submit();      
}     
    
</script>    
</body>
</html>