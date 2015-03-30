package se.compmode.tentakiller.facade;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import se.compmode.tentakiller.eao.StudentManagerLocal;
import se.compmode.tentakiller.models.Student;

/**
 * Session Bean implementation class Student
 */
@Stateless
public class Students implements StudentsLocal {

    @EJB
    private StudentManagerLocal students;

    public Students() { }

    public String testicle() {
        return "you are a testicle"; }

    /*public Student findByName(String name) {
        System.out.println("NOT IMPLEMENTED facade.Student.find(String name)");
        return null; }*/

    public Student get(String id) {
        System.out.println("NOT IMPLEMENTED facade.Student.get(String id)");
        System.out.println("StudentManager is " + students);
        return students.get(id); }

    @Override
    public void add(Student student) {
        students.add(student); } }