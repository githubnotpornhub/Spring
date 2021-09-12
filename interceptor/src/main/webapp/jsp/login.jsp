<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页</title>
</head>
<body>
    ${msg}
    <form action="${pageContext.request.contextPath}/login" method="post">
        <div >
            用户名
            <input type="text" name="username" placeholder="请输入用户名">
        </div>
        <div >
            密&nbsp;&nbsp;&nbsp;&nbsp;码
            <input type="password" name="password" placeholder="请输入密码">
        </div>
        <input type="submit" value="登录"/>
    </form>
</body>
</html>
