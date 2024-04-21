<%--cv_finance.jsp--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="cv.model.CV" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Finance CV</title>
    <link rel="stylesheet" href="css/cvlist.css">
</head>
<body>
<h1>Finance CV</h1>
<div class="button-container">
    <a href="/cv/cvservlet?action=mainpage" class="button">Home page</a>
    <a href="/cv/cvservlet?action=logout" class="button">Exit</a>
</div>
<div class="rectangle-container">
    <% List<CV> financeCVs = (List<CV>) request.getAttribute("financeCVs");
        if (financeCVs != null && !financeCVs.isEmpty()) {
            for (CV cv : financeCVs) { %>
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
    <p>No Finance CVs found.</p>
    <% } %>
</div>
</body>
</html>
