<%--cv_marketing.jsp--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="cv.model.CV" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Marketing CV</title>
    <link rel="stylesheet" href="css/cvlist.css">
</head>
<body>
<h1>Marketing CV</h1>
<div class="button-container">
    <a href="/cv/cvservlet?action=mainpage" class="button">Home page</a>
    <a href="/cv/cvservlet?action=logout" class="button">Exit</a>
</div>
<div class="rectangle-container">
    <% List<CV> marketingCVs = (List<CV>) request.getAttribute("marketingCVs");
        if (marketingCVs != null && !marketingCVs.isEmpty()) {
            for (CV cv : marketingCVs) { %>
    <div class="resume">
        <div class="rectangle">
            <a href="pages/cv.jsp?id=<%= cv.getId() %>">
                <img src="images/cv.jpg" alt="<%= cv.getName() %>" />
                <div><%= cv.getName() %></div>
            </a>
        </div>
    </div>
    <%     }
    } else { %>
    <p>No Marketing CVs found.</p>
    <% } %>
</div>
</body>
</html>
