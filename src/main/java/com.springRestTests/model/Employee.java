package com.springRestTests.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="employee")
@NoArgsConstructor
public class  Employee {
    @Id
    @Column(name = "ID")
    @Getter @Setter private int id;

    @Column(name = "Name")
    @Getter @Setter private  String ename;

    @Column(name = "Position")
    @Getter @Setter private String position;

    public Employee(String ename, String position) {
        this.ename = ename;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empno=" + id +
                ", ename='" + ename + '\'' +
                ", jobtitle='" + position + '\'' +
                '}';
    }
}
