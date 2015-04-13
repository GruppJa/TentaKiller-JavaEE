package se.compmode.tentakiller.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import se.compmode.tentakiller.models.Student;

/**
 * Session Bean implementation class StudentManager
 */
@Stateless
public class StudentManager implements StudentManagerLocal {
    @PersistenceContext(unitName="TentaKiller")
    private EntityManager entities;

    public Student get(String id) {
        return entities.find(Student.class, id); }

    @Override
    public void add(Student student) {
        entities.persist(student); }

    @Override
    public List<Student> findByEmail(String email) {
        TypedQuery<Student> query = entities.createNamedQuery("Student.findByEmail", Student.class);
        query.setParameter("email", email);
        return query.getResultList(); }

    @Override
    public List<Student> findByName(String name) {
        TypedQuery<Student> query = entities.createNamedQuery("Student.findByName", Student.class);
        query.setParameter("name", name);
        return query.getResultList(); }

    @Override
    public List<Student> getAll() {
        TypedQuery<Student> query = entities.createNamedQuery("Student.getAll", Student.class);
        return query.getResultList(); } }