/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.playgroundDAO;
import entity.playground;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author moj
 */
@Named
@SessionScoped
public class playcontroller extends BaseBean implements Serializable {

    @Override
    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getPlaydao().count(this.getSearchTerm()) / (double) pageSize);
        return pageCount;
    }

    private List<playground> playlist;
    private playgroundDAO playdao;
    private playground play;

    @Inject
    private supercontroller superController;

    public void updateForm(playground play) {
        this.play = play;
    }

    public void delete() {
        this.getPlaydao().delete(this.play);
        this.play = new playground();

    }

    public void deleteConfirm(playground play) {
        this.play = play;

    }

    public void clearForm() {
        this.play = new playground();

    }

    public void update() {
        this.getPlaydao().update(this.play);
        this.clearForm();

    }

    public void create() {
        this.getPlaydao().insert(this.play);
        this.clearForm();
    }

    /* public playcontroller() {
        this.playlist = new ArrayList();
        playdao = new playgroundDAO();
    }*/
    public List<playground> getPlaylist() {
        this.playlist = this.getPlaydao().FindAll(page, pageSize, this.getSearchTerm());
        return playlist;
    }

    public void setPlaylist(List<playground> playlist) {
        this.playlist = playlist;
    }

    public playgroundDAO getPlaydao() {
        if (this.playdao == null) {
            this.playdao = new playgroundDAO();
        }
        return playdao;
    }

    public void setPlaydao(playgroundDAO playdao) {
        this.playdao = playdao;
    }

    public playground getPlay() {
        if (this.play == null) {
            this.play = new playground();
        }
        return play;
    }

    public void setPlay(playground play) {
        this.play = play;
    }

    public supercontroller getSuperController() {
        return superController;
    }

    public void setSuperController(supercontroller superController) {
        this.superController = superController;
    }

}
