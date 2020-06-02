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
public class bloks {
    
    private Long id_blok;
    private manager manager;
     private String blok_name;
      private int level_no;
     private int how_many_KM;
      private String blok_type;
       private int how_many_home;
   

    public manager getManager() {
        return manager;
    }

    public void setManager(manager manager) {
        this.manager = manager;
    }


    public bloks() {
    }

    public bloks(Long id_blok, String blok_name, int level_no, int how_many_KM, String blok_type, int how_many_home) {
        this.id_blok = id_blok;
        this.blok_name = blok_name;
        this.level_no = level_no;
        this.how_many_KM = how_many_KM;
        this.blok_type = blok_type;
        this.how_many_home = how_many_home;

    }

    public Long getId_blok() {
        return id_blok;
    }

    public void setId_blok(Long id_blok) {
        this.id_blok = id_blok;
    }


    public String getBlok_name() {
        return blok_name;
    }

    public void setBlok_name(String blok_name) {
        this.blok_name = blok_name;
    }

    public int getLevel_no() {
        return level_no;
    }

    public void setLevel_no(int level_no) {
        this.level_no = level_no;
    }

    public int getHow_many_KM() {
        return how_many_KM;
    }

    public void setHow_many_KM(int how_many_KM) {
        this.how_many_KM = how_many_KM;
    }

    public String getBlok_type() {
        return blok_type;
    }

    public void setBlok_type(String blok_type) {
        this.blok_type = blok_type;
    }

    public int getHow_many_home() {
        return how_many_home;
    }

    public void setHow_many_home(int how_many_home) {
        this.how_many_home = how_many_home;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.id_blok);
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
        final bloks other = (bloks) obj;
        if (!Objects.equals(this.id_blok, other.id_blok)) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public String toString() {
        return "bloks{" + "id_blok=" + id_blok + ", manager=" + manager + ", blok_name=" + blok_name + ", level_no=" + level_no + ", how_many_KM=" + how_many_KM + ", blok_type=" + blok_type + ", how_many_home=" + how_many_home +'}';
    }

    
}