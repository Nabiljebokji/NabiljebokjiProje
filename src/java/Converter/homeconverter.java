/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import dao.homeDAO;
import entity.home;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author zak
 */
@FacesConverter(value="homeConverter")
public class homeconverter implements Converter{
   private homeDAO homedao;
   
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       return this.getHomedao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
     home h=(home) value; 
     return h.getId_home().toString();
    }

    public homeDAO getHomedao() {
        if(this.homedao==null){
            this.homedao=new homeDAO();
        }
        return homedao;
    }

   
   
}
