<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>主页面</title>
</head>
<body>
   <c:if test="${USER_SESSION.username==null}">
       暂未登录，请先<a href="${pageContext.request.contextPath}/loginView">登录</a>
   </c:if>
   <c:if test="${USER_SESSION.username!=null}">
       已登陆成功，当前用户为：${USER_SESSION.username}<br>
       <a href="${pageContext.request.contextPath}/logout">点击退出当前登录</a>
   </c:if>
</body>
</html>
