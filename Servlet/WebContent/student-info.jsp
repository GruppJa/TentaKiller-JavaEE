<%@page import="se.compmode.tentakiller.facade.StudentsLocal"%>
<%@page import="javax.ejb.EJB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="se.compmode.tentakiller.models.Student, javax.servlet.http.HttpSession"%>
<% Student student = (Student)request.getAttribute("student"); %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">

    <title><%= student.getName() %> (Student)</title>

    <link rel="stylesheet" type="text/css" href="../css/main.css"></link>
  </head>

  <body>
    <jsp:include page="bar.jsp"/>

    <article class="student">
      <header class="name">
        <%= student.getName() %>
      </header>

      <h2>Id</h2>
      <span class="id"><%= student.getId() %></span>

      <h2>E-Mail</h2>
      <a class="email" href="mailto:<%= student.getEmail() %>">
        <%= student.getEmail() %>
      </a>
    </article>
  </body>
</html>