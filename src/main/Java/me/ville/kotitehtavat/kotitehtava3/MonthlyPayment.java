package main.Java.me.ville.kotitehtavat.kotitehtava3;

public class MonthlyPayment implements Payment{
    public double salary;

    public double getSalary(){
        return salary;
    }
    public void setSalary(double salary){
        if (salary > 0.0){
            this.salary = salary;
        }
    }
    public double calculatePayment(){
        return getSalary();
    }
}
