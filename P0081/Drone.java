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
public class Drone extends Bee{

    public Drone() {
    }

    public Drone(String kind) {
        super(kind);
    }

    @Override
    public void checkDead() {
        if(this.health < 50){
            setDead(true);
        }
    }
}
