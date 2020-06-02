/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;



import dao.homeDAO;
import dao.managerDAO;
import dao.peopleDAO;
import entity.home;
import entity.manager;
import entity.people;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author ahmed
 */
@Named
@SessionScoped
public class peoplecontroller implements Serializable {
    private people people;
    private List<people> plist;
    private  peopleDAO peopledao;
    private managerDAO managerdao;
    private List<manager> managerlist;
     private homeDAO homedao;
     private List<home> homelist;
    
     @PostConstruct
    public void init (){
        people = new people();  
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

    public void setManagerdao(managerDAO managerdao) {
        this.managerdao = managerdao;
    }

    public homeDAO getHomedao() {
         if(this.homedao==null)
            this.homedao=new homeDAO();
        return homedao;
    }

    public void setHomedao(homeDAO homedao) {
        this.homedao = homedao;
    }

    public List<home> getHomelist() {
        this.homelist=this.getHomedao().findAll();
        return homelist;
    }

    public void setHomelist(List<home> homelist) {
        this.homelist = homelist;
    }

     
 public void updateForm(people people) {
        this.people =people;
    }
      
      public void delete() {
        this.peopledao.delete(this.people);
        this.people=new people();
    }
        public void deleteConfirm(people people) {
        this.people= people;
    }

 public void clearForm() {
        this.people= new people();
    }
       
    public void update() {
        this.getPeopledao().update(this.people);
        this.clearForm();
    }

    public void create() {
        this.getPeopledao().create(this.people);
      this.clearForm();

    }
     public peoplecontroller() {
        this.plist = new ArrayList();
       peopledao = new peopleDAO();
    }

    public List<people> getPlist() {
        this.plist=this.getPeopledao().findALL();
        return plist;
    }

    public void setPlist(List<people> plist) {
        this.plist = plist;
    }
     
    public people getPeople() {
        return people;
    }

    public void setPeople(people people) {
        this.people = people;
    }


    public peopleDAO getPeopledao() {
        return peopledao;
    }

    public void setPeopledao(peopleDAO peopledao) {
        this.peopledao = peopledao;
    }



}

