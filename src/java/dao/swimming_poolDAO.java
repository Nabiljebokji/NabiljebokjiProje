/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.swimming_pool;
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
 * @author Ahmed
 */
public class swimming_poolDAO {

    private DBConnection db;
    private Connection c;

    public List<swimming_pool> FindAll() {
        List<swimming_pool> poollist = new ArrayList();
        try {
            PreparedStatement pst = this.getC().prepareStatement("select * from swimming_pool");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                swimming_pool tmp = new swimming_pool(rs.getLong("id_pool"), rs.getInt("length"), rs.getInt("width"), rs.getInt("depth"));
                poollist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return poollist;

    }

//    public void insert(swimming_pool pool) {
//        try {
//            PreparedStatement pst =this.getC().prepareStatement("insert into swimming_pool(id_pool,length,width,depth) values(?,?,?,?)");
//            pst.setLong(1,pool.getId_pool());
//            pst.setInt(2,pool.getLength());
//            pst.setInt(3,pool.getWidth());
//            pst.setInt(4,pool.getDepth());
//            
//            pst.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//
//        }
//    }
    public void insert(swimming_pool pool) {
        try {
            Statement st = c.createStatement();
            st.executeUpdate("insert into swimming_pool (id_pool,length,width,depth)"
                    + " values (" + pool.getId_pool() + "," + pool.getLength()
                    + "," + pool.getWidth() + "," + pool.getDepth() + ")");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            PreparedStatement pst = this.getC().prepareStatement("insert into pool_workers"
                    + " (id_pool,id_workers) values(?,?) ");
            pst.setLong(1, pool.getId_pool());
            pst.setLong(2, pool.getId_pool());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void create(swimming_pool pool) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("insert into swimming_pool (id_pool,length,width,depth) values(?,?,?,?)");
            pst.setLong(1, pool.getId_pool());
            pst.setInt(2, pool.getLength());
            pst.setInt(3, pool.getWidth());
            pst.setInt(4, pool.getDepth());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         try {
            PreparedStatement pst = this.getC().prepareStatement("insert into pool_workers"
                    + " (id_pool,id_workers) values(?,?) ");
            pst.setLong(1, pool.getId_pool());
            pst.setLong(2, pool.getId_pool());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(swimming_pool pool) {
        try {
            Statement st = getC().createStatement();
            st.executeUpdate("delete from swimming_pool where id_pool=" + pool.getId_pool());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(swimming_pool pool) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("update swimming_pool set id_pool=?,length=?,width=?,depth=? where id_pool=?");
            pst.setLong(1, pool.getId_pool());
            pst.setInt(2, pool.getLength());
            pst.setInt(3, pool.getWidth());
            pst.setInt(4, pool.getDepth());
            pst.setLong(5, pool.getId_pool());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
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
}
