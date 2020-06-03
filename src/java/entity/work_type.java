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
public class work_type {
    private Long id_work_type;
    private String work_type;

    public work_type() {
    }

    public work_type(Long id_work_type, String work_type) {
        this.id_work_type = id_work_type;
        this.work_type = work_type;
    }

    public Long getId_work_type() {
        return id_work_type;
    }

    public void setId_work_type(Long id_work_type) {
        this.id_work_type = id_work_type;
    }

    public String getWork_type() {
        return work_type;
    }

    public void setWork_type(String work_type) {
        this.work_type = work_type;
    }
    
    
}
