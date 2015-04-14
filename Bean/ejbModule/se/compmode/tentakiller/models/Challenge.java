package se.compmode.tentakiller.models;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Challenges")
public class Challenge {
    private String id;
    private String question;
    private String answer;
    //private Set<Lie> lies;
    private Date created;
    //private Student creator;
    //private Set<Exam> exams;

    public Challenge() {
        id = UUID.randomUUID().toString();
        created = Calendar.getInstance().getTime(); }

    @Id
    @Column(name="Id")
    public String getId() {
        return id; }

    public void setId(String id) {
        this.id = id; }

    @Column(name="Question")
    public String getQuestion() {
        return question; }

    public void setQuestion(String question) {
        this.question = question; }

    @Column(name="Answer")
    public String getAnswer() {
        return answer; }

    public void setAnswer(String answer) {
        this.answer = answer; }

    /*@Column(name="Creator")
    public Student getCreator() {
        return creator; }

    public void setCreator(Student creator) {
        this.creator = creator; }*/

    @Column(name="Created")
    public Date getCreated() {
        return created; }

    public void setCreated(Date created) {
        this.created = created; }

    /*public Set<Exam> getExams() {
        return exams; }

    @ManyToMany
    @JoinColumn(name="Exams", referencedColumnName="Id")
    public void setExams(Set<Exam> exams) {
        this.exams = exams; }

    public Set<Lie> getLies() {
        return lies; }

    @ManyToOne
    @JoinColumn(name="Lies", referencedColumnName="Id")
    public void setLies(Set<Lie> lies) {
        this.lies = lies; }*/ }