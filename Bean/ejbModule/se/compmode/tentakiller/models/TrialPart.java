package se.compmode.tentakiller.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TrialParts")
public class TrialPart {
    private String id;
    private String answer;
    private int points;
    //private Trial trial;
    //private Challenge challenge;

    public TrialPart() {
        id = UUID.randomUUID().toString();
        points = 1; }

    @Id
    @Column(name="Id")
    public String getId() {
        return id; }

    public void setId(String id) {
        this.id = id; }

    @Column(name="Answer")
    public String getAnswer() {
        return answer; }

    public void setAnswer(String answer) {
        this.answer = answer; }

    /*@Column(name="Trial")
    public Trial getTrial() {
        return trial; }

    public void setTrial(Trial trial) {
        this.trial = trial; }*/

    /*@ManyToOne
    @JoinColumn(name="Challenges", referencedColumnName="Id")
    public Challenge getChallenge() {
        return challenge; }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge; }*/

    @Column(name="Points")
    public int getPoints() {
        return points; }

    public void setPoints(int points) {
        this.points = points; } }