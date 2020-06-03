/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.user;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author nabilo
 */
@Named
@SessionScoped
public class loginController implements Serializable {

    private user user;

    public String login() {

        if (this.user.getUsername().equals("admin") && this.user.getPassword().equals("123")) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", this.user);
            return "/secret/secret?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Username or password is wrong"));
            return "/login";
        }
    }

    public user getUser() {
        if (this.user == null) {
            this.user = new user();
        }
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }

}
