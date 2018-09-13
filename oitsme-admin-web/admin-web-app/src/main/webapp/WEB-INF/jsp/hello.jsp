<%--
  Created by IntelliJ IDEA.
  User: Yonye
  Date: 2018/7/29
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>This's hello world!!!!</div>
<aside>

</aside>
<div>
    <ul style="display: inline-list-item">
        <li>音乐</li>
        <li>电影</li>
        <li>吃喝</li>
        <li>玩乐</li>
    </ul>
</div>
<p>
    ${requestScope.messagePara}
    ${requestScope.user}
</p>
<P>${requestScope.test}</P>

</body>
</html>
