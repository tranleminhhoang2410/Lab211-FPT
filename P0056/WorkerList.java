/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0056;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class WorkerList {
    private HashMap<String, Worker> workerMap = new HashMap<String, Worker>();
    private SalaryHistory history;
    private List<SalaryHistory> historyList = new ArrayList<SalaryHistory>();

    public Worker getWorkerByCode(String code) {
        return workerMap.get(code);
    }

    public boolean addWorker(Worker worker) throws Exception {
        if (workerMap.containsKey(worker.getId()))
            throw new Exception("Code is duplicated");
        if (worker.getId() == null)
            throw new Exception("Code cannot be null");
        if (worker.getAge() < 17 || worker.getAge() > 50)
            throw new Exception("Age must be in range 18 to 50");
        if (worker.getSalary() <= 0)
            throw new Exception("Salary must be greater than 0");
        workerMap.put(worker.getId(), worker);
        return true;
    }

    public boolean changeSalary(SalaryStatus status, String code, double amount) throws Exception {
        if (!workerMap.containsKey(code))
            throw new Exception("Code is not existed");
        if (amount <= 0)
            throw new Exception("Salary must be greater than zero");
        workerMap.get(code).setSalary(amount);
        history = new SalaryHistory(workerMap.get(code), status);
        historyList.add(history);
        return true;
    }

    public List<SalaryHistory> getInformationSalary() {
        return historyList;
    }

    public void printSalaryHistory(List<SalaryHistory> historyList) {
        Collections.sort(historyList,new Comparator<SalaryHistory>(){
            public int compare(SalaryHistory worker1, SalaryHistory worker2){
                return worker1.getWorker().getId().compareTo(worker2.getWorker().getId());
            }
        });
        for (SalaryHistory line : historyList)
            System.out.println(line.toString());
    }
}
