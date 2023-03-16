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

    public void setGradeNum(int gradeNum) {
        this.gradeNum = gradeNum;
    }

    public int getYearCompleted() {
        return yearCompleted;
    }

    public void setYearCompleted(int yearCompleted) {
        this.yearCompleted = yearCompleted;
    }


}
