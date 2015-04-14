<%@ page import="java.util.List"%>
<%@ page import="se.compmode.tentakiller.facade.StudentsLocal"%>
<%@ page import="javax.ejb.EJB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="se.compmode.tentakiller.models.Student, javax.servlet.http.HttpSession"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% List<Student> students = (List<Student>)request.getAttribute("students"); %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">

    <title>TentaKiller Students</title>

    <link rel="stylesheet" type="text/css" href="css/main.css"></link>
  </head>

  <body>
    <jsp:include page="header.jsp"/>

    <header>
      There is a total of <%= students.size() %> Students.
    </header>

    <section class="student">
      <c:forEach var="student" items="${students}">
        <article class="student">
          <header class="name">
            <a href="student/<c:out value="${student.getId()}"/>">
              <c:out value="${student.getName()}"/>
            </a>
          </header>

          <c:out value="${student.getTrials().size()}"/> trials
        </article>
      </c:forEach>
    </section>

    <jsp:include page="footer.jsp"/>
  </body>
</html>