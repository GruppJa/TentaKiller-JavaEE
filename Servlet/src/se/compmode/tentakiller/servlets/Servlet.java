package se.compmode.tentakiller.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.compmode.tentakiller.facade.StudentsLocal;
import se.compmode.tentakiller.models.Student;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private StudentsLocal students;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HEELO? service");
        PrintWriter out = response.getWriter();
        out.println("there is nothing (service) except a "
                + students.testicle());
        Student foo = students.get("food");
        if (foo == null) {
            foo = new Student("food", "my name is foo");
            students.add(foo);
            out.println("created 'food' Student");
        }
        out.println("student with id 'foo' is " + foo);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HEELO? doGet");
        PrintWriter out = response.getWriter();
        out.println("there is nothing (doGet)");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HEELO? doPost");
        PrintWriter out = response.getWriter();
        out.println("there is nothing (doPost)");
    }

    /**
     * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
     */
    protected void doPut(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HEELO? doPut");
        PrintWriter out = response.getWriter();
        out.println("there is nothing (doPut)");
    }

    /**
     * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
     */
    protected void doDelete(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HEELO? doDelete");
        PrintWriter out = response.getWriter();
        out.println("there is nothing (doDelete)");
    }
}