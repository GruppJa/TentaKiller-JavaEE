package se.compmode.tentakiller.facade;

import javax.ejb.Local;

import se.compmode.tentakiller.models.Student;

@Local
public interface StudentsLocal {
    public String testicle();
    public Student get(String id);
    public void add(Student student); }