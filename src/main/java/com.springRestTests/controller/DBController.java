package com.springRestTests.controller;

import com.google.gson.Gson;
import com.springRestTests.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DBController {
    private SessionFactory factory = null;

    public SessionFactory getConfig(Class cls){
        factory = new Configuration()
                .addAnnotatedClass(cls)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        return factory;
    }

    public String getAllEmployee(){

        Session session = getConfig(Employee.class).getCurrentSession();

        List<Employee> list;
        try{
            session.beginTransaction();
            list = session.createQuery("from Employee").list();
            session.getTransaction().commit();

        }finally {
            factory.close();
            session.close();
        }

        return new Gson().toJson(list);
    }

    public String getEmployeeById(String id){
        Session session = getConfig(Employee.class).getCurrentSession();
        List<Employee> list;
        try {
            session.beginTransaction();
            list = session.createQuery("from Employee E where E.id = " + id).list();
            session.getTransaction().commit();
        }finally {
            factory.close();
            session.close();
        }

        return new Gson().toJson(list);
    }

    public String addEmployeer(String name, String position){
        Session session = getConfig(Employee.class).getCurrentSession();

        Employee newEmp = new Employee(name,position);
        try {
            session.beginTransaction();

            session.save(newEmp);

            session.getTransaction().commit();

        }finally {
            factory.close();
            session.close();
        }
        return "success";
    }

    public String updateEmployeerById(String id, String name, String position){
        Session session = getConfig(Employee.class).getCurrentSession();

        try {
            session.beginTransaction();
            Employee employee = session.get(Employee.class, Integer.parseInt(id));

            employee.setEname(name);
            employee.setPosition(position);

            session.getTransaction().commit();
        } finally {
            factory.close();
            session.close();
        }

        return "success";
    }

    public String deleteEmployeer(String id){
        Session session = getConfig(Employee.class).getCurrentSession();

        try {
            session.beginTransaction();

            session.createQuery("DELETE from Employee where id = " + id ).executeUpdate();

            session.getTransaction().commit();

        }finally {
            factory.close();
            session.close();
        }
        return "success";
    }

}
