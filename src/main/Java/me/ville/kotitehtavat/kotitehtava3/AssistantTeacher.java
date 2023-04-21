package main.Java.me.ville.kotitehtavat.kotitehtava3;

import java.util.ArrayList;
import java.util.List;

public class AssistantTeacher extends Employee implements Teacher, Payment{
    private List<DesignatedCourse> courses = new ArrayList<DesignatedCourse>();

    AssistantTeacher(String lname, String fname){
        super(lname, fname);
    }
    public String getEmployeeIdString(){
        return "OY_ASSISTANT_";
    }
    public String getCourses(){
        StringBuilder courseString = new StringBuilder();
        for (DesignatedCourse course:courses){
            courseString.append("\t").append(course.toString()).append("\n");
        }
        return courseString.toString();
    }
    public void setCourses(List<DesignatedCourse> courses){
        if (courses != null){
            this.courses = new ArrayList<>(courses);
        }
    }
    public String toString(){
        String tempStr = String.format("Teacher id: %s\n",super.getIdString());
        tempStr += String.format("\tFirst name: %s, Last name: %s\n",super.getFirstName(), super.getLastName());
        tempStr += String.format("\tBirthdate: %s\n",super.getBirthDate());
        tempStr += String.format("\tSalary: %.2f\n",this.calculatePayment());
        tempStr += "\tAssistant for courses:\n";
        tempStr += getCourses();
        return tempStr.trim();
    }
}
