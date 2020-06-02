/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import dao.managerDAO;
import entity.manager;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author zak
 */
@FacesConverter(value="managerConverter")
public class managerconverter implements Converter{
    private managerDAO managerdao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
         return this.getManagerdao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       manager m=(manager) value;
        return m.getId_manager().toString();
    }

    public managerDAO getManagerdao() {
        if(this.managerdao==null){
            this.managerdao=new managerDAO();
        }
        return managerdao;
    }
    
}
