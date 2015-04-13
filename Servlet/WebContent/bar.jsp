<%@page import="se.compmode.tentakiller.models.Student"%>
<% Student student = (Student)session.getAttribute("student"); %>
<aside class="bar">
  <nav>
    <a class="home" href="<%= getServletContext().getContextPath() %>">
      <img src="img/TentaKiller.png" alt="TentaKiller logo" title="TentaKiller logo"/>
    </a>

    <a class="challenges" href="<%= getServletContext().getContextPath() %>/challenges">
      <img src="img/puzzleIcon.png" alt="Challenge icon" title="Challenge icon"/>
    </a>

    <a class="exams" href="<%= getServletContext().getContextPath() %>/exams">
      <img src="img/penIcon.png" alt="Exam icon" title="Exam icon"/>
    </a>

    <a class="students" href="<%= getServletContext().getContextPath() %>/students">
      <img src="img/studentIcon.png" alt="Student icon" title="Student icon"/>
    </a>
  </nav>

  <section class="user">
    <a href="<%= getServletContext().getContextPath() %>/student">
      <% if (student != null) { %>
        <%= student.getName() %>
      <% } else { %>
        Log in / Register
      <% } %>
    </a>
  </section>

  <hr class="clear"/>
</aside>