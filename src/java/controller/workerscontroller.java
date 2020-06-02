/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.managerDAO;
import dao.work_typeDAO;

import dao.workerDAO;
import entity.manager;
import entity.work_type;

import entity.workers;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author moj
 */
@Named
@SessionScoped
public class workerscontroller implements Serializable {
    private workers worker;
    private List<workers> worklist;
    private  workerDAO workerdao;
    private Long selectedmanager;
    private managerDAO managerdao;
    private List<manager> managerlist;
    private Long selectedworktype;
    private work_typeDAO worktypedao;
    private List<work_type> worktypelist;
    
   
     
public void updateForm(workers wor) {
        this.worker =wor;
         this.selectedmanager=this.worker.getManager().getId_manager();
       this.selectedworktype=this.worker.getWork_type().getId_work_type();

    }
 

    public void delete() {
        this.getWorkerdao().delete(this.worker);
        this.worker = new workers();
    }

    public void clearForm() {
        this.worker= new workers();
    }

    public void update() {
        this.getWorkerdao().update(this.worker,selectedmanager,selectedworktype);
        this.worker= new workers();
    }

    public String create() {
        this.getWorkerdao().create(this.worker,selectedmanager,selectedworktype);
   return"worker";

    }

    public void setWorker(workers worker) {
            if(this.worker==null)
            this.worker=new workers();
        this.worker = worker;
    }

    public List<workers> getWorklist() {
         this.worklist=this.getWorkerdao().findAll(page,pagesize);
        return worklist;
    }

    public void setWorklist(List<workers> worklist) {
        this.worklist = worklist;
    }

    public List<manager> getManagerlist() {
        this.managerlist=this.getManagerdao().getmanager();
        return managerlist;
    }

    public void setManagerlist(List<manager> managerlist) {
        this.managerlist = managerlist;
    }

    public workerDAO getWorkerdao() {
        if(this.workerdao==null)
            this.workerdao=new workerDAO();
        return workerdao;
    }

    public void setWorkerdao(workerDAO workerdao) {
        this.workerdao = workerdao;
    }

    public Long getSelectedmanager() {
        return selectedmanager;
    }

    public void setSelectedmanager(Long selectedmanager) {
        this.selectedmanager = selectedmanager;
    }

    public managerDAO getManagerdao() {
        if(this.managerdao==null)
            this.managerdao=new managerDAO();
        return managerdao;
    }

    public Long getSelectedworktype() {
        return selectedworktype;
    }

    public void setSelectedworktype(Long selectedworktype) {
        this.selectedworktype = selectedworktype;
    }

    public work_typeDAO getWorktypedao() {
         if(this.worktypedao==null)
            this.worktypedao=new work_typeDAO();
        return worktypedao;
    }

    public void setWorktypedao(work_typeDAO worktypedao) {
        this.worktypedao = worktypedao;
    }

    public List<work_type> getWorktypelist() {
         this.worktypelist=this.getWorktypedao().allfind();
        return worktypelist;
    }

    public void setWorktypelist(List<work_type> worktypelist) {
        this.worktypelist = worktypelist;
    }


}

