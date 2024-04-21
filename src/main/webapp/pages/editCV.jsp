<%@ page import="cv.dao.CVDAO" %>
<%@ page import="cv.model.CV" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Edit CV</title>
  <link rel="stylesheet" href="../css/style.css">
</head>
<body>

<h1>Edit CV</h1>

<%
  System.out.println("start jsp processor.....");

  // Отримуємо id резюме для редагування з параметра запиту
  String idParam = request.getParameter("id");
  int id = Integer.parseInt(idParam);

  // Ініціалізуємо об'єкт DAO для роботи з базою даних
  CVDAO cvDAO = new CVDAO();

  // Отримуємо дані резюме з бази даних за його id
  CV cv = cvDAO.getCVById(id);
  request.setAttribute("cv", cv);

  // Перевіряємо, чи було знайдено резюме за вказаним id
  if (cv != null) {
    String name = cv.getName();
    int professionId = cv.getProfession_id();
    String email = cv.getEmail();
    String education = cv.getEducation();
    String workExperience = cv.getWork_experience();
    String skills = cv.getSkills();
%>

<form action="cvservlet?action=updateCV" method="post">
  <input type="hidden" name="id" value="<%= id %>">
  <label>Name:</label><br>
  <input type="text" name="name" value="<%= name %>"><br>

  <label>Profession ID:</label><br>
  <input type="text" name="profession_id" value="<%= professionId %>"><br>

  <label>Email:</label><br>
  <input type="text" name="email" value="<%= email %>"><br>

  <label>Education:</label><br>
  <input type="text" name="education" value="<%= education %>"><br>

  <label>Work Experience:</label><br>
  <input type="text" name="work_experience" value="<%= workExperience %>"><br>

  <label>Skills:</label><br>
  <input type="text" name="skills" value="<%= skills %>"><br>

  <button type="submit">Update CV</button>
  <input type="button" onclick="window.location.href='/cv/cvservlet?action=showAllCV'" value="Show All CVs">

</form>

<%System.out.println("finish jsp processor.....");

} else {
  // Виводимо повідомлення, якщо резюме з вказаним id не знайдено
%>
<div class="error-message">
  <p>CV not found!</p>
</div>
<%
  }
%>

</body>
</html>


<%--<%@ page import="cv.dao.CVDAO" %>--%>
<%--<%@ page import="cv.model.CV" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--  <title>Edit CV</title>--%>
<%--  <link rel="stylesheet" href="../css/style.css">--%>
<%--</head>--%>
<%--<body>--%>

<%--<h1>Edit CV</h1>--%>

<%--<%--%>
<%--  // Отримуємо id резюме для редагування з параметра запиту--%>
<%--  String idParam = request.getParameter("id");--%>
<%--  int id = Integer.parseInt(idParam);--%>

<%--  // Ініціалізуємо об'єкт DAO для роботи з базою даних--%>
<%--  CVDAO cvDAO = new CVDAO();--%>

<%--  // Отримуємо дані резюме з бази даних за його id--%>
<%--  CV cv = cvDAO.getCVById(id);--%>
<%--  request.setAttribute("cv", cv);--%>

<%--  // Перевіряємо, чи було знайдено резюме за вказаним id--%>
<%--  if (cv != null) {--%>
<%--    String name = cv.getName();--%>
<%--    int professionId = cv.getProfession_id();--%>
<%--    String email = cv.getEmail();--%>
<%--    String education = cv.getEducation();--%>
<%--    String workExperience = cv.getWork_experience();--%>
<%--    String skills = cv.getSkills();--%>
<%--%>--%>

<%--<form action="cvservlet?action=editCV" method="post">--%>
<%--&lt;%&ndash;    <input type="hidden" name="action" value="updateCV">&ndash;%&gt;--%>
<%--&lt;%&ndash;    <input type="hidden" name="id" value=id><br>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <input type="text" name="name" value=name><br>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <input type="text" name="profession_id" value=professionId><br>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <input type="text" name="email" value=email><br>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <input type="text" name="education" value=education><br>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <input type="text" name="work_experience" value=workExperience><br>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <input type="text" name="skills" value=skills><br>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <input type="submit" value="Update CV">&ndash;%&gt;--%>

<%--  <input type="hidden" name="id" value="<%= id %>">--%>
<%--  <label>Name:</label><br>--%>
<%--  <input type="text" name="name" value="<%= name %>"><br>--%>

<%--  <label>Profession ID:</label><br>--%>
<%--  <input type="text" name="profession_id" value="<%= professionId %>"><br>--%>

<%--  <label>Email:</label><br>--%>
<%--  <input type="text" name="email" value="<%= email %>"><br>--%>

<%--  <label>Education:</label><br>--%>
<%--  <input type="text" name="education" value="<%= education %>"><br>--%>

<%--  <label>Work Experience:</label><br>--%>
<%--  <input type="text" name="work_experience" value="<%= workExperience %>"><br>--%>

<%--  <label>Skills:</label><br>--%>
<%--  <input type="text" name="skills" value="<%= skills %>"><br>--%>

<%--  <input type="submit" value="Update CV">--%>
<%--  <input type="button" onclick="window.location.href='/cv/cvservlet?action=showAllCV'" value="Show All CVs">--%>

<%--</form>--%>

<%--<%--%>
<%--} else {--%>
<%--  // Виводимо повідомлення, якщо резюме з вказаним id не знайдено--%>
<%--%>--%>
<%--<div class="error-message">--%>
<%--  <p>CV not found!</p>--%>
<%--</div>--%>
<%--<%--%>
<%--  }--%>
<%--%>--%>

<%--</body>--%>
<%--</html>--%>








<%--<%@ page import="cv.model.Profession" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--  <title>Edit CV</title>--%>
<%--  <link rel="stylesheet" href="css/addEditCV.css">--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="cv-container">--%>
<%--  <h2>Edit CV</h2>--%>
<%--  <form action="/cv/cvservlet?action=editCV" method="post">--%>
<%--    <input type="hidden" name="cvId" value="<%= request.getParameter("cvId") %>">--%>

<%--    <label for="name">Name:</label>--%>
<%--    <input type="text" id="name" name="name" value="<%= request.getParameter("name") %>" required><br>--%>

<%--    <label for="profession">Profession:</label>--%>
<%--    <select id="profession" name="profession">--%>
<%--      <% List<Profession> professions = (List<Profession>) request.getAttribute("professions");--%>
<%--        if (professions != null && !professions.isEmpty()) {--%>
<%--          for (Profession profession : professions) { %>--%>
<%--      <option value="<%= profession.getId() %>" <% if (Integer.parseInt(request.getParameter("professionId")) == profession.getId()) { out.print("selected"); } %>><%= profession.getName() %></option>--%>
<%--      <%      }--%>
<%--      } %>--%>
<%--    </select><br>--%>

<%--    <label for="education">Education:</label>--%>
<%--    <input type="text" id="education" name="education" value="<%= request.getParameter("education") %>" required><br>--%>

<%--    <label for="experience">Work Experience:</label>--%>
<%--    <input type="text" id="experience" name="experience" value="<%= request.getParameter("workExperience") %>" required><br>--%>

<%--    <label for="skills">Skills:</label>--%>
<%--    <input type="text" id="skills" name="skills" value="<%= request.getParameter("skills") %>" required><br>--%>

<%--    <label for="email">Email:</label>--%>
<%--    <input type="email" id="email" name="email" value="<%= request.getParameter("email") %>" required><br>--%>

<%--    <button type="submit">Update CV</button>--%>
<%--  </form>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--  <meta charset="UTF-8">--%>
<%--  <title>Edit CV</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Edit CV</h1>--%>
<%--<form action="cvservlet?action=editCV" method="post">--%>
<%--  <input type="hidden" name="id" value="${cv.id}">--%>
<%--  <label>Name:</label><br>--%>
<%--  <input type="text" name="name" value="${cv.name}"><br>--%>
<%--  <label>Profession ID:</label><br>--%>
<%--  <input type="number" name="professionId" value="${cv.profession_id}"><br>--%>
<%--  <label>Email:</label><br>--%>
<%--  <input type="email" name="email" value="${cv.email}"><br>--%>
<%--  <label>Education:</label><br>--%>
<%--  <textarea name="education">${cv.education}</textarea><br>--%>
<%--  <label>Work Experience:</label><br>--%>
<%--  <textarea name="workExperience">${cv.work_experience}</textarea><br>--%>
<%--  <label>Skills:</label><br>--%>
<%--  <textarea name="skills">${cv.skills}</textarea><br>--%>
<%--  <input type="submit" value="Save Changes">--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>
