package com.example.aplikacja_randkowa;

public class Person {
    private String name;
    private int age;
    private String gender;
    private String description;

    public Person(String name, int age, String gender, String description) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDescription() {
        return description;
    }
}
