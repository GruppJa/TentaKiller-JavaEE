package se.compmode.tentakiller.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import se.compmode.tentakiller.facade.StudentsLocal;

/**
 * Servlet implementation class Student
 */
@WebServlet("/student/*")
public class Student extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private StudentsLocal students;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Student() { super(); }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();
        ServletConfig config = getServletConfig();
        // String path = request.getPathInfo();

        System.out.println("< /student");
        System.out.println("  REQUEST :");
        System.out.println("  RemoteAddr " + request.getRemoteAddr());
        System.out.println("  RemoteAddr " + request.getRemoteAddr());
        System.out.println("  Method " + request.getMethod());
        System.out.println("  PathInfo " + request.getPathInfo());
        System.out.println("  RequestURI " + request.getRequestURI());
        System.out.println("  RequestURL " + request.getRequestURL());
        System.out.println("  Session " + request.getSession().getAttributeNames().toString());

        System.out.println("  CONTEXT :");
        System.out.println("  ContextPath " + context.getContextPath());
        System.out.println("  ServerInfo " + context.getServerInfo());

        System.out.println("  CONFIG :");
        System.out.println("  ServletName " + config.getServletName());

        se.compmode.tentakiller.models.Student student;
        // TODO use path instead of ?id (/student/12 instead of /student?id=12)
        String id = (String)request.getParameter("id");
        System.out.println("  id " + id);
        if (id != null) { // /student?id=foo (view specific student)
            student = students.get(id);
            System.out.println("  student " + student);
            if (student == null) {
                // TODO search for id?
                request.setAttribute("id", id);
                request.getRequestDispatcher("/student-not-registered.jsp").forward(request, response); }
            else {
                request.setAttribute("student", student);
                request.getRequestDispatcher("student-info.jsp").forward(request, response); } }
        else { // /student (view the session/user/client or registration/login)
            if (session.getAttribute("student") == null)
                response.sendRedirect("authenticate");
            else // TODO would be nice to tell client to load /student .. (Perhaps through <meta refresh..>
                request.getRequestDispatcher("/student.jsp").forward(request, response); } }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO perhaps student registration should go here rather than authenticate ?
        response.getWriter().println("student login/registration not implemented"); } }