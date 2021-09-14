<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户信息页</title>
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
  </table></center>
  <br>
  <hr style="color: aqua">
  <!-- 分页按钮部分 -->
  <p>当前是${pageInfo.pageNum}/${pageInfo.pages}</p>
  <a href="pageSearch?page=${pageInfo.firstPage}">第一页</a>
  <a href="pageSearch?page=${pageInfo.nextPage}">下一页</a>
  <a href="pageSearch?page=${pageInfo.prePage}">上一页</a>
  <a href="pageSearch?page=${pageInfo.lastPage}">最后页</a>
</center>
</body>

</html>
