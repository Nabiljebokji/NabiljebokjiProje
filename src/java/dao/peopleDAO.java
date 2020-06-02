/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import entity.people;
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
 * @author Ahmed Alo
 */
public class peopleDAO{

    private DBConnection db;
    private Connection c;
    private managerDAO managerdao;
    private homeDAO homedao;
    
    public List<people> findALL() {
        List<people> plist = new ArrayList();
        try{
             PreparedStatement pst =this.getC().prepareStatement("select * from people");
            ResultSet rs =pst.executeQuery();
            
            while (rs.next()) {
                people tmp = new people();
                tmp.setId_people(rs.getLong("id_people"));
                /// هلا تمام هاد الميثود كان ناقص 
                tmp.setName(rs.getString("name"));
                tmp.setLast_name(rs.getString("last_name"));
                tmp.setTC(rs.getInt("TC"));
                tmp.setAge(rs.getInt("age"));
                tmp.setPeople_num(rs.getInt("people_num"));
                 tmp.setHome(this.getHomedao().find(rs.getInt("id_home")));
                 tmp.setPayments(rs.getInt("payments"));
                 tmp.setRent_payments(rs.getInt("rent_payments"));
                 tmp.setManager(this.getManagerdao().find(rs.getInt("id_manager")));
                plist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return plist;

    }

   /* public void insert(bloks blok) {
        try {
            Statement st = getC().createStatement();
            st.executeUpdate( "insert into bloks(blok_name) values('"+blok.getBlok_name()+"')");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }*/

    public void delete(people people) {
        try {
            Statement st = getC().createStatement();
            st.executeUpdate("delete from people where id_people="+people.getId_people());
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void update(people people) {
           try {
            PreparedStatement pst =this.getC().prepareStatement("update people set id_people=?,name=? ,last_name=?,TC=?,age=?,people_num=?,id_home=?,payments=?,rent_payments=?,id_manager=? where id_people=?");
             pst.setLong(1,people.getId_people());
             pst.setString(2,people.getName());
             pst.setString(3,people.getLast_name());
             pst.setInt(4,people.getTC());
             pst.setInt(5,people.getAge());
             pst.setInt(6,people.getPeople_num());
             pst.setLong(7,people.getHome().getId_home());
             pst.setInt(8,people.getPayments());
             pst.setInt(9,people.getRent_payments());
             pst.setLong(10,people.getManager().getId_manager());
             pst.setLong(11,people.getId_people());
             pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        
//        try {
//            Statement st = getC().createStatement();
//            st.executeUpdate("update people set name='"+people.getName()+"'where id_people= "+people.getId_people());
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
    }

    public managerDAO getManagerdao() {
               if (this.managerdao == null) {
            this.managerdao = new managerDAO();
        }
        return managerdao;
    }
 public homeDAO getHomedao() {
          if (this.homedao == null) {
            this.homedao = new homeDAO();
          }
      return homedao;}
    
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

    public void create(people people) {
        try {
            PreparedStatement pst =this.getC().prepareStatement("insert into people(id_people,name ,last_name,TC,age,people_num,id_home,payments,rent_payments,id_manager ) values(?,?,?,?,?,?,?,?,?,?)");
             pst.setLong(1,people.getId_people());
             pst.setString(2,people.getName());
             pst.setString(3,people.getLast_name());
             pst.setInt(4,people.getTC());
             pst.setInt(5,people.getAge());
             pst.setInt(6,people.getPeople_num());
             pst.setLong(7,people.getHome().getId_home());
             pst.setInt(8,people.getPayments());
             pst.setInt(9,people.getRent_payments());
             pst.setLong(10,people.getManager().getId_manager());
             
             pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }
}