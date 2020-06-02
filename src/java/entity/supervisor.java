/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author Nour
 */
public class supervisor {
    private Long id_supervisor;
    private  String name;
    private String last_name;

    public manager getManager() {
        return manager;
    }

    public void setManager(manager manager) {
        this.manager = manager;
    }
   private manager manager;

     public supervisor() {
    }
     
     public supervisor(Long id_supervisor, String name, String last_name) {
        this.id_supervisor = id_supervisor;
        this.name = name;
        this.last_name = last_name;
    }

    public Long getId_supervisor() {
        return id_supervisor;
    }

    public void setId_supervisor(Long id_supervisor) {
        this.id_supervisor = id_supervisor;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id_supervisor);
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
        final supervisor other = (supervisor) obj;
        if (!Objects.equals(this.id_supervisor, other.id_supervisor)) {
            return false;
        }
        return true;
    }

    
}
