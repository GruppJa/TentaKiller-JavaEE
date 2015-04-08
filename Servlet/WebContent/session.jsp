<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta content="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/main.css"></link>
    <title>Session information</title>
  </head>

  <body>
    <header>
        <h1>Session information</h1>
    </header>

    <h2>Id</h2>
    <%= session.getId() %>

    <h2>Creation time</h2>
    <%= session.getCreationTime() %>
  </body>
</html>