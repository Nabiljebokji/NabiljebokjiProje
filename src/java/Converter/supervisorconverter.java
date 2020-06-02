/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import dao.superDAO;
import entity.supervisor;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Nour
 */
@FacesConverter(value="supervisorConverter")
public class supervisorconverter implements Converter{
      private superDAO superdao;
      
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       return this.getSuperdao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        supervisor s=(supervisor) value;
        return s.getId_supervisor().toString();
    }

    public superDAO getSuperdao() {
         if(this.superdao==null){
            this.superdao=new superDAO();
        }
        return superdao;
    }
    
}
