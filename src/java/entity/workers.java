/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;



/**
 *
 * @author moj
 */
public class workers {

    private Long id_workers;
  
    private String name;
    private String last_name;
    private int age;
    private int phone;
    private int TC;
    private manager manager;
   private work_type work_type;

    public work_type getWork_type() {
        return work_type;
    }

    public void setWork_type(work_type work_type) {
        this.work_type = work_type;
    }

    
    public manager getManager() {
        return manager;
    }

    public void setManager(manager manager) {
        this.manager = manager;
    }

    public workers() {
    }

   

    public workers(Long id_workers, String name, String last_name, int age, int phone, int TC) {
        this.id_workers = id_workers;
        this.name = name;
        this.last_name = last_name;
        this.age = age;
        this.phone = phone;
        this.TC = TC;
    }

    public Long getId_workers() {
        return id_workers;
    }

    public void setId_workers(Long id_workers) {
        this.id_workers = id_workers;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getTC() {
        return TC;
    }

    public void setTC(int TC) {
        this.TC = TC;
    }

}
