<%@ page import="cv.dao.CVDAO" %>
<%@ page import="cv.model.CV" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Resume Details</title>
    <link rel="stylesheet" href="../css/cv.css">
</head>
<body>

<%
    String idParam = request.getParameter("id");
    int id = 0;

    if (idParam != null && !idParam.isEmpty()) {
        id = Integer.parseInt(idParam);
    }

    CVDAO cvDAO = new CVDAO();
    CV cv = cvDAO.getCVById(id);

    if (cv != null) {
        String name = cv.getName();
        String professionName = cvDAO.getProfessionNameById(cv.getProfession_id());
        String email = cv.getEmail();
        String education = cv.getEducation();
        String experience = cv.getWork_experience();
        String skills = cv.getSkills();
%>

<h1>Resume Details</h1>
<div class="button-container">
    <a href="/cv/cvservlet?action=mainpage" class="button">Home page</a>
    <a href="/cv/cvservlet?action=logout" class="button">Exit</a>
</div>
<div class="resume-details">
    <table>
        <tr>
            <th>Name</th>
            <td><%= name %></td>
        </tr>
        <tr>
            <th>Profession</th>
            <td><%= professionName %></td>
        </tr>
        <tr>
            <th>Email</th>
            <td><%= email %></td>
        </tr>
        <tr>
            <th>Education</th>
            <td><%= education %></td>
        </tr>
        <tr>
            <th>Work Experience</th>
            <td><%= experience %></td>
        </tr>
        <tr>
            <th>Skills</th>
            <td><%= skills %></td>
        </tr>
    </table>
</div>

<%
} else {
%>
<div class="error-message">
    <p>Resume not found!</p>
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
<%--    <title>Resume Details</title>--%>
<%--    <link rel="stylesheet" href="../css/cv.css">--%>
<%--</head>--%>
<%--<body>--%>

<%--<%--%>
<%--    // Отримуємо id резюме з параметра запиту--%>
<%--    String idParam = request.getParameter("id");--%>
<%--    int id = 0; // Значення за замовчуванням, якщо id не передано--%>

<%--    if (idParam != null && !idParam.isEmpty()) {--%>
<%--        // Якщо параметр id не є порожнім або null, то конвертуємо його в ціле число--%>
<%--        id = Integer.parseInt(idParam);--%>
<%--    }--%>

<%--    // Створюємо екземпляр класу CVDAO--%>
<%--    CVDAO cvDAO = new CVDAO();--%>

<%--    // Отримуємо дані резюме з бази даних за його id--%>
<%--    CV cv = cvDAO.getCVById(id);--%>

<%--    // Перевіряємо, чи було знайдено резюме за вказаним id--%>
<%--    if (cv != null) {--%>
<%--        String name = cv.getName();--%>
<%--        String professionName = cvDAO.getProfessionNameById(cv.getProfession_id());--%>
<%--        String email = cv.getEmail();--%>
<%--        String education = cv.getEducation();--%>
<%--        String experience = cv.getWork_experience();--%>
<%--        String skills = cv.getSkills();--%>
<%--%>--%>

<%--<h1>Resume Details</h1>--%>
<%--<div class="button-container">--%>
<%--    <a href="/cv/cvservlet?action=mainpage" class="button">Home page</a>--%>
<%--    <a href="/cv/cvservlet?action=logout" class="button">Exit</a>--%>
<%--</div>--%>
<%--<div class="resume-details">--%>
<%--    <h2>Name: <%= name %></h2>--%>
<%--    <p>Profession: <%= professionName %></p>--%>
<%--    <p>Email: <%= email %></p>--%>
<%--    <p>Education: <%= education %></p>--%>
<%--    <p>Experience: <%= experience %></p>--%>
<%--    <p>Skills: <%= skills %></p>--%>
<%--    <!-- Додайте інші дані резюме, які ви хочете відобразити -->--%>
<%--</div>--%>

<%--<%--%>
<%--} else {--%>
<%--    // Виводимо повідомлення, якщо резюме з вказаним id не знайдено--%>
<%--%>--%>
<%--<div class="error-message">--%>
<%--    <p>Resume not found!</p>--%>
<%--</div>--%>
<%--<%--%>
<%--    }--%>
<%--%>--%>

<%--</body>--%>
<%--</html>--%>








<%--<%@ page import="cv.model.CV" %>--%>
<%--<%@ page import="cv.dao.CVDAO" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Resume</title>--%>
<%--    <link rel="stylesheet" href="../css/cv.css">--%>
<%--</head>--%>
<%--<%--%>
<%--    String idParam = request.getParameter("id");--%>
<%--    int id = 0; // Значення за замовчуванням, якщо id не передано--%>

<%--    if (idParam != null && !idParam.isEmpty()) {--%>
<%--        // Якщо параметр id не є порожнім або null, то конвертуємо його в ціле число--%>
<%--        id = Integer.parseInt(idParam);--%>
<%--    }--%>

<%--    // Ініціалізуємо об'єкт DAO для роботи з базою даних--%>
<%--    CVDAO cvDAO = new CVDAO();--%>

<%--    // Отримуємо об'єкт CV з бази даних за допомогою id--%>
<%--    CV cv = cvDAO.getCVById(id);--%>
<%--%>--%>
<%--<body>--%>

<%--<div class="resume-info">--%>
<%--    <div class="content">--%>
<%--        <div class="image-container">--%>
<%--            <img src="<%= cv.getImagePath() %>" class="responsive-image"/>--%>
<%--        </div>--%>
<%--        <div class="text-container">--%>
<%--            <p>About me:--%>
<%--                My name is <%= cv.getName() %>. I am passionate about <%= cvDAO.getProfessionNameById(cv.getProfession_id()) %>. I have studied at <%= cv.getEducation() %>, and I have <%= cv.getWork_experience() %> of work experience. I have skills in <%= cv.getSkills() %>. I am a creative, hardworking, and communicative person who learns quickly and knows how to work well in a team. I take a responsible and proactive approach to tasks. I possess critical thinking abilities, and I am not afraid of challenges or difficulties. I can easily handle problems. Additionally, I like sports and maintain a healthy lifestyle.--%>
<%--            </p>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<%--</body>--%>
<%--</html>--%>


<%--<%@ page import="cv.model.CV" %>--%>
<%--<%@ page import="java.util.Properties" %>--%>
<%--<%@ page import="java.io.InputStream" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Resume</title>--%>
<%--    <link rel="stylesheet" href="../css/cv.css">--%>
<%--</head>--%>
<%--<%--%>
<%--    String idParam = request.getParameter("id");--%>
<%--    int id = 0; // Значення за замовчуванням, якщо id не передано--%>

<%--    if (idParam != null && !idParam.isEmpty()) {--%>
<%--        // Якщо параметр id не є порожнім або null, то конвертуємо його в ціле число--%>
<%--        id = Integer.parseInt(idParam);--%>
<%--    }--%>

<%--    Properties prop = new Properties();--%>
<%--    ClassLoader loader = Thread.currentThread().getContextClassLoader(); //завантажити в окремому потоці--%>
<%--    InputStream stream = loader.getResourceAsStream("cv.properties");--%>
<%--    prop.load(stream);--%>

<%--    String imageName = "image" + id + ".jpg"; // Змінна для зберігання назви фотографії--%>
<%--    String imagePath = "../images/" + imageName; // Шлях до фотографії--%>

<%--    CV cv = new CV(prop.getProperty("name" + id), prop.getProperty("hobby" + id), prop.getProperty("education" + id), prop.getProperty("work_experience" + id), prop.getProperty("skills" + id));--%>

<%--%>--%>
<%--<body>--%>

<%--<div class="resume-info">--%>
<%--    <div class="content">--%>
<%--        <div class="image-container">--%>
<%--            <img src="<%= imagePath %>" class="responsive-image"/>--%>
<%--        </div>--%>
<%--        <div class="text-container">--%>
<%--            <p>About me:--%>
<%--                My name <%=cv.getName()%>. I am passionate about Python and the Django framework and my hobby <%=cv.getHobby()%>. I study at the <%=cv.getEducation()%>, so I have this work experience <%=cv.getWork_experience()%>, but I have certain skills with <%=cv.getSkills()%>. I am a creative, hardworking, and communicative person who learns quickly and knows how to work well in a team. I take a responsible and proactive approach to tasks. I possess critical thinking abilities, and I am not afraid of challenges or difficulties. I can easily handle problems. Additionally, I like sports and maintain a healthy lifestyle.--%>
<%--            </p>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<%--</body>--%>
<%--</html>--%>

