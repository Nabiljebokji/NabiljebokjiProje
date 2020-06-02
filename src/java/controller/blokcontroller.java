/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.blokDAO;
import dao.managerDAO;
import entity.bloks;
import entity.manager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author moj
 */
@Named
@SessionScoped
public class blokcontroller implements Serializable {
   private bloks blok;
    private List<bloks> bloklist;
    private blokDAO blokdao;
    private Long selectedmanager; 
  private Long selectedhome;
    private managerDAO managerdao;
    private List<manager> managerlist;

      
      @PostConstruct
    public void init (){
        blok = new bloks() ; 
    }
     
    public List<manager> getManagerlist() {
        this.managerlist=this.getManagerdao().getmanager();
        return managerlist;
    }

    public void setManagerlist(List<manager> managerlist) {
        this.managerlist = managerlist;
    }
    
    public Long getSelectedhome() {
        return selectedhome;
    }
  
    public Long getSelectedmanager() {
        return selectedmanager;
    }

    public managerDAO getManagerdao() {
        if(this.managerdao==null)
            this.managerdao=new managerDAO();
        return managerdao;
    }

    public void setSelectedmanager(Long selectedmanager) {
        this.selectedmanager = selectedmanager;
    }
    
    public void updateForm(bloks blok) {
        this.blok = blok;
        this.selectedmanager=this.blok.getManager().getId_manager();
    }

    public void delete() {
        this.getBlokdao().delete(this.blok);
        this.blok= new bloks();
    }

    public void deleteConfirm(bloks blok) {
        this.blok = blok;
    }

    public void clearForm() {
        this.blok = new bloks();
    }

    public void update() {
        this.getBlokdao().update(this.blok,selectedmanager);
        this.blok = new bloks();
    }

    public String create() {
        this.getBlokdao().create(this.blok,selectedmanager);
   return"blok";

    }


    public blokcontroller() {
        this.bloklist = new ArrayList();
        blokdao = new blokDAO();
    }

    public List<bloks> getBloklist() {
           this.bloklist=this.getBlokdao().findAll();
        return bloklist;
    }

    public void setBloklist(List<bloks> bloklist) {
        this.bloklist = bloklist;
    }

    public blokDAO getBlokdao() {
        return blokdao;
    }

    public void setBlokdao(blokDAO blokdao) {
        this.blokdao = blokdao;
    }

    public bloks getBlok() {
        return blok;
    }

    public void setBlok(bloks blok) {
        this.blok = blok;
    }


}
