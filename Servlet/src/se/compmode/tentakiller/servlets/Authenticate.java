package se.compmode.tentakiller.servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.compmode.tentakiller.facade.StudentsLocal;

/**
 * Servlet implementation class Login
 */
@WebServlet("/authenticate")
public class Authenticate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private StudentsLocal students;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authenticate() { super(); }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("student") != null)
            response.sendRedirect("student");
        else
            request.getRequestDispatcher("authenticate.jsp").forward(request, response); }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("login") != null) {
            String email = (String)request.getParameter("email");
            String password = (String)request.getParameter("password");
            if (email != null && password != null) {
                List<se.compmode.tentakiller.models.Student> matches = students.getByEmail(email);
                System.out.println("/login POST email : " + email + ", matches : " + matches + " length: " + matches.size());
                Iterator<se.compmode.tentakiller.models.Student> i = matches.iterator();
                while (i.hasNext()) {
                    se.compmode.tentakiller.models.Student student = i.next();
                    if (password.equals(student.getPassword())) {
                        request.getSession().setAttribute("student", student);
                        response.sendRedirect("student");
                        return; } } }
            request.setAttribute("error", "You've entered invalid login credentials, please try again.");
            request.setAttribute("email", email);
            request.getRequestDispatcher("authenticate.jsp").forward(request, response);
        }
        else if (request.getParameter("logout") != null) {
            request.getSession().removeAttribute("student");
            //request.getRequestDispatcher("authenticate.jsp").forward(request, response);
            response.sendRedirect("student");
        }
        else if (request.getParameter("register") != null) { // TODO Should perhaps be part of the Student servlet rather than Authenticate.
            String email = (String)request.getParameter("email");
            String name = (String)request.getParameter("name");
            String password = (String)request.getParameter("password");
            if (email != null && email.length() > 0 && email.length() < 256
                    && name != null && name.length() > 0 && name.length() < 256
                    && password != null && email.length() > 0 && email.length() < 256) {
                List<se.compmode.tentakiller.models.Student> matches = students.getByEmail(email);
                if (matches.size() > 0) {
                    request.setAttribute("error", "That E-Mail addresss is already registered");
                    request.setAttribute("email", email);
                    request.setAttribute("name", name);
                    request.setAttribute("password", password);
                    request.getRequestDispatcher("authenticate.jsp").forward(request, response); }
                else {
                    se.compmode.tentakiller.models.Student student = students.createStudent(email, name, password);
                    request.getSession().setAttribute("student", student);
                    response.sendRedirect("student");
                } }
            else {
                request.setAttribute("error", "A registration needs an E-Mail, Name and Password.");
                request.setAttribute("email", email);
                request.setAttribute("name", name);
                request.setAttribute("password", password);
                request.getRequestDispatcher("authenticate.jsp").forward(request, response); } } } }