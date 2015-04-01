package se.compmode.tentakiller.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(name="Student.findByName", query="SELECT s FROM Student s WHERE s.name LIKE :name"),
    @NamedQuery(name="Student.findByEmail", query="SELECT s FROM Student s WHERE s.email LIKE :email"),
})
@SequenceGenerator(name="ID_SEQUENCE", allocationSize=1)
@Table(name="Student")
public class Student {
    private long id;
    private String name;
    private String password;
    private String email;

    @Column(name="email", nullable=false, unique=true)
    public String getEmail() {
        return email; }

    public void setEmail(String email) {
        this.email = email; }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    public long getId() {
        return id; }

    public void setId(long id) {
        this.id = id; }

    @Column(name="name")
    public String getName() {
        return name; }

    public void setName(String name) {
        this.name = name; }

    @Column(name="password")
    public String getPassword() {
        return password; }

    public void setPassword(String password) {
        this.password = password; } }