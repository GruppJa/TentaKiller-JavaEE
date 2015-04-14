package se.compmode.tentakiller.eao;

import java.util.List;

import javax.ejb.Local;

import se.compmode.tentakiller.models.Student;
import se.compmode.tentakiller.models.Trial;

@Local
public interface TrialManagerLocal {
    public Trial get(String id);
    public void add(Trial trial);
    public List<Trial> findByStudent(Student student);
    public List<Trial> getAll(); }