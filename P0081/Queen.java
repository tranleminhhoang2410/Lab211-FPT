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
public class Queen extends Bee{

    public Queen() {
    }

    public Queen(String kind) {
        super(kind);
    }

    @Override
    public void checkDead() {
        if(this.health < 20){
            setDead(true);
        }
    }
    
    
}
