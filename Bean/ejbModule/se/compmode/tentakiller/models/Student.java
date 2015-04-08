package se.compmode.tentakiller.models;

import java.util.Date;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
    @NamedQuery(name="Student.findByName", query="SELECT s FROM Student s WHERE s.name LIKE :name"),
    @NamedQuery(name="Student.findByEmail", query="SELECT s FROM Student s WHERE s.email LIKE :email"),
})
@SequenceGenerator(name="ID_SEQUENCE", allocationSize=1)
@Table(name="Students")
public class Student {
    private long id;
    private String name;
    private String password;
    private String email;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    public Student() {
        created = Calendar.getInstance().getTime(); }

    @Column(name="Email", nullable=false, unique=true)
    public String getEmail() {
        return email; }

    public void setEmail(String email) {
        this.email = email; }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="Id")
    public long getId() {
        return id; }

    public void setId(long id) {
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