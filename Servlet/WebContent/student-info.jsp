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

    <title><%= student.getName() %> (Student)</title>
  </head>

  <body>
    <header>
      Student information
    </header>

    <dl>
      <dt>Id</dt>
      <dd><%= student.getId() %></dd>

      <dt>E-Mail</dt>
      <dd><%= student.getEmail() %></dd>

      <dt>Name</dt>
      <dd><%= student.getName() %></dd>
    </dl>
  </body>
</html>