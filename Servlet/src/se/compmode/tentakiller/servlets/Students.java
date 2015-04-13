package se.compmode.tentakiller.servlets;

import java.io.IOException;
import java.util.List;

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
@WebServlet("/students")
public class Students extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private StudentsLocal students;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Students() { super(); }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();
        ServletConfig config = getServletConfig();
        String path = request.getPathInfo();

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

        List<se.compmode.tentakiller.models.Student> all = students.getAll();
        request.setAttribute("students", all);
        request.getRequestDispatcher("students.jsp").forward(request, response); } }