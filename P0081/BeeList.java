/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0081;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class BeeList {
    
    public void showMenu(){
        System.out.println("----BEE----");
        System.out.println("1. Create new bee list.");
        System.out.println("2. Damage bee.");
        System.out.println("3. Quit.");
        System.out.println("Choose an option: ");
    }
    private ArrayList<Bee> beeList = new ArrayList<Bee>();
    private Random r = new Random();
    private Scanner sc = new Scanner(System.in);
    
    public void createBeeList(){
        int count = 10;
        while (count >= 1) {
            Bee[] arrBee = {new Drone("DRONE"), new Worker("WORKER"), new Queen("QUEEN")};
            int randomBee = r.nextInt(arrBee.length);
            Bee b = arrBee[randomBee];
            beeList.add(b);
            count--;
        }
    }
    
    public void display(){
        for(Bee b: beeList){
            System.out.println(b.toString());
        }
    }
    
    public void attack(){
        for(int i = 0; i < 10; i++){
            Bee b = beeList.get(i);
            float randomDamage = r.nextFloat() * 80;
            if(!b.isDead()){
                b.damage(randomDamage);
            }
            b.checkDead();
          
        }
    }

    
}
