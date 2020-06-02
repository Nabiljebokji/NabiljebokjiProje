/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.managerDAO;
import entity.manager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author zak
 */
@Named
@SessionScoped
public class managercontroller implements Serializable {

    private List<manager> managerlist;
    private managerDAO managerdao;
    private manager manager;

    public void updateForm(manager man) {
        this.manager =man ;

    }

    public void delete() {
        this.getManagerdao().delete(this.manager);
        this.manager = new manager();
    }

    public void deleteConfirm(manager man) {
        this.manager = man;
    }

    public void clearForm() {
        this.manager= new manager();
    }

    public String update() {
        this.getManagerdao().update(this.manager);
        this.manager= new manager();
        return "manager?faces-redirect=true" ;
    }

    public String create() {
        this.getManagerdao().insert(this.manager);
        this.manager= new manager();
        return "index" ;

    }

    public managercontroller() {
        this.managerlist = new ArrayList();
        managerdao = new managerDAO();
    }

    public List<manager> getManagerlist() {
       
        this.managerlist = this.getManagerdao().getmanager() ;
        return managerlist;
    }

    public managerDAO getManagerdao() {
      
         if (this.managerdao == null) {
            this.managerdao = new managerDAO();
         }
        return managerdao;
    }

    public manager getManager() {
            if (this.manager == null) {
            this.manager = new manager();
            }
        return manager;
    }
}

