package se.compmode.tentakiller.models;

import java.util.Date;
import java.util.Calendar;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
    @NamedQuery(name="Student.findByName", query="SELECT s FROM Student s WHERE s.name LIKE :name"),
    @NamedQuery(name="Student.findByEmail", query="SELECT s FROM Student s WHERE s.email LIKE :email"),
})
@Table(name="Students")
public class Student {
    private String id;
    private String name;
    private String password;
    private String email;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    public Student() {
        id = UUID.randomUUID().toString();
        created = Calendar.getInstance().getTime(); }

    @Column(name="Email", nullable=false, unique=true)
    public String getEmail() {
        return email; }

    public void setEmail(String email) {
        this.email = email; }

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

    @Column(name="Password")
    public String getPassword() {
        return password; }

    public void setPassword(String password) {
        this.password = password; } 

    @Column(name="Created")
    public Date getCreated() {
        return created; }

    public void setCreated(Date created) {
        this.created = created; } }