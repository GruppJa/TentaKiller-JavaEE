package se.compmode.tentakiller.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student {
    private String id;
    private String name;

    public Student() { }

    public Student(String id, String name) {
        this.id = id;
        this.name = name; }

    @Id
    @Column(name="id")
    public String getId() {
        return id; }

    public void setId(String id) {
        this.id = id; }

    @Column(name="name")
    public String getName() {
        return name; }

    public void setName(String name) {
        this.name = name; } }