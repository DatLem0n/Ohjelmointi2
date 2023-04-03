package main.Java.me.ville.kotitehtavat.kotitehtava3;

import java.time.Year;
import static main.Java.me.ville.kotitehtavat.kotitehtava3.ConstantValues.*;
abstract class Employee extends Person implements Payment{
    private int currentYear = Year.now().getValue();
    private String empId;
    private int startYear = currentYear;
    private Payment payment;

    Employee(String lname, String fname){
        super(lname, fname);
        empId = getEmployeeIdString() + super.getRandomId(MIN_EMP_ID, MAX_EMP_ID);
    }
    public String getIdString(){
        return empId;
    }
    public int getStartYear(){
        return startYear;
    }
    public void setStartYear(final int startYear) {
        if ((startYear > 2000) && (startYear <= currentYear))  this.startYear = startYear;
    }
    public Payment getPayment(){
        return payment;
    }
    public double calculatePayment(){
        return 0.0; // plsfixthis wöjöldasäkkkkkkkkkkkkkkkkkkkkk
    }
    protected abstract String getEmployeeIdString();

}
