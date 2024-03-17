<%@ page import="cv.model.CV" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add CV</title>
    <link rel="stylesheet" href="css/addEditCV.css">
</head>
<body>
<h2>Add New CV</h2>
<form action="/cv/cvservlet?action=addCV" method="post">
    Name: <input type="text" name="name"><br>
    Education: <input type="text" name="education"><br>
    Hobby: <input type="text" name="hobby"><br>
    Work Experience: <input type="text" name="workExperience"><br>
    Skills: <input type="text" name="skills"><br>
    <input type="submit" value="Add CV">
</form>
</body>
</html>
