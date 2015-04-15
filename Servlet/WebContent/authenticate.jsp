<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta content="UTF-8">
    <title>Student - Registration / Login</title>    
    <link rel="stylesheet" type="text/css" href="css/main.css"></link>
    <script type="application/javascript" src="js/registration.js"></script>
  </head>

  <body>
    <jsp:include page="header.jsp"/>

    <section class="authenticate">
      <header>
        Log in / Register
      </header>

      <span class="error">
        <%
          String error = (String)request.getAttribute("error");
          if (error != null) { out.println(error); }
        %>
      </span>

      <form name="authenticate" action="authenticate" method="POST">
        <input type="text" name="email" placeholder="E-Mail"<% if (request.getAttribute("email") != null) { out.println(" value=\"" + request.getAttribute("email") + "\""); } %>/>
        </br>

        <input type="password" name="password" placeholder="Password"<% if (request.getAttribute("password") != null) { out.println(" value=\"" + request.getAttribute("password") + "\""); } %>/>
        <br/>

        <input type="submit" name="login" value="Log in"/>
        </br>

        <input type="text" name="name" placeholder="Name"<% if (request.getAttribute("name") != null) { out.println(" value=\"" + request.getAttribute("name") + "\""); } %>/>
        </br>

        <input type="submit" name="register" value="Register"/>
        </br>
      </form>
    </section>

    <jsp:include page="footer.jsp"/>
  </body>
</html>