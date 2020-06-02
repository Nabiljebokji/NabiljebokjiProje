/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.managerDAO;
import dao.superDAO;
import entity.manager;
import entity.supervisor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Nour
 */
@Named
@SessionScoped
public class supercontroller implements Serializable {
   private supervisor supervisor;
    private List<supervisor> superlist;
    private superDAO superdao;
    private managerDAO managerdao;
    private List<manager> managerlist;

      
     private int page=1;
    private int pagesize=10;
    private int  pagecount;

    
    public void next(){
        if(this.page==this.getPagecount())
            this.page=1;
        else
        this.page++;
    }
    public void previous(){
        if(this.page==1)
            this.page=this.getPagecount();
        else
        this.page--;
    }
            public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getPagecount() {
        
        this.pagecount= (int)Math.ceil(this.getSuperdao().count()/(double)pagesize);
        return pagecount;
    }
      @PostConstruct
    public void init (){
        supervisor = new supervisor() ; 
    }
     
    public List<manager> getManagerlist() {
        this.managerlist=this.getManagerdao().getmanager();
        return managerlist;
    }

    public void setManagerlist(List<manager> managerlist) {
        this.managerlist = managerlist;
    }
    
   

    public managerDAO getManagerdao() {
        if(this.managerdao==null)
            this.managerdao=new managerDAO();
        return managerdao;
    }
    public void delete() {
        this.getSuperdao().delete(this.supervisor);
        this.supervisor= new supervisor();
    }
    public void updateForm(supervisor s) {
        this.supervisor =s;
        
}

    public void deleteConfirm(supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public void clearForm() {
        this.supervisor = new supervisor();
    }

    public void update() {
        this.getSuperdao().update(this.supervisor);
        this.clearForm();
    }

    public void create() {
        this.getSuperdao().create(this.supervisor);
       this.clearForm();

    }


    public supercontroller() {
        this.superlist = new ArrayList();
        superdao = new superDAO();
    }

    public supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public List<supervisor> getSuperlist() {
        this.superlist=this.getSuperdao().findAll(page, pagesize);
        return superlist;
    }

    public void setSuperlist(List<supervisor> superlist) {
        this.superlist = superlist;
    }

    public superDAO getSuperdao() {
        return superdao;
    }

    public void setSuperdao(superDAO superdao) {
        this.superdao = superdao;
    }

  


}

