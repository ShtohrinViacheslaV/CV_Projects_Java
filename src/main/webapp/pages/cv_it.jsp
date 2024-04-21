<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="cv.model.CV" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>IT CV</title>
    <link rel="stylesheet" href="css/cvlist.css">
</head>
<body>
<div class="button-container">
    <a href="/cv/cvservlet?action=mainpage" class="button">Home page</a>
    <a href="/cv/cvservlet?action=logout" class="button">Exit</a>
</div>
<h1>IT CV</h1>
<div class="rectangle-container">
    <% List<CV> itCVs = (List<CV>) request.getAttribute("itCVs");
        if (itCVs != null && !itCVs.isEmpty()) {
            for (CV cv : itCVs) { %>
    <div class="rectangle">
        <a href="pages/cv.jsp?id=<%= cv.getId() %>">
            <img src="images/cv.jpg" alt="<%= cv.getName() %>" />
            <div><%= cv.getName() %></div>
        </a>
    </div>
    <%     }
    } else { %>
    <p>No IT CVs found.</p>
    <% } %>
</div>
</body>
</html>



<%--&lt;%&ndash;cv_it.jsp&ndash;%&gt;--%>

<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ page import="cv.model.CV" %>--%>
<%--<%@ page import="java.util.List" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>IT CV</title>--%>
<%--    <link rel="stylesheet" href="css/cvlist.css">--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>IT CV</h1>--%>
<%--<p>--%>
<%--    <a href = "/cv/cvservlet?action=logout" class="button">Exit </a>--%>
<%--</p>--%>
<%--<p>--%>
<%--    <a href = "/cv/cvservlet?action=mainpage" class="button">Home page </a>--%>
<%--</p>--%>
<%--<div class="rectangle-container">--%>
<%--    <% List<CV> itCVs = (List<CV>) request.getAttribute("itCVs");--%>
<%--        if (itCVs != null && !itCVs.isEmpty()) {--%>
<%--            for (CV cv : itCVs) { %>--%>
<%--    <div class="resume">--%>
<%--        <div class="rectangle">--%>
<%--            <a href="pages/cv.jsp?id=<%= cv.getId() %>">--%>
<%--                <img src="images/cv.jpg" alt="<%= cv.getName() %>" />--%>
<%--                <div><%= cv.getName() %></div>--%>
<%--            </a>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <%     }--%>
<%--    } else { %>--%>
<%--    <p>No IT CVs found.</p>--%>
<%--    <% } %>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
