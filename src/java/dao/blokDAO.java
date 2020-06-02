/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.bloks;
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
 * @author moj
 */
public class blokDAO {

    private DBConnection db;
    private Connection c;
    private managerDAO managerdao;

    public managerDAO getManagerdao() {
        if (this.managerdao == null) {
            this.managerdao = new managerDAO();
        }
        return managerdao;
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

    public List<bloks> findAll() {
        List<bloks> bloklist = new ArrayList();
        try {

            PreparedStatement pst = this.getC().prepareStatement("select * from bloks");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                bloks tmp = new bloks();
                tmp.setId_blok(rs.getLong("id_blok"));
                tmp.setManager(this.getManagerdao().find(rs.getInt("id_manager")));
                tmp.setBlok_name(rs.getString("blok_name"));
                tmp.setLevel_no(rs.getInt("level_no"));
                tmp.setHow_many_KM(rs.getInt("how_many_KM"));
                tmp.setBlok_type(rs.getString("blok_type"));
                tmp.setHow_many_home(rs.getInt("how_many_home"));
                bloklist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return bloklist;

    }

    /* public void insert(bloks blok) {
        try {
            Statement st = getC().createStatement();
            st.executeUpdate( "insert into bloks(blok_name) values('"+blok.getBlok_name()+"')");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }*/
    
    
     public void delete(bloks blok) {
        try {
            Statement st = getC().createStatement();
            st.executeUpdate("delete from bloks where id_blok="+blok.getId_blok());
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void update(bloks blok, long selectedmanager) {
        
         try {
              PreparedStatement pst =this.getC().prepareStatement("update bloks set id_blok=?, id_manager=? ,blok_name=?,level_no=?,how_many_KM=?,blok_type=?,how_many_home=? where id_blok=?");
              
              pst.setLong(1, blok.getId_blok());
              pst.setLong(2, selectedmanager);
              pst.setString(3, blok.getBlok_name());
              pst.setInt(4,blok.getLevel_no());
              pst.setInt(5, blok.getHow_many_KM());
              pst.setString(6,blok.getBlok_type());
              pst.setInt(7,blok.getHow_many_home());
              pst.setLong(8, blok.getId_blok());
              
              pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }
    
    
    
}
