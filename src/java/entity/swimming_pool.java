/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ahmed
 */
public class swimming_pool {
    
    private Long id_pool;
    private int length;
    private int width;
    private int depth;

    public swimming_pool() {
    }

    public swimming_pool(Long id_pool, int length, int width, int depth) {
        this.id_pool = id_pool;
        this.length = length;
        this.width = width;
        this.depth = depth;
    }

    public Long getId_pool() {
        return id_pool;
    }

    public void setId_pool(Long id_pool) {
        this.id_pool = id_pool;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "swimming_pool{" + "id_pool=" + id_pool + ", length=" + length + ", width=" + width + ", depth=" + depth + '}';
    }
    
}
