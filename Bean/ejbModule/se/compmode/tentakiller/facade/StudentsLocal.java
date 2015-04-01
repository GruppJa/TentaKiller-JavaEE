package se.compmode.tentakiller.facade;

import java.util.List;

import javax.ejb.Local;

import se.compmode.tentakiller.models.Student;

@Local
public interface StudentsLocal {
    public String testicle();
    public Student get(String id);
    public void add(Student student);
    public Student createStudent(String email, String name, String password);
    public List<Student> findByName(String name);
    public List<Student> getByName(String name);
    public List<Student> findByEmail(String email);
    public List<Student> getByEmail(String email); }