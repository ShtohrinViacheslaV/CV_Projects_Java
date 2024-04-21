<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
    <link rel="stylesheet" href="css/template.css">
    <style>
        .button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 4px;
            margin-top: 20px; /* Вирівнювання кнопки зправа */
            margin-right: 20px; /* Вирівнювання кнопки зправа */
        }

        .rectangle-container {
            display: flex;
            justify-content: center; /* Центруємо прямокутники по горизонталі */
            align-items: center; /* Центруємо прямокутники по вертикалі */
            max-width: 100%; /* Максимальна ширина контейнера */
            margin: 20px auto; /* Загальні відступи відцентру */
        }


        .rectangle {
            width: 250px; /* Фіксована ширина прямокутника */
            height: 150px; /* Фіксована висота прямокутника */
            margin: 10px; /* Відступи між прямокутниками */
            text-align: center; /* Вирівнюємо текст по центру */
            font-size: 18px;
            color: white;
            text-decoration: none;
            background-color: #3498db;
            border-radius: 5px;
            overflow: hidden;
            position: relative;
        }

        .rectangle img {
            max-width: 100%; /* Зображення займає максимально доступну ширину */
            height: auto; /* Зберігаємо пропорції зображення */
        }

        .rectangle div {
            position: absolute;
            bottom: 0;
            left: 0;
            width: 100%;
            background-color: rgba(52, 73, 94, 0.7);
            padding: 5px;
        }

    </style>
</head>
<body>
<div id="header">

    <h1>Hello, <%=request.getSession().getAttribute("username")%></h1>
    <p>
        <a href="/cv/cvservlet?action=logout" class="button">Exit</a>
    </p>
</div>
<div id="main">
    <div class="rectangle-container">
            <a class="rectangle" href="cvservlet?action=it">
                <img src="images/it.jpg" alt="IT" />
                <div>IT</div>
            </a>
            <a class="rectangle" href="cvservlet?action=marketing">
                <img src="images/marketing.jpg" alt="Marketing" />
                <div>Marketing</div>
            </a>
            <a class="rectangle" href="cvservlet?action=finance">
                <img src="images/finance.jpg" alt="Finance" />
                <div>Finance</div>
            </a>
            <a class="rectangle" href="cvservlet?action=showAllCV">
                <img src="images/cvall.jpg" alt="CV" />
                <div>CV</div>
            </a>
    </div>
</div>
<div id="footer">Copyright 1900-2024</div>
</body>
</html>



<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Home page</title>--%>
<%--    <link rel="stylesheet" href="css/template.css">--%>
<%--    <style>--%>
<%--        #header {--%>
<%--            display: flex;--%>
<%--            justify-content: space-between;--%>
<%--            align-items: center;--%>
<%--        }--%>

<%--        #logout-button {--%>
<%--            background-color: #f44336;--%>
<%--            color: white;--%>
<%--            border: none;--%>
<%--            padding: 10px 20px;--%>
<%--            text-align: center;--%>
<%--            text-decoration: none;--%>
<%--            display: inline-block;--%>
<%--            font-size: 16px;--%>
<%--            margin-right: 20px;--%>
<%--            cursor: pointer;--%>
<%--            border-radius: 4px;--%>
<%--        }--%>

<%--        #menu ul {--%>
<%--            margin: 0;--%>
<%--            padding: 0;--%>
<%--            list-style-type: none;--%>
<%--            display: flex;--%>
<%--        }--%>

<%--        #menu ul li {--%>
<%--            margin-right: 20px;--%>
<%--        }--%>

<%--        #menu ul li a {--%>
<%--            color: #333;--%>
<%--            text-decoration: none;--%>
<%--            font-weight: bold;--%>
<%--        }--%>

<%--        #menu ul li a:hover {--%>
<%--            color: #f44336;--%>
<%--        }--%>
<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div id="header">--%>
<%--    <div>--%>
<%--        <h1>Home page</h1>--%>
<%--        <p>Hello, <%=request.getSession().getAttribute("username")%></p>--%>
<%--    </div>--%>
<%--    <div>--%>
<%--        <a id="logout-button" href="/cv/cvservlet?action=logout">Exit</a>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<div id="wrapper">--%>
<%--    <div id="menu">--%>
<%--        <ul>--%>
<%--            <li class="rectangle it"><a href="/cv/cvservlet?action=it">IT</a></li>--%>
<%--            <li class="rectangle marketing"><a href="/cv/cvservlet?action=marketing">Marketing</a></li>--%>
<%--            <li class="rectangle finance"><a href="/cv/cvservlet?action=finance">Finance</a></li>--%>
<%--            <li class="rectangle cv"><a href="/cv/cvservlet?action=showAllCV">CV</a></li>--%>
<%--        </ul>--%>
<%--    </div>--%>
<%--</div>--%>

<%--&lt;%&ndash;<div id="menu">&ndash;%&gt;--%>
<%--&lt;%&ndash;    <ul>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <li><a href="/cv/cvservlet?action=it">IT</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <li><a href="/cv/cvservlet?action=marketing">Marketing</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <li><a href="/cv/cvservlet?action=finance">Finance</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <li><a href="/cv/cvservlet?action=showAllCV">CV</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </ul>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;<div id="main">&ndash;%&gt;--%>
<%--&lt;%&ndash;    &lt;%&ndash;%>--%>
<%--&lt;%&ndash;        String includedPage = (String) request.getSession().getAttribute("includedPage");&ndash;%&gt;--%>
<%--&lt;%&ndash;        if (includedPage != null){&ndash;%&gt;--%>
<%--&lt;%&ndash;    %>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <jsp:include page="<%=includedPage%>"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;    &lt;%&ndash;%>--%>
<%--&lt;%&ndash;        }&ndash;%&gt;--%>
<%--&lt;%&ndash;    %>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--<div id="footer">Copyright 1900-2024</div>--%>
<%--</body>--%>
<%--</html>--%>
