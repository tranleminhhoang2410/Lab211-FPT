/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0056;

/**
 *
 * @author ADMIN
 */
public class SalaryStatus {
    private Boolean increase = true;
    private double newSalary;
    private Worker worker;

    public SalaryStatus(double newSalary, Worker worker) {
        this.newSalary = newSalary;
        this.worker = worker;
    }

    public Boolean isIncrease() {
        return increase;
    }

    public void setIncrease(boolean increase) {
        this.increase = increase;
    }

    public double getNewSalary() {
        return newSalary;
    }

    public void setNewSalary(double newSalary) {
        this.newSalary = newSalary;
    }

    public void setStatus(){
        if(worker.getSalary() > newSalary){
            setIncrease(false);
        }
    }
    
    public String toString() {
        return isIncrease()? "UP" : "DOWN";
    }
    
}
