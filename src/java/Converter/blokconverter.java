/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import dao.blokDAO;
import entity.bloks;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author moj
 */
@FacesConverter(value="bloksConverter")
public class blokconverter implements Converter{
    
    private blokDAO blokdao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getBlokdao().find(Long.valueOf(value));
                }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        bloks b=(bloks) value;
        return b.getId_blok().toString();
    }

    public blokDAO getBlokdao() {
        if(this.blokdao==null){
            this.blokdao=new blokDAO();
        }
        return blokdao;
    }
    
}
