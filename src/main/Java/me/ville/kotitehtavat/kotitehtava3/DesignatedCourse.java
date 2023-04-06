package main.Java.me.ville.kotitehtavat.kotitehtava3;

import java.time.Year;

public class DesignatedCourse {
    private Course course;
    private boolean responsible;
    private int year;
    private int currentYear = Year.now().getValue();

    DesignatedCourse(){}
    DesignatedCourse(Course course, boolean resp, int year){
        setCourse(course);
        setResponsible(resp);
        setYear(year);
    }
    public Course getCourse(){
        return course;
    }
    public void setCourse (Course course){
        if (course != null){
            this.course = course;
        }
    }
    public boolean isResponsible(){
        return responsible;
    }
    public void setResponsible(boolean responsible){
        this.responsible = responsible;
    }
    public int getYear(){
        return year;
    }
    public void setYear(int year){
        if (year <= currentYear && year >= 2000){
            this.year = year;
        }
    }
    public String toString(){
        return "";
    }
}
