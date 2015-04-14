package se.compmode.tentakiller.models;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
    @NamedQuery(name="Trial.getAll", query="SELECT t FROM Trial t"),
    @NamedQuery(name="Trial.getByStudent", query="SELECT t FROM Trial t WHERE t.student=:student"),
})
@Table(name="Trials")
public class Trial {
    private String id;
    private Exam exam;
    private Student student;
    @Temporal(TemporalType.TIMESTAMP)
    private Date started;
    @Temporal(TemporalType.TIMESTAMP)
    private Date ended;
    private boolean graded;
    private int points;
    private int maxPoints;
    //private Set<TrialPart> parts;

    public Trial() {
        id = UUID.randomUUID().toString();
        started = Calendar.getInstance().getTime(); }

    @Id
    @Column(name="Id")
    public String getId() {
        return id; }

    public void setId(String id) {
        this.id = id; }

    @ManyToOne
    @JoinColumn(referencedColumnName="Id")
    public Exam getExam() {
        return exam; }

    public void setExam(Exam exam) {
        this.exam = exam; }

    @ManyToOne
    @JoinColumn(referencedColumnName="Id")
    public Student getStudent() {
        return student; }

    public void setStudent(Student student) {
        this.student = student; }

    @Column(name="Started")
    public Date getStarted() {
        return started; }

    public void setStarted(Date started) {
        this.started = started; }

    @Column(name="Ended")
    public Date getEnded() {
        return ended; }

    public void setEnded(Date ended) {
        this.ended = ended; }

    @Column(name="Graded")
    public boolean getGraded() {
        return graded; }

    public void setGraded(boolean graded) {
        this.graded = graded; }

    @Column(name="Points")
    public int getPoints() {
        return points; }

    public void setPoints(int points) {
        this.points = points; }

    @Column(name="MaxPoints")
    public int getMaxPoints() {
        return maxPoints; }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints; }

    /*public Set<TrialPart> getParts() {
        return parts; }

    public void setParts(Set<TrialPart> parts) {
        this.parts = parts; }*/ }