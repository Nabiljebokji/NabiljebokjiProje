/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author zak
 */
public class home {
    private Long id_home;
    private int floor_num;
    private int door_num;
    private int site_payments;
   private bloks blok;
   
    public home() {
    }

    public home(Long id_home, int floor_num, int door_num, int site_payments) {
        this.id_home = id_home;
        this.floor_num = floor_num;
        this.door_num = door_num;
        this.site_payments = site_payments;
    }

    public Long getId_home() {
         return id_home;
    }

    public void setId_home(Long id_home) {
        this.id_home = id_home;
    }

    public int getFloor_num() {
        return floor_num;
    }

    public void setFloor_num(int floor_num) {
        this.floor_num = floor_num;
    }

    public int getDoor_num() {
        return door_num;
    }

    public void setDoor_num(int door_num) {
        this.door_num = door_num;
    }

    public int getSite_payments() {
        return site_payments;
    }

    public void setSite_payments(int site_payments) {
        this.site_payments = site_payments;
    }
    public bloks getBlok() {
        return blok;
    }

    public void setBlok(bloks blok) {
        this.blok = blok;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id_home);
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
        final home other = (home) obj;
        if (!Objects.equals(this.id_home, other.id_home)) {
            return false;
        }
        return true;
    }
   
}
