package se.compmode.tentakiller.eao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import se.compmode.tentakiller.models.Student;
import se.compmode.tentakiller.models.Trial;

/**
 * Session Bean implementation class StudentManager
 */
@Stateless
@LocalBean
public class TrialManager implements TrialManagerLocal {
    @PersistenceContext(unitName="TentaKiller")
    private EntityManager entities;

    public Trial get(String id) {
        return entities.find(Trial.class, id); }

    @Override
    public void add(Trial trial) {
        entities.persist(trial); }

    @Override
    public List<Trial> findByStudent(Student student) {
        TypedQuery<Trial> query = entities.createNamedQuery("Trial.findByStudent", Trial.class);
        query.setParameter("student", student.getId());
        return query.getResultList(); }

    @Override
    public List<Trial> getAll() {
        TypedQuery<Trial> query = entities.createNamedQuery("Trial.getAll", Trial.class);
        return query.getResultList(); } }