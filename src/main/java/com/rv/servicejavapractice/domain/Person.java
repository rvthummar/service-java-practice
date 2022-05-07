package com.rv.servicejavapractice.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
    private enum Gender {
        MALE, FEMALE
    }

    private String name;
    private int age;
    private Gender gender;

    String getPersonDetails() {
        return this.toString();
    }

    public static List<Person> generatePersonList() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Ravi", 23, Gender.MALE));
        personList.add(new Person("Jenish", 22, Gender.MALE));
        personList.add(new Person("Jayraj", 20, Gender.MALE));
        personList.add(new Person("Hiren", 22, Gender.MALE));
        personList.add(new Person("Dipali", 24, Gender.FEMALE));
        return personList;
    }
}
