package com.hh.myproject.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

/**
 * @author hejiayuan
 * @date 2020-09-23 10:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SameUser {
    String name;
    int age;
    List<String> hobbits;
    String city;


    public SameUser(String name, int age, List<String> hobbits) {
        this.name = name;
        this.age = age;
        this.hobbits = hobbits;
    }

    public SameUser(String name){
        this.name = name;
    }

    public SameUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SameUser user = (SameUser) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
