package main.Java.me.ville.kotitehtavat.kotitehtava2;

import static main.Java.me.ville.kotitehtavat.kotitehtava2.ConstantValues.*;
public class StudentCourse {


    Course course;
    int gradeNum;
    int yearCompleted;

    StudentCourse(){}
    StudentCourse(Course course, final int gradeNum, final int yearCompleted){

    }
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getGradeNum() {
        return gradeNum;
    }

    protected void setGrade(int gradeNum) {
        if(course.isNumericGrade()){

        }
    }
    private boolean checkGradeValidity(final int gradeNum){

    }
    public boolean isPassed(){

    }

    public int getYear() {
        return yearCompleted;
    }

    public void setYear(final int year) {
        yearCompleted = year;
    }


}
