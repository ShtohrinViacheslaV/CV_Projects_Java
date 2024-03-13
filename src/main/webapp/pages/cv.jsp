<%@ page import="cv.model.CV" %>
<%@ page import="java.util.Properties" %>
<%@ page import="java.io.InputStream" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Resume</title>
    <link rel="stylesheet" href="../css/cv.css">
</head>
<%
    String idParam = request.getParameter("id");
    int id = 0; // Значення за замовчуванням, якщо id не передано

    if (idParam != null && !idParam.isEmpty()) {
        // Якщо параметр id не є порожнім або null, то конвертуємо його в ціле число
        id = Integer.parseInt(idParam);
    }

    Properties prop = new Properties();
    ClassLoader loader = Thread.currentThread().getContextClassLoader(); //завантажити в окремому потоці
    InputStream stream = loader.getResourceAsStream("cv.properties");
    prop.load(stream);

    String imageName = "image" + id + ".jpg"; // Змінна для зберігання назви фотографії
    String imagePath = "../images/" + imageName; // Шлях до фотографії

    CV cv = new CV(prop.getProperty("name" + id), prop.getProperty("hobby" + id), prop.getProperty("education" + id), prop.getProperty("work_experience" + id), prop.getProperty("skills" + id));

%>
<body>

<div class="resume-info">
    <div class="content">
        <div class="image-container">
            <img src="<%= imagePath %>" class="responsive-image"/>
        </div>
        <div class="text-container">
            <p>About me:
                My name <%=cv.getName()%>. I am passionate about Python and the Django framework and my hobby <%=cv.getHobby()%>. I study at the <%=cv.getEducation()%>, so I have this work experience <%=cv.getWork_experience()%>, but I have certain skills with <%=cv.getSkills()%>. I am a creative, hardworking, and communicative person who learns quickly and knows how to work well in a team. I take a responsible and proactive approach to tasks. I possess critical thinking abilities, and I am not afraid of challenges or difficulties. I can easily handle problems. Additionally, I like sports and maintain a healthy lifestyle.
            </p>
        </div>
    </div>
</div>

</body>
</html>
