<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta content="UTF-8">

    <title>Student - Registration / Login</title>

    <script type="application/javascript" src="js/registration.js"></script>
  </head>

  <body>
    <header>
      Hello, whoever you are..
    </header>

    <%
      String error = (String)request.getAttribute("error");
      out.println("got error?");
      if (error != null) {
          out.println(error); }
    %>

    <form name="authenticate" action="authenticate" method="POST">
      <input type="text" name="email" placeholder="E-Mail"<% if (request.getAttribute("email") != null) { out.println(" value=\"" + request.getAttribute("email") + "\""); } %>/>
      <input type="text" name="name" placeholder="Name"<% if (request.getAttribute("name") != null) { out.println(" value=\"" + request.getAttribute("name") + "\""); } %>/>
      <input type="password" name="password" placeholder="Password"<% if (request.getAttribute("password") != null) { out.println(" value=\"" + request.getAttribute("password") + "\""); } %>/>
      <br/>
      <input type="submit" name="login" value="Login"/>
      <input type="submit" name="register" value="Register"/>
    </form>
  </body>
</html>