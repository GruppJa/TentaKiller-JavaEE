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
        <a href="<%= student.getId() %>">
          <%= student.getName() %>
        </a>
      </header>

      <a class="email" href="mailto:<%= student.getEmail() %>">
        <%= student.getEmail() %>
      </a>

      <section class="trials">
        <header>Trials</header>

        <c:forEach var="trial" items="${student.getTrials()}">
          <article class="trial">
            <header>
              <a href="../exam/<c:out value="${trial.getExam().getId()}"/>">
                <span class="exam name">
                  <c:out value="${trial.getExam().getName()}"/>
                </span>
              </a>
            </header>

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

              <dt>Id</dt>
              <dd>
                <a href="../trial/<c:out value="${trial.getId()}"/>">
                  <c:out value="${trial.getId()}"/>
                </a>
              </dd>
            </dl>
          </article>
        </c:forEach>
      </section>
    </article>

    <jsp:include page="footer.jsp"/>
  </body>
</html>