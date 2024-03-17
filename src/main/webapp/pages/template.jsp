<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.03.2024
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Template</title>
    <link rel="stylesheet" href="css/template.css">
</head>
<body>
    <div id = "header">
        Header
        <p>
            Hello, <%=request.getSession().getAttribute("username")%>
        </p>
        <p>
            <a href = "/cv/cvservlet?action=logout">Exit </a>
        </p>
    </div>
    <div id = "menu">
        <ul>
            <li>Profession</li>
            <li><a href="/cv/cvservlet?action=it">IT</a></li>
            <li><a href="/cv/cvservlet?action=marketing">Marketing</a></li>
            <li><a href="/cv/cvservlet?action=finance">Finance</a></li>
            <li><a href="/cv/cvservlet?action=showAllCV">CV</a></li>
        </ul>
    </div>
    <div id = "main">
        <%
            String includedPage = (String) request.getSession().getAttribute("includedPage");
            if (includedPage != null){
            %>
            <jsp:include page="<%=includedPage%>"/>


        <%
            }
        %>
    </div>
    <div id = "footer">Copyright 1900-2024</div>
</body>
</html>



