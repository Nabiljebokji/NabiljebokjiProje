/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.workers;
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
public class workerDAO {

    private DBConnection db;
    private Connection c;
    private managerDAO managerdao;
    private work_typeDAO worktypedao;

    public List<workers> findAll(int page, int pagesize) {
        List<workers> workerlist = new ArrayList();
        int start = (page - 1) * pagesize;
        try {
            PreparedStatement pst = this.getC().prepareStatement("select * from workers order by id_workers asc limit " + start + "," + pagesize);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                workers tmp = new workers();
                tmp.setId_workers(rs.getLong("id_workers"));
                tmp.setManager(this.getManagerdao().find(rs.getInt("id_manager")));
                tmp.setName(rs.getString("name"));
                tmp.setLast_name(rs.getString("last_name"));
                tmp.setAge(rs.getInt("age"));
                tmp.setPhone(rs.getInt("phone"));
                tmp.setTC(rs.getInt("TC"));
                tmp.setWork_type(this.getWorktypedao().find(rs.getLong("id_work_type")));
                workerlist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return workerlist;

    }

    public int count() {
        int count = 0;

        try {
            PreparedStatement pst = this.getC().prepareStatement("select count(id_workers) as workers_count from workers");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("workers_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return count;

    }

    public managerDAO getManagerdao() {
        if (this.managerdao == null) {
            this.managerdao = new managerDAO();
        }
        return managerdao;
    }

    public work_typeDAO getWorktypedao() {
        if (this.worktypedao == null) {
            this.worktypedao = new work_typeDAO();
        }
        return worktypedao;
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

    public void delete(workers wor) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("delete from workers where id_workers=?");
            pst.setLong(1, wor.getId_workers());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(workers wor, long selectedmanager, long selectedworktype) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("update workers set id_workers=? , id_manager=?,name=?,last_name=?,age=?,phone=?,TC=?,id_work_type=? where id_workers=? ");
            pst.setLong(1, wor.getId_workers());
            pst.setLong(2, selectedmanager);
            pst.setString(3, wor.getName());
            pst.setString(4, wor.getLast_name());
            pst.setInt(5, wor.getAge());
            pst.setInt(6, wor.getPhone());
            pst.setInt(7, wor.getTC());
            pst.setLong(8, selectedworktype);
            pst.setLong(9, wor.getId_workers());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
