/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


/**
 *
 * @author moj
 */
public class people {
     private Long id_people;
     private String name;
     private String last_name;
   private int TC;
     private int age;
     private int people_num;
     private int payments;
     private int rent_payments;
     private home home;
     private manager manager;

    public home getHome() {
        return home;
    }

    public void setHome(home home) {
        this.home = home;
    }

    public manager getManager() {
        return manager;
    }

    public void setManager(manager manager) {
        this.manager = manager;
    }
    public people() {
    }

    public people(Long id_people, String name, String last_name, int TC, int age, int people_num, int payments, int rent_payments) {
        this.id_people = id_people;
        this.name = name;
        this.last_name = last_name;
        this.TC = TC;
        this.age = age;
        this.people_num = people_num;
        this.payments = payments;
        this.rent_payments = rent_payments;
    }

    public Long getId_people() {
        return id_people;
    }

    public void setId_people(Long id_people) {
        this.id_people = id_people;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getTC() {
        return TC;
    }

    public void setTC(int TC) {
        this.TC = TC;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPeople_num() {
        return people_num;
    }

    public void setPeople_num(int people_num) {
        this.people_num = people_num;
    }

    public int getPayments() {
        return payments;
    }

    public void setPayments(int payments) {
        this.payments = payments;
    }

    public int getRent_payments() {
        return rent_payments;
    }

    public void setRent_payments(int rent_payments) {
        this.rent_payments = rent_payments;
    }

    @Override
    public String toString() {
        return "people{" + "id_people=" + id_people + ", name=" + name + ", last_name=" + last_name + ", TC=" + TC + ", age=" + age + ", people_num=" + people_num + ", payments=" + payments + ", rent_payments=" + rent_payments + ", home=" + home + ", manager=" + manager + '}';
    }
    
   
}
