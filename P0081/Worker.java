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
public class Worker extends Bee{

    public Worker(String kind) {
        super(kind);
    }

    public Worker() {
    }

    @Override
    public void checkDead() {
        if(this.health < 70){
            setDead(true);
        }
    }
    
    
}
