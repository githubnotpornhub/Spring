<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
     <script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
     <script type="text/javascript">
         function check(){
             var name=document.getElementById("name").value;
             var file=document.getElementById("file").value;
             if (name==""){
                 alert("请填写上传人姓名");
                 return false;
             }
             if (file.length==0||file==""){
                 alert("请选择要上传的文件")
                 return false;
             }
             return true;
         }
     </script>
</head>
<body>
   <form action="${pageContext.request.contextPath}/fileUpload" method="post"
         enctype="multipart/form-data" onsubmit="return check()">
       上传人姓名<input id="name" type="text" name="name" ><br>
       请选择文件<input id="file" type="file" name="uploadfile" multiple><br>
       <input type="submit" value="确认上传">
   </form>
</body>
</html>
