/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.work_type;
import java.sql.Connection;
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
public class work_typeDAO {

    private DBConnection db;

    /**/
    private Connection c;

    public List<work_type> allfind() {
        List<work_type> worktypelist = new ArrayList();
        try {

            Statement st = getC().createStatement();
            ResultSet rs = st.executeQuery("select * from work_type");
            while (rs.next()) {
                work_type tmp = new work_type();

                tmp.setId_work_type(rs.getLong("id_work_type"));
                tmp.setWork_type(rs.getString("work_type"));

                worktypelist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return worktypelist;

    }

    public work_type find(long id) {
        work_type l = null;
        try {

            Statement st = getC().createStatement();
            ResultSet rs = st.executeQuery("select * from work_type where id_work_type=" + id);
            rs.next();
            l = new work_type();
            l.setId_work_type(rs.getLong("id_work_type"));
            l.setWork_type(rs.getString("work_type"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return l;
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
