package com.genspark.SpringBootDemoApp.Entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name="tbl_employee")
public class Employee {
    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = AUTO)
    private int empid;

    private String name;
    private String address;

    public Employee() {
    }

    public Employee(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public int getempid() {
        return empid;
    }

    public void setempid(int empid) {
        this.empid = empid;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }
}
