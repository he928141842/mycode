package com.hh.myproject.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author hejiayuan
 * @date 2020-09-23 10:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    String name;
    int age;
    List<String> hobbits;
    String city;


    public User(String name, int age, List<String> hobbits) {
        this.name = name;
        this.age = age;
        this.hobbits = hobbits;
    }

    public User(String name){
        this.name = name;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
