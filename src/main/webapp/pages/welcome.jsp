<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
      <link rel="stylesheet" href="css/welcome.css">

  </head>
  <body>
  <% request.getSession(true);%>
  <div>
      <form name="userName" action="/cv/cvservlet?action=mainpage" method="post">
          Name: <input type="text" name="username" value="" maxlength="30" placeholder="Enter your name"/>
          <input type="submit" value="Enter">

      </form>
  </div>

  </body>
</html>

