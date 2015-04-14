<%@ page import="se.compmode.tentakiller.facade.StudentsLocal" %>
<%@ page import="javax.ejb.EJB" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="se.compmode.tentakiller.models.Student, javax.servlet.http.HttpSession" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% Student student = (Student)request.getAttribute("student"); %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">

    <title><%= student.getName() %> (TentaKiller Student)</title>

    <link rel="stylesheet" type="text/css" href="../css/main.css"></link>
  </head>

  <body>
    <jsp:include page="header.jsp"/>

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

      <section class="trials">
        <header>Trials</header>

        <c:forEach var="trial" items="${student.getTrials()}">
          <article class="trial">
            <header>
              <span class="exam name">
                <c:out value="${trial.getExam().getName()}"/>
              </span>
            </header>

            <span class="trial id">
              <c:out value="${trial.getId()}"/>
            </span>

            <dl>
              <dt>Points</dt>
              <dd>
                <c:out value="${trial.getPoints()}"/>/<c:out value="${trial.getMaxPoints()}"/>
              </dd>

              <dt>Started</dt>
              <dd>
                <c:out value="${trial.getStarted()}"/>
              </dd>

              <dt>Ended</dt>
              <dd>
                <c:out value="${trial.getEnded()}"/>
              </dd>

              <dt>Exam Creator</dt>
              <dd>
                <c:out value="${trial.getExam().getCreator().getName()}"/>
              </dd>
            </dl>
          </article>
        </c:forEach>
      </section>
    </article>

    <jsp:include page="footer.jsp"/>
  </body>
</html>