/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author moj
 */
public class manager {
    private Long id_manager;
    private String name;
    private String last_name;
    private int TC;
    private int age;
    private int phone;
    private String Email;

    public manager() {
    }

    public manager(Long id_manager, String name, String last_name, int TC, int age, int phone, String Email) {
        this.id_manager = id_manager;
        this.name = name;
        this.last_name = last_name;
        this.TC = TC;
        this.age = age;
        this.phone = phone;
        this.Email = Email;
    }

    public Long getId_manager() {
        return id_manager;
    }

    public void setId_manager(Long id_manager) {
        this.id_manager = id_manager;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.id_manager);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final manager other = (manager) obj;
        if (!Objects.equals(this.id_manager, other.id_manager)) {
            return false;
        }
        return true;
    }
    
}
