package dao;

import entity.manager;
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
public class managerDAO {

    private DBConnection db;
    private Connection c;

    
    public List<manager> getmanager() {
        List<manager> managerlist = new ArrayList();
        try {
             PreparedStatement pst =this.getC().prepareStatement("select * from manager");
            ResultSet rs =pst.executeQuery();
            while (rs.next()) {
                manager tmp = new manager(rs.getLong("id_manager"), rs.getString("name"), rs.getString("last_name"), rs.getInt("tc"), rs.getInt("age"), rs.getInt("phone"), rs.getString("email"));
                managerlist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return managerlist;

    }

    public void insert(manager manager) {
        try {
              PreparedStatement pst =this.getC().prepareStatement("insert into manager(id_manager , name,last_name,tc,age,phone,email) values(?,?,?,?,?,?,?)");
              pst.setLong(1,manager.getId_manager());
              pst.setString(2,manager.getName());
              pst.setString(3,manager.getLast_name());
              pst.setInt(4,manager.getTC());
              pst.setInt(5,manager.getAge());
              pst.setInt(6,manager.getPhone());
              pst.setString(7,manager.getEmail());
              pst.executeUpdate();
              
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void delete(manager manager) {
        try {
            Statement st = getC().createStatement();
            st.executeUpdate("delete from manager where id_manager=" + manager.getId_manager());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(manager manager) {
        
             try {
              PreparedStatement pst =this.getC().prepareStatement("update manager set id_manager=? , name=?,last_name=?,tc=?,age=?,phone=?,email=? where id_manager=?");
              pst.setLong(1,manager.getId_manager());
              pst.setString(2,manager.getName());
              pst.setString(3,manager.getLast_name());
              pst.setInt(4,manager.getTC());
              pst.setInt(5,manager.getAge());
              pst.setInt(6,manager.getPhone());
              pst.setString(7,manager.getEmail());
               pst.setLong(8,manager.getId_manager());
               
              pst.executeUpdate();
              
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
//            Statement st = getC().createStatement();
//            st.executeUpdate("update manager set name='" + manager.getName() + "'where id_manager= " + manager.getId_manager());
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

    public manager find(long id) {
        manager l = null;
        try {

            Statement st = getC().createStatement();
            ResultSet rs = st.executeQuery("select * from manager where id_manager=" + id);
            rs.next();
            l = new manager();
            l.setId_manager(rs.getLong("id_manager"));
            l.setName(rs.getString("name"));
            // l.setLast_update(rs.getDate("last_update"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return l;
    }

}
