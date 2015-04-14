package se.compmode.tentakiller.models;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Exams")
public class Exam {
    private String id;
    private String name;
    private Date created;
    private Student creator;
    //private Set<Challenge> challenges;
    private Set<Trial> trials;

    public Exam() {
        id = UUID.randomUUID().toString();
        created = Calendar.getInstance().getTime(); }

    @Id
    @Column(name="Id")
    public String getId() {
        return id; }

    public void setId(String id) {
        this.id = id; }

    @Column(name="Name")
    public String getName() {
        return name; }

    public void setName(String name) {
        this.name = name; }

    @ManyToOne
    @JoinColumn(referencedColumnName="Id")
    public Student getCreator() {
        return creator; }

    public void setCreator(Student creator) {
        this.creator = creator; }

    @Column(name="Created")
    public Date getCreated() {
        return created; }

    public void setCreated(Date created) {
        this.created = created; }

    /*public Set<Challenge> getChallenges() {
        return challenges; }

    @ManyToMany
    @JoinColumn(name="Challenge", referencedColumnName="Id")
    public void setChallenges(Set<Challenge> challenges) {
        this.challenges = challenges; }*/

    @OneToMany(mappedBy="exam", fetch=FetchType.EAGER)
    public Set<Trial> getTrials() {
        return trials; }

    public void setTrials(Set<Trial> trials) {
        this.trials = trials; } }