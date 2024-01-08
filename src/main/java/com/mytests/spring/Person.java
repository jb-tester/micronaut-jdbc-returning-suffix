package com.mytests.spring;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;

@MappedEntity(schema = "jbtests")
public class Person {
    @Id
    @GeneratedValue
    Integer id;
    @MappedProperty("first_name")
    String name;
    @MappedProperty("last_name")
    String surname;
    int age;
    SexEnum sex;
    boolean retired;

    public Person(String name, String surname, int age, SexEnum sex, boolean retired) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
        this.retired = retired;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public boolean isRetired() {
        return retired;
    }

    public void setRetired(boolean retired) {
        this.retired = retired;
    }

    @Override
    public String toString() {
        return "Person{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", surname='" + surname + '\'' +
               ", age=" + age +
               ", sex=" + sex +
               ", retired=" + retired +
               '}';
    }
}
