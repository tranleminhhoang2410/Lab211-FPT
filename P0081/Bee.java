/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0081;

/**
 *
 * @author ADMIN
 */
public abstract class Bee {
    protected String kind;
    protected float health = 100;
    protected boolean dead;
    
    public Bee() {
    }

    public Bee(String kind) {
        this.kind = kind;
    }
    
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
    
    public void damage(float d) {
        if(this.health > d){
            this.setHealth(this.getHealth() - d);
        }else{
            this.setHealth(0);
        }
    }
    
    @Override
    public String toString() {
        if(dead == true){
            return this.kind + " | " + String.format("%.2f", this.health)  + " | " + "Dead";
        }else{
            return this.kind + " | " + String.format("%.2f", this.health)  + " | " + "Alive";
        } 
    }

    public abstract void checkDead();
    
}
