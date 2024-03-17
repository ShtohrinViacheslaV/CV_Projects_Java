<%@ page import="cv.model.CV" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Edit CV</title>
  <link rel="stylesheet" href="css/editCV.css">
</head>
<body>
<h2>Edit CV</h2>
<form action="/cv/cvservlet?action=editCV" method="post">
  Name: <input type="text" name="name" value="<%= cv.getName() %>"><br>
  Education: <input type="text" name="education" value="<%= cv.getEducation() %>"><br>
  Hobby: <input type="text" name="hobby" value="<%= cv.getHobby() %>"><br>
  Work Experience: <input type="text" name="workExperience" value="<%= cv.getWorkExperience() %>"><br>
  Skills: <input type="text" name="skills" value="<%= cv.getSkills() %>"><br>
  <input type="hidden" name="id" value="<%= cv.getId() %>">
  <input type="submit" value="Save Changes">
</form>
</body>
</html>
