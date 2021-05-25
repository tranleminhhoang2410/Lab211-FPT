/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0055;

/**
 *
 * @author ADMIN
 */
public class DoctorException extends Exception{
    public DoctorException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage(); 
    }
}
