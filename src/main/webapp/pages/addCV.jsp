<%@ page import="cv.dao.CVDAO" %>
<%@ page import="cv.model.CV" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New CV</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>

<h1>Add New CV</h1>

<form action="cvservlet?action=addCV" method="post">
    <label>Name:</label><br>
    <input type="text" name="name"><br>

    <label>Profession ID:</label><br>
    <input type="text" name="profession_id"><br>

    <label>Email:</label><br>
    <input type="text" name="email"><br>

    <label>Education:</label><br>
    <input type="text" name="education"><br>

    <label>Work Experience:</label><br>
    <input type="text" name="work_experience"><br>

    <label>Skills:</label><br>
    <input type="text" name="skills"><br>

    <input type="submit" value="Add CV">
    <input type="button" onclick="window.location.href='/cv/cvservlet?action=showAllCV'" value="Show All CVs">

</form>

</body>
</html>
