<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" href="css/welcome.css">
    <style>
        .form-group {
            margin-bottom: 20px;
            display: flex;
            align-items: center;
        }

        .form-group label {
            width: 100px;
            text-align: right;
            margin-right: 20px;
        }

        .form-group input {
            flex: 1;
            padding: 10px;
            font-size: 16px;
            border-radius: 5px;
            border: 1px solid #ccc;
            max-width: 250px; /* Максимальна ширина полів вводу */
        }

        .form-group input[type="submit"] {
            width: auto;
            padding: 10px 20px;
            font-size: 16px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .form-group input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
    <script>
        function validateLoginForm() {
            var username = document.forms["loginForm"]["username"].value;
            var password = document.forms["loginForm"]["password"].value;
            if (username.trim() === "") {
                alert("Please enter your name");
                return false;
            }
            if (password.trim() === "") {
                alert("Please enter your password");
                return false;
            }
            return true;
        }

        function validateRegistrationForm() {
            var username = document.forms["registrationForm"]["username"].value;
            var password = document.forms["registrationForm"]["password"].value;
            if (username.trim() === "") {
                alert("Please enter your name");
                return false;
            }
            if (password.trim() === "") {
                alert("Please enter your password");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<div class="welcome-container">
    <h2>Login</h2>
    <form name="loginForm" action="/cv/cvservlet?action=welcome" method="post" onsubmit="return validateLoginForm()">
        <div class="form-group">
            <label for="username">Name:</label>
            <input type="text" id="username" name="username" value="" maxlength="30" placeholder="Enter your name"/>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" value="" placeholder="Enter your password"/>
        </div>
        <div class="form-group">
            <input type="submit" value="Enter">
        </div>
    </form>
    <h2>Registration</h2>
    <form name="registrationForm" action="/cv/cvservlet?action=registration" method="post" onsubmit="return validateRegistrationForm()">
        <div class="form-group">
            <label for="regUsername">Name:</label>
            <input type="text" id="regUsername" name="username" value="" maxlength="30" placeholder="Enter your name"/>
        </div>
        <div class="form-group">
            <label for="regPassword">Password:</label>
            <input type="password" id="regPassword" name="password" value="" placeholder="Enter your password"/>
        </div>
        <div class="form-group">
            <input type="submit" value="Register">
        </div>
    </form>
    <%-- Додамо виведення повідомлення про помилку --%>
    <c:if test="${not empty errorMessage}">
        <div style="color: red;">${errorMessage}</div>
    </c:if>
</div>
</body>
</html>


<%--<html>--%>
<%--<head>--%>
<%--    <title>Welcome</title>--%>
<%--    <link rel="stylesheet" href="css/welcome.css">--%>
<%--    <style>--%>
<%--        .form-group {--%>
<%--            margin-bottom: 20px;--%>
<%--            display: flex;--%>
<%--            align-items: center;--%>
<%--        }--%>

<%--        .form-group label {--%>
<%--            width: 100px;--%>
<%--            text-align: right;--%>
<%--            margin-right: 20px;--%>
<%--        }--%>

<%--        .form-group input {--%>
<%--            flex: 1;--%>
<%--            padding: 10px;--%>
<%--            font-size: 16px;--%>
<%--            border-radius: 5px;--%>
<%--            border: 1px solid #ccc;--%>
<%--            max-width: 250px; /* Максимальна ширина полів вводу */--%>
<%--        }--%>

<%--        .form-group input[type="submit"] {--%>
<%--            width: auto;--%>
<%--            padding: 10px 20px;--%>
<%--            font-size: 16px;--%>
<%--            background-color: #007bff;--%>
<%--            color: #fff;--%>
<%--            border: none;--%>
<%--            border-radius: 5px;--%>
<%--            cursor: pointer;--%>
<%--        }--%>

<%--        .form-group input[type="submit"]:hover {--%>
<%--            background-color: #0056b3;--%>
<%--        }--%>
<%--    </style>--%>
<%--    <script>--%>
<%--        function validateForm() {--%>
<%--            var username = document.forms["userName"]["username"].value;--%>
<%--            var password = document.forms["userName"]["password"].value;--%>
<%--            if (username.trim() === "") {--%>
<%--                alert("Please enter your name");--%>
<%--                return false;--%>
<%--            }--%>
<%--            if (password.trim() === "") {--%>
<%--                alert("Please enter your password");--%>
<%--                return false;--%>
<%--            }--%>
<%--            return true;--%>
<%--        }--%>
<%--    </script>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="welcome-container">--%>
<%--    <form name="userName" action="/cv/cvservlet?action=welcome" method="post" onsubmit="return validateForm()">--%>
<%--        <div class="form-group">--%>
<%--            <label for="username">Name:</label>--%>
<%--            <input type="text" id="username" name="username" value="" maxlength="30" placeholder="Enter your name"/>--%>
<%--        </div>--%>
<%--        <div class="form-group">--%>
<%--            <label for="password">Password:</label>--%>
<%--            <input type="password" id="password" name="password" value="" placeholder="Enter your password"/>--%>
<%--        </div>--%>
<%--        <div class="form-group">--%>
<%--            <input type="submit" value="Enter">--%>
<%--        </div>--%>
<%--    </form>--%>
<%--    &lt;%&ndash; Додамо виведення повідомлення про помилку &ndash;%&gt;--%>
<%--    <c:if test="${not empty errorMessage}">--%>
<%--        <div style="color: red;">${errorMessage}</div>--%>
<%--    </c:if>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
