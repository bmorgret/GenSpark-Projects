package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Student {
    private int id;
    private String name;
    private List<Phone> ph;
    private Address add;



    public int getId() {
        return id;
    }
    @Autowired
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    @Autowired
    @Qualifier("name")
    public void setName(String name) {
        this.name = name;
    }
    public List<Phone> getPh() {
        return ph;
    }
    @Autowired
    public void setPh(List<Phone> ph) {
        this.ph = ph;
    }
    public Address getAdd() {
        return add;
    }
    @Autowired
    public void setAdd(Address add) {
        this.add = add;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ph=" + ph +
                ", add=" + add +
                '}';
    }
}
