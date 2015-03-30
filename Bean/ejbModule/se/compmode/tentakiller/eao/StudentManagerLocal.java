package se.compmode.tentakiller.eao;

import javax.ejb.Local;

import se.compmode.tentakiller.models.Student;

@Local
public interface StudentManagerLocal {
    public Student get(String id);
    public void add(Student student); }