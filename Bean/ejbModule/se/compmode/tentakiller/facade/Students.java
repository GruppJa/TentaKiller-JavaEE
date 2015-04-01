package se.compmode.tentakiller.facade;

import java.util.List;

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

    public String testicle() {
        return "you are a testicle"; }

    /*public Student findByName(String name) {
        System.out.println("NOT IMPLEMENTED facade.Student.find(String name)");
        return null; }*/

    public Student get(String id) {
        System.out.println("Students.get(id) students : " + students);
        return students.get(id); }

    @Override
    public void add(Student student) {
        students.add(student); }

    @Override
    public Student createStudent(String email, String name, String password) {
        Student student = new Student();
        student.setEmail(email);
        student.setName(name);
        student.setPassword(password);
        students.add(student);
        return student; }

    @Override
    public List<Student> findByEmail(String email) {
        return students.findByEmail("%" + email + "%"); }

    @Override
    public List<Student> getByEmail(String email) {
        return students.findByEmail(email); } 

    @Override
    public List<Student> findByName(String name) {
        return students.findByName("%" + name + "%"); }

    @Override
    public List<Student> getByName(String name) {
        return students.findByName(name); } }