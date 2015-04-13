<%@page import="se.compmode.tentakiller.facade.StudentsLocal"%>
<%@page import="javax.ejb.EJB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="se.compmode.tentakiller.models.Student, javax.servlet.http.HttpSession"%>

<%
Student student = (Student)session.getAttribute("student");
//if (student == null) {
//  request.getRequestDispatcher("/TentaKiller").forward(request, response); }
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/main.css"></link>
    <title>Current Student</title>
  </head>

  <body>
    <jsp:include page="header.jsp"/>

    <header>
      Hello <%= student.getName() %>! : )
    </header>

    <table>
      <tr class="id">
        <td class="key">id</td>
        <td class="value"><%= student.getId() %></td>
      </tr>

      <tr class="email">
        <td class="key">email</td>
        <td class="value"><%= student.getEmail() %></td>
      </tr>

      <tr class="name">
        <td class="key">name</td>
        <td class="value"><%= student.getName() %></td>
      </tr>

      <tr class="name">
        <td class="key">creationTime</td>
        <td class="value">(not implemented)</td>
      </tr>
    </table>

    <form action="authenticate" method="POST">
        <input type="submit" name="logout" value="Log out"/>
    </form>

    <jsp:include page="footer.jsp"/>
  </body>
</html>