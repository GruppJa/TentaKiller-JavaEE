<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/main.css"></link>
    <title>TentaKiller - Not a valid student record</title>
  </head>

  <body>
    <jsp:include page="bar.jsp"/>

    <header>
      No student with that id (<%= request.getAttribute("id") %>) is registered.
    </header>
  </body>
</html>