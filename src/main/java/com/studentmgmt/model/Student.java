package com.studentmgmt.model;

public class Student {
    private int id;
    private String name;
    private int age;
    private String course;
    private double fees;
    private String email;
    private String phone;

    public Student() {}

    public Student(int id, String name, int age, String course, double fees, String email, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.fees = fees;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
