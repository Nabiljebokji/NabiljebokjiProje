/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.*;
import entity.supervisor;
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
 * @author Nour
 */
public class superDAO {
      private DBConnection db;
    private Connection c;
    private managerDAO managerdao;
    
    
    public List<supervisor> findAll(int page,int pagesize){
        List<supervisor> superlist = new ArrayList();
         int start=(page-1)*pagesize;
        try{
            
              PreparedStatement pst =this.getC().prepareStatement("select * from supervisor order by id_supervisor asc limit "+start+","+pagesize);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                supervisor tmp = new supervisor();
                tmp.setId_supervisor(rs.getLong("id_supervisor"));
                tmp.setName(rs.getString("name"));
                tmp.setLast_name(rs.getString("last_name"));
          tmp.setManager(this.getManagerdao().find(rs.getInt("id_manager")));
                superlist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return superlist;

    }
    
     public int count() {
      int count=0;

        try {
              PreparedStatement pst =this.getC().prepareStatement("select count(id_supervisor) as supervisor_count from supervisor");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count=rs.getInt("supervisor_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return count;

    }

   /* public void insert(bloks blok) {
        try {
            Statement st = getC().createStatement();
            st.executeUpdate( "insert into bloks(blok_name) values('"+blok.getBlok_name()+"')");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }*/

    public void delete(supervisor supervisor) {
        try {
            Statement st = getC().createStatement();
            st.executeUpdate("delete from supervisor where id_supervisor="+supervisor.getId_supervisor());
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void update(supervisor supervisor) {
        
         try {
              PreparedStatement pst =this.getC().prepareStatement("update supervisor set id_supervisor=? ,name=?,last_name=?,id_manager=? where id_supervisor=?");
              
              pst.setLong(1, supervisor.getId_supervisor());
              pst.setString(2, supervisor.getName());
              pst.setString(3,supervisor.getLast_name());
            pst.setLong(4, supervisor.getManager().getId_manager());
               pst.setLong(5, supervisor.getId_supervisor());
              pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public managerDAO getManagerdao() {
               if (this.managerdao == null) {
            this.managerdao = new managerDAO();
        }
        return managerdao;
    }
    
        public DBConnection getDb() {
        if(this.db==null)
            this.db=new DBConnection();
        return db;
    }

    public Connection getC() {
        if(this.c==null)
            this.c=this.getDb().connect();
        return c;
    }

    public void create(supervisor supervisor) {
        try {
              PreparedStatement pst =this.getC().prepareStatement("insert into supervisor (id_supervisor, name ,last_name,id_manager ) values(?,?,?,?)");
              
              pst.setLong(1, supervisor.getId_supervisor());
              pst.setString(2, supervisor.getName());
              pst.setString(3,supervisor.getLast_name());
               pst.setLong(4, supervisor.getManager().getId_manager());
              pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

   public supervisor find(long id) {
             supervisor h = null;
        try {
              PreparedStatement pst =this.getC().prepareStatement("select * from supervisor where id_supervisor=?");
              pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            h = new supervisor();
            h.setId_supervisor(rs.getLong("id_supervisor"));
            h.setName(rs.getString("name"));
             h.setLast_name(rs.getString("last_name"));
            // l.setLast_update(rs.getDate("last_update"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return h;
    }
    public List<supervisor> Findplayvisor(long id_play) {
       
       List<supervisor> playvisor = new ArrayList<>();

        try {
            Statement st = this.getC().createStatement();
            ResultSet rs = st.executeQuery("select * from play_visor where id_play=" + id_play);
            // n tane sonuc donme ihtmali oldugu icin 

            while (rs.next()) {
                playvisor.add(this.find(rs.getLong("id_supervisor")));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return playvisor;

    }

}
