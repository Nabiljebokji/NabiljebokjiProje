/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.blokDAO;
import dao.homeDAO;
import entity.bloks;
import entity.home;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author zak
 */
@Named
@SessionScoped
public class homecontroller implements Serializable {
    private home home;
    private List<home> homelist;
    private  homeDAO homedao;
    private blokDAO blokdao;
    private List<bloks> bloklist;
    
    
    @PostConstruct
    public void init (){
        home = new home() ; 
    }
    public home getHome() {
        return home;
    }
     
 public void updateForm(home h) {
        this.home =h;
        
}
 

    public void delete() {
        this.getHomedao().delete(this.home);
        this.home = new home();
       
    }

//    public void deleteConfirm() {
//        this.worker = wor;
//    }

    public void clearForm() {
        this.home= new home();
    }

    public void update() {
        this.getHomedao().update(this.home);
        this.clearForm();
    }

    public void create() {
        this.getHomedao().create(this.home);
      this.clearForm();

    }

    public void setHome(home home) {
            if(this.home==null)
            this.home=new home();
        this.home = home;
    }

    public List<home> getHomelist() {
         this.homelist=this.getHomedao().findAll();
        return homelist;
    }

    public void setHomelist(List<home> homelist) {
        this.homelist = homelist;
    }

    public List<bloks> getBloklist() {
        this.bloklist=this.getBlokdao().findAll();
        return bloklist;
    }

    public void setBloklist(List<bloks> bloklist) {
        this.bloklist = bloklist;
    }

    public homeDAO getHomedao() {
        if(this.homedao==null)
            this.homedao=new homeDAO();
        return homedao;
    }

    public void setHomedao(homeDAO homedao) {
        this.homedao = homedao;
    }
    public blokDAO getBlokdao() {
        if(this.blokdao==null)
            this.blokdao=new blokDAO();
        return blokdao;
    }


}

