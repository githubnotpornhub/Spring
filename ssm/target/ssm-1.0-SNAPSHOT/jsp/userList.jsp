<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户信息页</title>
    <script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#tz").keypress(function (event){
                if (event.keyCode=='13'){
                    var num=$("#tz").val();
                    window.location.replace("pageSearch?page=${num}");
                }
            })
        })
    </script>
</head>
<body>
<center style="text-align: center">
    <h2>用户信息列表</h2>
    <center>
        <table border="1" style="text-align: center">
            <tr>
                <th>ID</th>
                <th>用户名</th>
                <th>密码</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>邮箱</th>
                <th>职位</th>
                <th>工资</th>
                <th>奖金</th>
                <th>入职年数</th>
            </tr>
            <c:forEach items="${list}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td>${user.email}</td>
                    <td>${user.job}</td>
                    <td>${user.sal}</td>
                    <td>${user.bonus}</td>
                    <td>${user.year}</td>
                </tr>
            </c:forEach>
        </table>
    </center>
    <br>
    <hr style="color: aqua">
    <!-- 分页按钮部分 -->
    <p>当前页${pageInfo.pageNum}&nbsp;/&nbsp;共${pageInfo.pages}页</p>
    <a href="pageSearch?page=${pageInfo.firstPage}">第一页</a>&nbsp;&nbsp;
    <a href="pageSearch?page=${pageInfo.prePage}">上一页</a>&nbsp;&nbsp;
    <a href="pageSearch?page=${pageInfo.nextPage}">下一页</a>&nbsp;&nbsp;
    <a href="pageSearch?page=${pageInfo.lastPage}">最后页</a>&nbsp;&nbsp;
    跳转到&nbsp;<input type="text" id="tz" style="width: 30px">&nbsp;页<br><br>
    <c:if test="${USER_SESSION.username!=null}">
        当前用户为：${USER_SESSION.username}<br>
        <a href="${pageContext.request.contextPath}/logout">点击退出当前登录</a>
    </c:if>
</center>
</body>
</html>
