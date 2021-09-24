<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>信息页</title>
</head>
<body>
   <center>
       <h2>账户信息列表</h2>
       <table border="1" width="30%">
           <tr>
               <th>账号</th>
               <th>账户名</th>
               <th>余额</th>
           </tr>
           <c:forEach items="${accountList}" var="acc">
               <tr>
                   <td>${acc.id}</td>
                   <td>${acc.account}</td>
                   <td>${acc.balance}</td>
               </tr>
           </c:forEach>
       </table>
       <a href="back">返回首页</a>
   </center>
</body>
</html>
