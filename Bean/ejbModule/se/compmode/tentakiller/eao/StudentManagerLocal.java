package se.compmode.tentakiller.eao;

import java.util.List;

import javax.ejb.Local;

import se.compmode.tentakiller.models.Student;

@Local
public interface StudentManagerLocal {
    public Student get(long id);
    public void add(Student student);
    public List<Student> findByName(String name);
    public List<Student> findByEmail(String email); }