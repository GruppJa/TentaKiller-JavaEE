package se.compmode.tentakiller.eao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import se.compmode.tentakiller.models.Student;

/**
 * Session Bean implementation class StudentManager
 */
@Stateless
public class StudentManager implements StudentManagerLocal {
    @PersistenceContext(unitName="TentaKiller")
    private EntityManager entities;

    /**
     * Default constructor. 
     */
    public StudentManager() { }

    public Student get(String id) {
        return entities.find(Student.class, id); }

    @Override
    public void add(Student student) {
        entities.persist(student); } }