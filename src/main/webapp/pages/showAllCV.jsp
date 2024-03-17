<%@ page import="cv.model.CV" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show All CV</title>
    <link rel="stylesheet" href="css/showAllCV.css">
    <script>
        function showDetails() {
            var checkboxes = document.getElementsByName("CV");
            var details = document.getElementsByClassName("details");
            for (var i = 0; i < checkboxes.length; i++) {
                if (checkboxes[i].checked) {
                    details[i].style.display = "block";
                } else {
                    details[i].style.display = "none";
                }
            }
        }
    </script>
</head>
<body>
<div class="cv-container">
    <h2>Show All CV</h2>
    <form action="/cv/cvservlet?action=editCV" method="post">
        <ul>
            <% List<CV> cvList = (List<CV>) request.getAttribute("cvList");
                if (cvList != null && !cvList.isEmpty()) {
                    for (int i = 0; i < cvList.size(); i++) { %>
            <li>
                <input type="checkbox" name="CV" value="<%= i %>" onchange="showDetails()">
                <%= cvList.get(i).getName() %>
                <div class="details" style="display: none;">
                    <span>Name: <%= cvList.get(i).getName() %></span><br>
                    <span>Education: <%= cvList.get(i).getEducation() %></span><br>
                    <span>Hobby: <%= cvList.get(i).getHobby() %></span><br>
                    <span>Work Experience: <%= cvList.get(i).getSkills() %></span><br>
                    <span>Skills: <%= cvList.get(i).getWork_experience() %></span><br>
                    <button type="submit" name="edit" value="<%= i %>" formaction="/cv/cvservlet?action=editCV">Edit</button>
                    <button type="submit" name="delete" value="<%= i %>" formaction="/cv/cvservlet?action=deleteCV">Delete</button>
                </div>
            </li>
            <% }
            } %>
        </ul>
    </form>
    <form action="/cv/cvservlet?action=addNewCV" method="get">
        <button type="submit" name="addNewCV">Add new CV</button>
    </form>
</div>
</body>
</html>
