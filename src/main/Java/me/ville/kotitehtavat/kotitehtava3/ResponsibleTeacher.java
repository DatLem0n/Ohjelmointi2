package main.Java.me.ville.kotitehtavat.kotitehtava3;

import java.util.ArrayList;
import java.util.List;

public class ResponsibleTeacher extends Employee implements Teacher, Payment {
    private List<DesignatedCourse> courses = new ArrayList<>();
    ResponsibleTeacher(String lname, String fname){
        super(lname, fname);
    }
    public String getEmployeeIdString(){
        return "OY_TEACHER_";
    }
    public String getCourses(){
        StringBuilder courseString = new StringBuilder();
        for (DesignatedCourse course:courses){
            if (course.isResponsible()){
                courseString.append("Responsible teacher: ");
            }
            else courseString.append("Teacher: ");

            courseString.append(course.toString()).append("\n");
        }
        return courseString.toString().stripTrailing();
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
        tempStr += String.format("\tSalary: %.2f\n\n",this.calculatePayment());
        tempStr += "\tTeacher for courses:\n";
        tempStr += getCourses(); // this was indented by a tab but pipeline didn't like that
        return tempStr.trim();
    }
}
