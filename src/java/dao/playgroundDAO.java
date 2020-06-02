
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.playground;
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
public class playgroundDAO {
     private DBConnection db;
    private Connection c;
    private superDAO superdao;
    
    public List<playground> FindAll() {
        List<playground> playlist = new ArrayList();
        try {
            PreparedStatement pst =this.getC().prepareStatement("select * from play_ground");
            ResultSet rs =pst.executeQuery();
            while (rs.next()) {
                playground tmp = new playground();
       // (rs.getInt("id_play"), rs.getString("play_name"), rs.getInt("play_num"));
                tmp.setId_play(rs.getLong("id_play"));
                tmp.setPlay_name( rs.getString("play_name"));
                tmp.setPlay_num(rs.getInt("play_num"));
                 tmp.setPlayvisor(this.getSuperdao().Findplayvisor(tmp.getId_play()));
                playlist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return playlist;

    }

    public void insert(playground play) {
        try {
            PreparedStatement pst =this.getC().prepareStatement("insert into play_ground(id_play,play_name,play_num) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pst.setLong(1,play.getId_play());
            pst.setString(2,play.getPlay_name());
            pst.setInt(3,play.getPlay_num());
            
            pst.executeUpdate();
            
              Long id_play = null;
            ResultSet gk = pst.getGeneratedKeys();
            if (gk.next()) {
                id_play = gk.getLong(1);
            }

            for (supervisor s : play.getPlayvisor()) {
               
                pst = this.getC().prepareStatement("insert into play_visor (id_play ,id_supervisor) values(?,?)");
               
                pst.setLong(1, id_play);
                pst.setLong(2, s.getId_supervisor());
                pst.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void delete(playground play) {
        try {
              PreparedStatement pst = this.getC().prepareStatement("delete from play_visor where id_play=?");
            pst.setLong(1, play.getId_play());
            pst.executeUpdate();
            
            Statement st = getC().createStatement();
            st.executeUpdate("delete from play_ground where id_play="+play.getId_play());
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void update(playground play) {
         try {
            PreparedStatement pst =this.getC().prepareStatement("update play_ground set id_play=?,play_name=?,play_num=? where id_play=?");
            pst.setLong(1,play.getId_play());
            pst.setString(2,play.getPlay_name());
            pst.setInt(3,play.getPlay_num());
             pst.setLong(4,play.getId_play());
            pst.executeUpdate();
              pst = this.getC().prepareStatement("delete from play_visor where id_supervisor=? ");
            pst.setLong(1, play.getId_play());
            
            pst.executeUpdate();

            for (supervisor c : play.getPlayvisor()) {
                
                pst = this.getC().prepareStatement("insert into play_visor (id_play , id_supervisor) values (?,?) ");
                pst.setLong(1, play.getId_play());
                pst.setLong(2, c.getId_supervisor());
                pst.executeUpdate();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
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

    public superDAO getSuperdao() {
        if (this.superdao == null) {
            this.superdao = new superDAO();
        }
        return superdao;
    }
    
}
