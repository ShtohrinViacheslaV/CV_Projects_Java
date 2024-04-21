<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="cv.model.CV, cv.dao.CVDAO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All CVs</title>
    <link rel="stylesheet" href="css/showAllCV.css">
</head>
<body>

<h1>All CVs</h1>
<div class="button-container">
    <a href="cvservlet?action=addCV" class="button">Add CV</a>
    <a href="/cv/cvservlet?action=mainpage" class="button">Home page</a>
    <a href="/cv/cvservlet?action=logout" class="button">Exit</a>
</div>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Profession</th>
        <th>Email</th>
        <th>Education</th>
        <th>Work Experience</th>
        <th>Skills</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <% CVDAO cvDAO = new CVDAO();
        List<CV> cvList = cvDAO.getAllCVs();
        for (CV cv : cvList) { %>
    <tr>
        <td><%= cv.getId() %></td>
        <td><%= cv.getName() %></td>
        <td><%= cvDAO.getProfessionNameById(cv.getProfession_id()) %></td>
        <td><%= cv.getEmail() %></td>
        <td><%= cv.getEducation() %></td>
        <td><%= cv.getWork_experience() %></td>
        <td><%= cv.getSkills() %></td>
        <td><a href="cvservlet?action=editCV&id=<%= cv.getId() %>">Edit</a></td>
        <td><a href="cvservlet?action=deleteCV&id=<%= cv.getId() %>">Delete</a></td>
    </tr>
    <% } %>
    </tbody>
</table>

</body>
</html>



<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%--<%@ page import="cv.model.CV, cv.dao.CVDAO" %>--%>
<%--<%@ page import="java.util.List" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <title>All CVs</title>--%>
<%--    <style>--%>
<%--        table {--%>
<%--            border-collapse: collapse;--%>
<%--            width: 100%;--%>
<%--        }--%>
<%--        th, td {--%>
<%--            border: 1px solid #dddddd;--%>
<%--            text-align: left;--%>
<%--            padding: 8px;--%>
<%--        }--%>
<%--        th {--%>
<%--            background-color: #f2f2f2;--%>
<%--        }--%>
<%--        .button {--%>
<%--            background-color: #4CAF50;--%>
<%--            border: none;--%>
<%--            color: white;--%>
<%--            padding: 10px 20px;--%>
<%--            text-align: center;--%>
<%--            text-decoration: none;--%>
<%--            display: inline-block;--%>
<%--            font-size: 16px;--%>
<%--            margin: 4px 2px;--%>
<%--            cursor: pointer;--%>
<%--            border-radius: 4px;--%>
<%--        }--%>
<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>

<%--<h2>All CVs</h2>--%>
<%--<p>--%>
<%--    <a href = "/cv/cvservlet?action=logout" class="button">Exit </a>--%>
<%--</p>--%>
<%--<p>--%>
<%--    <a href = "/cv/cvservlet?action=mainpage" class="button">Home page </a>--%>
<%--</p>--%>
<%--<table>--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--        <th>ID</th>--%>
<%--        <th>Name</th>--%>
<%--        <th>Profession</th>--%>
<%--        <th>Email</th>--%>
<%--        <th>Education</th>--%>
<%--        <th>Work Experience</th>--%>
<%--        <th>Skills</th>--%>
<%--        <th>Edit</th>--%>
<%--        <th>Delete</th>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>
<%--    <% CVDAO cvDAO = new CVDAO();--%>
<%--        List<CV> cvList = cvDAO.getAllCVs();--%>
<%--        for (CV cv : cvList) { %>--%>
<%--    <tr>--%>
<%--        <td><%= cv.getId() %></td>--%>
<%--        <td><%= cv.getName() %></td>--%>
<%--        <td><%= cvDAO.getProfessionNameById(cv.getProfession_id()) %></td>--%>
<%--        <td><%= cv.getEmail() %></td>--%>
<%--        <td><%= cv.getEducation() %></td>--%>
<%--        <td><%= cv.getWork_experience() %></td>--%>
<%--        <td><%= cv.getSkills() %></td>--%>
<%--        <td><a href="cvservlet?action=editCV&id=<%= cv.getId() %>">Edit</a></td>--%>
<%--        <td><a href="cvservlet?action=deleteCV&id=<%= cv.getId() %>">Delete</a></td>--%>
<%--    </tr>--%>
<%--    <% } %>--%>
<%--    </tbody>--%>
<%--</table>--%>

<%--<a href="cvservlet?action=addCV" class="button">Додати резюме</a>--%>
<%--<a href="cvservlet?action=deleteCV" class="button">Видалити всі резюме</a>--%>

<%--</body>--%>
<%--</html>--%>

