package se.compmode.tentakiller.models;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Lies")
public class Lie {
    private String id;
    private String text;
    private Date created;
    //private Student creator;
    //private Challenge challenge;

    public Lie() {
        id = UUID.randomUUID().toString();
        created = Calendar.getInstance().getTime(); }

    @Id
    @Column(name="Id")
    public String getId() {
        return id; }

    public void setId(String id) {
        this.id = id; }

    @Column(name="Text")
    public String getText() {
        return text; }

    public void setText(String text) {
        this.text = text; }

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

    /*public Challenge getChallenge() {
        return challenge; }

    @OneToMany
    @JoinColumn(name="Challenge", referencedColumnName="Id")
    public void setChallenge(Challenge challenge) {
        this.challenge = challenge; }*/ }