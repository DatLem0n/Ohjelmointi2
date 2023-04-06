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
            this.courses.addAll(courses);
        }
    }
    public String toString(){
        String tempStr = "";
        tempStr += String.format("Teacher id: %s \n",super.getIdString());
        tempStr += String.format("\t First name: %s, Last name: %s \n",super.getFirstName(), super.getLastName());
        tempStr += String.format("\t Birthdate: %s\n",super.getBirthDate());
        tempStr += String.format("\t salary: %f\n",this.calculatePayment());
        tempStr += "\t Assistant for courses: \n";
        tempStr += getCourses();
        return tempStr;
    }
}