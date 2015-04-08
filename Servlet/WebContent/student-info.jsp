<%@page import="se.compmode.tentakiller.facade.StudentsLocal"%>
<%@page import="javax.ejb.EJB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="se.compmode.tentakiller.models.Student, javax.servlet.http.HttpSession"%>

<%
Student student = (Student)request.getAttribute("student");
//if (student == null) {
//  request.getRequestDispatcher("/TentaKiller").forward(request, response); }
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/main.css"></link>
    <title><%= student.getName() %> (Student)</title>
  </head>

  <body>
    <header>
      Student information
    </header>
      <dl id="section">
	  <input id="inputFeild" type="text" name="country" value="student.getId()" readonly><br>

      <dt>E-Mail</dt>
      <input id="inputFeild" type="text" name="country" value="student.getEmail()" readonly><br>

      <dt>Name</dt>
      <input id="inputFeild" type="text" name="country" value="student.getName()" readonly><br>
    </dl>
  </body>
</html>