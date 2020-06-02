/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;

/**
 *
 * @author Nour
 */
public class playground {
      private Long id_play;
    private String play_name;
    private int play_num;
   private List<supervisor> playvisor;
 
    public playground() {
    }

    public playground(Long id_play, String play_name, int play_num) {
        this.id_play = id_play;
        this.play_name = play_name;
        this.play_num = play_num;
    }

    public Long getId_play() {
        return id_play;
    }

    public void setId_play(Long id_play) {
        this.id_play = id_play;
    }

    public String getPlay_name() {
        return play_name;
    }

    public void setPlay_name(String play_name) {
        this.play_name = play_name;
    }

    public int getPlay_num() {
        return play_num;
    }

    public void setPlay_num(int play_num) {
        this.play_num = play_num;
    }

    public List<supervisor> getPlayvisor() {
        return playvisor;
    }

    public void setPlayvisor(List<supervisor> playvisor) {
        this.playvisor = playvisor;
    }

    
}
