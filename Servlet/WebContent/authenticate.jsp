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

  <body id="main">
    <jsp:include page="bar.jsp"/>

    <header>
      <p>Hello and welcome to TentaKillers student Registration / Login page.</p>
    </header>

    <%
      String error = (String)request.getAttribute("error");
      out.println("got error?");
      if (error != null) {
          out.println(error); }
    %>
	<div id="section">
	    <form name="authenticate" action="authenticate" method="POST">
	      <input id="inputFeild" type="text" name="email" placeholder="E-Mail"<% if (request.getAttribute("email") != null) { out.println(" value=\"" + request.getAttribute("email") + "\""); } %>/>
	      </br>
	      <input id="inputFeild" type="password" name="password" placeholder="Password"<% if (request.getAttribute("password") != null) { out.println(" value=\"" + request.getAttribute("password") + "\""); } %>/>
	      <br/>
     	  <input id="inputBox" type="submit" name="login" value="Login"/>
     	  </br>
     	  <input id="inputFeild" type="text" name="name" placeholder="Name"<% if (request.getAttribute("name") != null) { out.println(" value=\"" + request.getAttribute("name") + "\""); } %>/>
	      </br>
      	  <input id="inputBox" type="submit" name="register" value="Register"/>
      	  </br>
	    </form>
	</div>
  </body>
</html>