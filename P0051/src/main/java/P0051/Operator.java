/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0051;

/**
 *
 * @author Admin
 */
public enum Operator {
    plus ("+"),
    minus ("-"),
    multiply ("*"),
    divide ("/"),
    power ("^"),
    equal ("=");
    
    String value;
    
    private Operator(String value){
        this.value = value;
    }
}
