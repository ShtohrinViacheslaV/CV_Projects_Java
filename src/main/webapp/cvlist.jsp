<%@ page import="java.util.Properties" %>
<%@ page import="java.io.InputStream" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Resume List</title>
    <link rel="stylesheet" href="../css/cvlist.css">
</head>
<body>
<h1>Resume List</h1>
<%
    String direction = request.getParameter("direction");
    String[] ids;
    if (direction != null) {
        // Відповідно до вибраного напрямку роботи, вибираємо список резюме
        switch (direction) {
            case "it":
                ids = new String[]{"1"};
                break;
            case "marketing":
                ids = new String[]{"2"};
                break;
            case "finance":
                ids = new String[]{"3"};
                break;
            default:
                ids = new String[0];
                break;
        }
    } else {
        ids = new String[0];
    }

    // Зчитуємо дані з cv.properties та відображаємо список резюме
    Properties prop = new Properties();
    ClassLoader loader = Thread.currentThread().getContextClassLoader();
    InputStream stream = loader.getResourceAsStream("cv.properties");
    prop.load(stream);

    for (String id : ids) {
        out.println("<div class=\"resume-info\">");
        out.println("<div class=\"content\">");
        out.println("<div class=\"image-container\">");
        out.println("<img src=\"../images/image" + id + ".jpg\" class=\"responsive-image\"/>");
        out.println("</div>");
        out.println("<div class=\"text-container\">");
        out.println("<p>About me:");
        out.println("My name " + prop.getProperty("name" + id) + ". I am passionate about " + prop.getProperty("hobby" + id) + ". I study at " + prop.getProperty("education" + id) + ", so I have this work experience " + prop.getProperty("work_experience" + id) + ", but I have certain skills with " + prop.getProperty("skills" + id) + ". I am a creative, hardworking, and communicative person who learns quickly and knows how to work well in a team. I take a responsible and proactive approach to tasks. I possess critical thinking abilities, and I am not afraid of challenges or difficulties. I can easily handle problems. Additionally, I like sports and maintain a healthy lifestyle.");
        out.println("</p>");
        out.println("</div>");
        out.println("</div>");
        out.write("</div>");
        out.
    }
%>
</body>
</html>
