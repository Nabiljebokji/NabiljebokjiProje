/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.swimming_poolDAO;
import entity.swimming_pool;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Ahmed
 */
@Named
@SessionScoped
public class poolcontroller implements Serializable {

    private List<swimming_pool> poollist;
    private  swimming_poolDAO pooldao;
    private swimming_pool  pool;

    public void updateForm(swimming_pool pool) {
        this.pool = pool;

    }

    public void delete() {
        this.getPooldao().delete(this.pool);
        this.pool = new swimming_pool();

    }

    public void deleteConfirm(swimming_pool pool) {
         this.pool = pool;

    }

    public void clearForm() {
       this.pool = new swimming_pool();

    }

    public void update() {
        this.getPooldao().update(this.pool);
        this.pool = new swimming_pool();

    }

    public void create() {
        this.getPooldao().create(this.pool);
        this.pool = new swimming_pool();
    }

    public poolcontroller() {
        this.poollist = new ArrayList();
        pooldao = new swimming_poolDAO();
    }

    public List<swimming_pool> getPoollist() {
        this.poollist = this.getPooldao().FindAll();
        return poollist;
    }

    public void setPoollist(List<swimming_pool> poollist) {
        this.poollist = poollist;
    }

    public swimming_poolDAO getPooldao() {
        if(this.pooldao==null)
            this.pooldao=new swimming_poolDAO();
        return pooldao;
    }

    public void setPooldao(swimming_poolDAO pooldao) {
        this.pooldao = pooldao;
    }

    public swimming_pool getPool() {
        if(this.pool==null)
            this.pool=new swimming_pool();
        return pool;
    }

    public void setPool(swimming_pool pool) {
        this.pool = pool;
    }


}