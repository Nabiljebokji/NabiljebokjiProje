/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.home;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author zak
 */
public class  homeDAO {

    private DBConnection db;
    private Connection c;
    private blokDAO blokdao;
   

    public List<home> findAll() {
        List<home> homelist = new ArrayList();

        try {
             PreparedStatement pst =this.getC().prepareStatement("select * from home");
            ResultSet rs =pst.executeQuery();
            while (rs.next()) {
                home tmp = new home();
                tmp.setId_home(rs.getLong("id_home"));
                /// هلا تمام هاد الميثود كان ناقص 
                tmp.setFloor_num(rs.getInt("floor_num"));
                tmp.setDoor_num(rs.getInt("door_num"));
                tmp.setSite_payments(rs.getInt("site_payments"));
                 tmp.setBlok(this.getBlokdao().find(rs.getInt("id_blok")));

                homelist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return homelist;

    }

    public blokDAO getBlokdao() {
        if (this.blokdao == null) {
            this.blokdao = new blokDAO();
        }
        return blokdao;
    }

   /* public void insert(workers worker) {
        try {
            Statement st = getC().createStatement();
            //st.executeUpdate("insert into workers(name) values('" + worker.getName() + "')");
            st.executeUpdate("insert into workers (id_workers , id_manager ,name,last_name,age,phone,TC ) values('" + worker.getId_workers() + "','" + worker.getManager().getId_manager() + "', '" + worker.getName() + "' , '" + worker.getLast_name() + "' , '" + worker.getAge() + "' ,'" + worker.getPhone() + "' , '" + worker.getTC() + "' ) ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }*/

    public void delete(home h) {
        try {
            PreparedStatement pst =this.getC().prepareStatement("delete from home where id_home=?");
           pst.setLong(1,h.getId_home());
           pst.executeUpdate();                
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(home h) {
           try {
             PreparedStatement pst =this.getC().prepareStatement("update home set id_home=? ,floor_num =?,door_num=?,site_payments=?,id_blok=? where id_home=?");
             pst.setLong(1,h.getId_home());
             pst.setInt(2,h.getFloor_num());
              pst.setInt(3,h.getDoor_num());
             pst.setInt(4,h.getSite_payments());
             pst.setLong(5,h.getBlok().getId_blok());
             pst.setLong(6,h.getId_home());
             pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
            
//            Statement st = getC().createStatement();
//            st.executeUpdate("update home set door_num='" + h.getDoor_num() + "'where id_home= " +h.getId_home());
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
    }

    public DBConnection getDb() {
        if (this.db == null) {
            this.db = new DBConnection();
        }
        return db;
    }

    public Connection getC() {
        if (this.c == null) {
            this.c = this.getDb().connect();
        }
        return c;
    }
       public home find(long id) {
        home l = null;
        try {

            Statement st = getC().createStatement();
            ResultSet rs = st.executeQuery("select * from home where id_home=" + id);
            rs.next();
            l = new home();
            l.setId_home(rs.getLong("id_home"));
            l.setFloor_num(rs.getInt("floor_num"));
            l.setDoor_num(rs.getInt("door_num"));
            l.setSite_payments(rs.getInt("site_payments"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return l;
    }
    
    public void create(home h) {
        try {
             PreparedStatement pst =this.getC().prepareStatement("insert into home (id_home ,floor_num ,door_num,site_payments,id_blok ) values(?,?,?,?,?)");
             pst.setLong(1,h.getId_home());
             pst.setInt(2,h.getFloor_num());
              pst.setInt(3,h.getDoor_num());
             pst.setInt(4,h.getSite_payments());
             pst.setLong(5, h.getBlok().getId_blok());
             
             pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }
}